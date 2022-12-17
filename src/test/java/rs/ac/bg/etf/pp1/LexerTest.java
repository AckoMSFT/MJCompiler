package rs.ac.bg.etf.pp1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

import java_cup.runtime.Symbol;

public class LexerTest {
    static Logger logger = LogManager.getLogger(LexerTest.class);

    public static void main(String[] args) throws IOException {
        Reader bufferedReader = null;
        try {
            File sourceCode = new File("src/test/resources/acko.mj");

            logger.info("Compiling source code file: " + sourceCode.getAbsolutePath());
            bufferedReader = new BufferedReader(new FileReader(sourceCode));

            MJLexer lexer = new MJLexer(bufferedReader);
            Symbol currentToken;
            while ((currentToken = lexer.next_token()).sym != sym.EOF) {
                if (currentToken.value != null) {
                    logger.info("Recognized token with id " + currentToken + " with value " + currentToken.value);
                }
            }
        } finally {
            if (bufferedReader != null) try {
                bufferedReader.close();
            } catch (IOException ioException) {
                logger.error(ioException.getMessage(), ioException);
            }
        }
    }
}
