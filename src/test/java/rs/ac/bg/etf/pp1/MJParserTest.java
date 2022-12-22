package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.MethodTypeName;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

import java.io.*;

public class MJParserTest {
    static Logger logger = LogManager.getLogger(MJParserTest.class);

    public static void main(String[] args) throws Exception {
        File sourceCode = new File("src/test/resources/program.mj");
        if (!sourceCode.exists()) {
            logger.error("Source code file [" + sourceCode.getAbsolutePath() + "] not found!");
            return;
        }

        logger.info("Parsing source file: " + sourceCode.getAbsolutePath());

        try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))) {
            MJLexer mjLexer = new MJLexer(br);
            MJParser mjParser = new MJParser(mjLexer);

            Symbol s = mjParser.parse();  //pocetak parsiranja

            Program program = (Program) (s.value);

            logger.info(program.toString(""));
            logger.info("===================================");

            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
            program.traverseBottomUp(semanticAnalyzer);

            logger.info("Declared #" + semanticAnalyzer.cntStaticVars + " static vars");
            logger.info("Declared #" + semanticAnalyzer.cntArrays + " arrays");

            logger.info("===================================");

            Tab.init();

            Tab.dump();


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
}
