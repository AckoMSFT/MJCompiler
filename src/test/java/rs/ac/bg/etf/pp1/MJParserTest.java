package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MJParserTest {
    static Logger logger = LogManager.getLogger(MJParserTest.class);

    public static List<String> findFiles(Path path, String fileExtension)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    // this is a path, not string,
                    // this only test if path end with a certain path
                    //.filter(p -> p.endsWith(fileExtension))
                    // convert path to string first
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


        String foo = sourceCode.getName();
        if (!foo.equalsIgnoreCase("test999.mj")) {
            logger.info("Skipping...");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))) {
            MJLexer mjLexer = new MJLexer(br);
            MJParser mjParser = new MJParser(mjLexer);

            Symbol s = mjParser.parse();  //pocetak parsiranja

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
            //logger.info(s.value);

            Program program = (Program) (s.value);

            logger.info(program.toString(""));
            logger.info("===================================");

            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();

            logger.info("===================================");

            SymbolTable.init();

            program.traverseBottomUp(semanticAnalyzer);

            SymbolTableDumpVisitor stdv = new SymbolTableDumpVisitor();
            SymbolTable.dump(stdv);

            if (semanticAnalyzer.semanticErrorCount > 0) {
                logger.error("Found #" + semanticAnalyzer.semanticErrorCount + " semantic errors. Will not proceed with code generation.");
                return;
            }

            logger.info("Declared #" + semanticAnalyzer.constCount + " const variables.");
            logger.info("Declared #" + semanticAnalyzer.globalVarCount + " global variables.");
            logger.info("Declared #" + semanticAnalyzer.localVarCount + " local variables.");

            logger.info("No semantic error detected. Proceeding with code generation.");

            CodeGenerator codeGenerator = new CodeGenerator();

            Code.mainPc = codeGenerator.getMainPC();


            //RuleVisitor v = new RuleVisitor();
            //program.traverseBottomUp(v);
            //Tab.init();

            //SemanticPass sp = new SemanticPass();
            // program.traverseBottomUp(sp);

            //log.info("===================================");

            // Tab.dump();

         /*   if (!p.errorDetected && sp.passed()) {
                log.info("Parsiranje uspesno zavrseno <3");

                File objFile = new File("src/test/resources/program.obj");
                if (objFile.exists()) {
                    objFile.delete();
                }

                log.info("Generating bytecode file: " + objFile.getAbsolutePath());

                CodeGenerator codeGenerator = new CodeGenerator();
                program.traverseBottomUp(codeGenerator);

                Code.dataSize = sp.nVars;
                Code.mainPc = codeGenerator.getMainPc();

                Code.write(new FileOutputStream(objFile));

                log.info("=============================");
                log.info("   Code generated successfuly :)");
            } else {
                log.error("Parsiranje nije uspesno zavrseno -.-");
            }
            */
        }
    }

    public static void main(String[] args) throws Exception {

        List<String> files = findFiles(Paths.get("src/test/resources"), "mj");
        for (String file: files) {
            ParseFile(file);
        }
    }
}
