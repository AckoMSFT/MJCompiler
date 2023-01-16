package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Disassemble;
import rs.etf.pp1.mj.runtime.Code;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MJParserTest {

    static Logger logger = LogManager.getLogger(MJParserTest.class);

    private static final String TEST_CASES_ROOT_DIRECTORY = "src/test/resources";
    private static final String TEST_CASES_DUMP_DIRECTORY = "test_cases_dump";
    private static final String MICRO_JAVA_FILE_EXTENSION = "mj";

    public static List<String> findFiles(Path path, String fileExtension)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(fileExtension))
                    .collect(Collectors.toList());
        }

        return result;
    }

    public static void ParseFile(String sourceCodePath) throws Exception {
        File sourceCode = new File(sourceCodePath);
        if (!sourceCode.exists()) {
            logger.error("Source code file [" + sourceCode.getAbsolutePath() + "] not found!");
            return;
        }

        logger.info("Parsing source file: " + sourceCode.getAbsolutePath());

        try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))) {
            MJLexer mjLexer = new MJLexer(br);
            MJParser mjParser = new MJParser(mjLexer);

            Symbol s = mjParser.parse();

            if (mjParser.fatalErrorDected) {
                logger.error("Detected fatal error while parsing [" + sourceCode.getAbsolutePath() + "]. " +
                        "Will not proceed with semantic analysis and code generation.");
                return;
            }

            if (mjParser.recoveredFromErrorCount > 0) {
                logger.error("Managed to recover from #" + mjParser.recoveredFromErrorCount + " syntax error(s). Will print AST, but " +
                        "will not proceed with semantic analysis and code generation.");

                Program program = (Program) (s.value);
                logger.info(program.toString(""));

                return;
            }

            logger.info("No syntax errors detected, parsing completed successfully! :)");

            Program program = (Program) (s.value);

            logger.info(program.toString(""));
            logger.info("============================================================================================");

            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();

            SymbolTable.init();

            program.traverseBottomUp(semanticAnalyzer);

            SymbolTableDumpVisitor stdv = new SymbolTableDumpVisitor();
            SymbolTable.dump(stdv);

            logger.info("============================================================================================");

            logger.info("Declared #" + semanticAnalyzer.constCount + " const variables.");
            logger.info("Declared #" + semanticAnalyzer.globalVarCount + " global variables.");
            logger.info("Declared #" + semanticAnalyzer.localVarCount + " local variables.");

            if (semanticAnalyzer.semanticErrorCount > 0) {
                logger.error("Found #" + semanticAnalyzer.semanticErrorCount + " semantic errors. Will not proceed with code generation.");
                return;
            }

            logger.info("============================================================================================");

            logger.info("No semantic error detected. Proceeding with code generation.");

            CodeGenerator codeGenerator = new CodeGenerator();
            program.traverseBottomUp(codeGenerator);


            File objFile = new File(sourceCodePath.replace(".mj", ".obj"));
            if (objFile.exists()) {
                objFile.delete();
            }

            Code.write(new FileOutputStream(objFile));

            // Disassemble (for debugging purposes)

            Disassemble disassemble = new Disassemble();

            InputStream ss = new FileInputStream(objFile);
            byte[] code = new byte[8206];
            int len = ss.read(code);
            disassemble.code = code;
            disassemble.off = 14;
            disassemble.cur = 14;
            disassemble.decode(code, len);
        }
    }

    public static void main(String[] args) throws Exception {

        boolean testSingle = false;
        boolean skipTestCasesDump = true;
        String testFile = "src\\test\\resources\\acko.mj";

        List<String> files = findFiles(Paths.get(TEST_CASES_ROOT_DIRECTORY), MICRO_JAVA_FILE_EXTENSION);
        for (String file: files) {
            if (((testSingle && !file.equalsIgnoreCase(testFile))) ||
                    (skipTestCasesDump && file.contains(TEST_CASES_DUMP_DIRECTORY))) {
                logger.info("Skipping... " + file);
            } else {
                ParseFile(file);
            }
        }
    }
}
