package rs.ac.bg.etf.pp1.util;

import rs.ac.bg.etf.pp1.sym;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LexerUtils {

    public static String GetLexicalIdentifier(String id) {
        // Extract identifiers from sym.java
        HashMap<String, String> map = new HashMap<>();
        Field[] declaredFields = sym.class.getDeclaredFields();
        List<Field> staticFields = new ArrayList<>();
        for (Field field : declaredFields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                staticFields.add(field);
                field.setAccessible(true);
                try {
                    Integer value = (Integer) field.get(sym.class);
                    map.put("#" + value, field.getName());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return map.get(id);
    }
}
