package rs.ac.bg.etf.pp1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java_cup.runtime.Symbol;

public class MJLexerTest {
    static Logger logger = LogManager.getLogger(MJLexerTest.class);

    public static void main(String[] args) throws IOException {
        Reader bufferedReader = null;
        try {
            File sourceCode = new File("src/test/resources/acko.mj");

            logger.info("Compiling source code file: " + sourceCode.getAbsolutePath());
            bufferedReader = new BufferedReader(new FileReader(sourceCode));

            MJLexer lexer = new MJLexer(bufferedReader);
            Symbol currentToken;

            // Extract identifiers from sym.java
            HashMap<String, String> id = new HashMap<>();
            Field[] declaredFields = sym.class.getDeclaredFields();
            List<Field> staticFields = new ArrayList<>();
            for (Field field : declaredFields) {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    staticFields.add(field);
                    field.setAccessible(true);
                    try {
                        Integer value = (Integer) field.get(sym.class);
                        id.put("#" + value, field.getName());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            while ((currentToken = lexer.next_token()).sym != sym.EOF) {
                if (currentToken.value != null) {
                    logger.info("Recognized token with id: [" + id.get(currentToken.toString()) +
                            "] and value: [" + currentToken.value + "] on line: " + currentToken.left +
                            " and column: " + currentToken.right);
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
