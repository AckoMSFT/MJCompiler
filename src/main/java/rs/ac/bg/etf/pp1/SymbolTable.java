package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static rs.etf.pp1.symboltable.concepts.Obj.*;
import static rs.etf.pp1.symboltable.concepts.Struct.*;

public class SymbolTable extends Tab {
    public static final Struct boolType = new Struct(Struct.Bool);

    public static int LEVEL_GLOBAL = 0;
    public static int LEVEL_LOCAL = 1;
    public static int FP_POS_INVALID = -1;

    public static final String DUMMY_NAME = "dummy";

    public static final int DUMMY_LEVEL = -1;

    public static String[] reservedNames = new String[] {
            "int",
            "char",
            "bool",
            "void",
            "null",
            "eol",
            "chr",
            "ord",
            "len"
    };

    public static String[] allowedConstTypes = new String[] {
            "int",
            "char",
            "bool"
    };

    public static Struct[] basicTypes = new Struct[] {
            SymbolTable.intType,
            SymbolTable.charType,
            SymbolTable.boolType
    };

    public static int[] assignableSymbolTypes = new int[] {
            Obj.Var,
            // Obj.Fld, // For level C only
            Obj.Elem
    };

    public static void init() {
        // Initialize SymbolTable defined in symboltable-1-1.jar
        Tab.init();
        // and afterwards introduce bool type to it.
        currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
    }

    public static String getTypeName(Struct type) {
        if (type == null) {
            return "null";
        }

        if (type.equals(SymbolTable.noType)) {
            return "void";
        }

        switch (type.getKind()) {
            case None:
                return "none";
            case Int:
                return "int";
            case Char:
                return "char";
            case Bool:
                return "bool";
            case Array:
                switch(type.getElemType().getKind()) {
                    case Int:
                        return "Arr of int";
                    case Char:
                        return "Arr of char";
                    case Bool:
                        return "Arr of bool";
                    case None:
                        return "Arr of notype";
                    default:
                        return "NOT_YET_IMPLEMENTED";
                }
            default:
                return "NOT_YET_IMPLEMENTED";
        }
    }

    public static boolean isValidConstType(String type) {
        if (type == null) {
            return false;
        }
        return Arrays.asList(allowedConstTypes).contains(type);
    }

    public static boolean isBasicType(Struct type) {
        if (type == null) {
            return false;
        }
        return Arrays.asList(basicTypes).contains(type);
    }

    public static boolean isValidSymbol(Struct symbol) {
        return symbol != null && symbol != SymbolTable.noType;
    }
    public static boolean isValidSymbol(Obj symbol) {
        return symbol != null && symbol != SymbolTable.noObj;
    }

    public static boolean canAssignToSymbol(Obj symbol) {
        if (symbol == null) {
            return false;
        }

        return Arrays.stream(assignableSymbolTypes).anyMatch(type -> type == symbol.getKind());
    }

    public static boolean isSymbolType(Obj symbol) {
        return symbol != null && symbol.getKind() == Obj.Type;
    }

    public static boolean isReservedName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }

        return Arrays.asList(reservedNames).contains(name);
    }

    public static Obj getSymbol(String name) {
        return getSymbol(name, true);
    }
    public static Obj getSymbol(String name, boolean inCurrentScope) {
        for (Scope scope = currentScope; scope != null; scope = scope.getOuter()) {
            Obj symbol = scope.findSymbol(name);
            if (symbol != null) {
                return symbol;
            }
            if (inCurrentScope) {
                break;
            }
        }
        return null;
    }

    public static String objKindToString(int kind) {
        switch (kind) {
            case Con:
                return "Con";
            case Var:
                return "Var";
            case Type:
                return "Type";
            case Meth:
                return "Meth";
            case Fld:
                return "Fld";
            case Elem:
                return "Elem";
            case Prog:
                return "Prog";
        }

        return "NOT_YET_IMPLEMENTED";
    }

    public static String ObjToString(Obj obj) {
        if (!isValidSymbol(obj)) {
            return "Symbol {null}";
        }

        String name = obj.getName();
        String kind = objKindToString(obj.getKind());
        String type = getTypeName(obj.getType());
        int level = obj.getLevel();
        int fpPos = obj.getFpPos();
        int adr = obj.getAdr();
        return String.format("Symbol {name %s, kind %s, type %s, level %d, fpPos %d, adr %d}",
                name, kind, type, level, fpPos, adr);
    }
}
