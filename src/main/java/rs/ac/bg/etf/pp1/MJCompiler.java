package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;

import java.io.*;


public class MJCompiler {
    static Logger logger = LogManager.getLogger(MJCompiler.class);

    public static void tsdump() {
        SymbolTableDumpVisitor stdv = new SymbolTableDumpVisitor();
        SymbolTable.dump(stdv);
    }

    public static void main(String[] args) throws Exception {
        logger.info("Hi! I am Acko's MJCompiler. Nice to meet you.");

        int argsLen = args.length;
        if (argsLen != 2) {
            logger.error("You must pass in exactly two arguments sourceCodePath and objFilePath");
            return;
        }

        String sourceCodePath = args[0];
        String objFilePath = args[1];

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

            logger.info("Symbol table dump:");

            tsdump();

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


            File objFile = new File(objFilePath);
            if (objFile.exists()) {
                objFile.delete();
            }

            Code.write(new FileOutputStream(objFile));
        }
    }
}
