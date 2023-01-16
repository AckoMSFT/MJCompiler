package rs.ac.bg.etf.pp1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java_cup.runtime.Symbol;

public class MJLexerTest {
    static Logger logger = LogManager.getLogger(MJLexerTest.class);

    private static final String TEST_CASES_ROOT_DIRECTORY = "src/test/resources";
    private static final String MICRO_JAVA_FILE_EXTENSION = "mj";

    private static List<String> findFiles(Path path, String fileExtension)
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

    private static void runLexerTest(String file) throws IOException {

        Reader bufferedReader = null;
        try {
            File sourceCode = new File(file);

            logger.info("Running lexer on source code file: " + sourceCode.getAbsolutePath());
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

    public static void main(String[] args) throws IOException {

        List<String> files = findFiles(Paths.get(TEST_CASES_ROOT_DIRECTORY), MICRO_JAVA_FILE_EXTENSION);
        for (String file: files) {
            runLexerTest(file);
        }
    }
}
