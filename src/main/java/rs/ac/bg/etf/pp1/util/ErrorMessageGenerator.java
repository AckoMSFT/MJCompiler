package rs.ac.bg.etf.pp1.util;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;

public class ErrorMessageGenerator {
    public enum MessageType {
        /* Debug */
        SYNTAX_NODE_TRAVERSAL,
        /* Info */
        CONST_DECLARATION,
        GLOBAL_VARIABLE_DECLARATION,
        LOCAL_VARIABLE_DECLARATION,
        /* Warning */
        /* Error */
        SYMBOL_ALREADY_IN_USE,
        RETURN_STATEMENT_OUTSIDE_OF_METHOD,
        RETURN_STATEMENT_NOT_FOUND,
        MAIN_METHOD_NOT_FOUND,
        MAIN_METHOD_RETURN_TYPE_MISMATCH,
        MAIN_METHOD_ARGUMENT_MISMATCH,
    }

    public static String generateMessage(MessageType messageType, Object... params) {
        String name, type;
        switch (messageType) {
            case SYNTAX_NODE_TRAVERSAL:
                SyntaxNode syntaxNode = (SyntaxNode) params[0];
                return String.format("Traversing syntax node %s.", syntaxNode.getClass().getSimpleName());
            case CONST_DECLARATION:
                name = (String) params[0];
                type = (String) params[1];
                int value = (int) params[2];
                return String.format("Declared constant %s of type %s and value %d.", name, type, value);
            case GLOBAL_VARIABLE_DECLARATION:
                name = (String) params[0];
                type = (String) params[1];
                return String.format("Declared global variable %s of type %s.", name, type);
            case LOCAL_VARIABLE_DECLARATION:
                name = (String) params[0];
                type = (String) params[1];
                return String.format("Declared local variable %s of type %s.", name, type);
            case SYMBOL_ALREADY_IN_USE:
                String symbolName = (String) params[0];
                return String.format("Symbol %s is already in use.", symbolName);
            case RETURN_STATEMENT_OUTSIDE_OF_METHOD:
                return "Return statement found outside of method.";
            case RETURN_STATEMENT_NOT_FOUND:
                name = (String) params[0];
                return String.format("No return statement in method %s.", name);
            case MAIN_METHOD_NOT_FOUND:
                return "Program must have a main function with return type void and no arguments.";
            case MAIN_METHOD_RETURN_TYPE_MISMATCH:
                type = (String) params[0];
                return String.format("Program must have a main function with return type void. Declared function is of type %s.", type);
            case MAIN_METHOD_ARGUMENT_MISMATCH:
                return String.format("Main function is declared with arguments, it shouldn't have any arguments.");
            default:
                return "NOT_YET_IMPLEMENTED";
        }
    }
}
