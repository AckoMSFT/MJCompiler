package rs.ac.bg.etf.pp1.util;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;

public class ErrorMessageGenerator {
    public enum MessageType {
        /* Debug */
        SYNTAX_NODE_TRAVERSAL,
        DEBUG_SYMBOL_MESSAGE,
        /* Info */
        CONST_DECLARATION,
        GLOBAL_VARIABLE_DECLARATION,
        LOCAL_VARIABLE_DECLARATION,
        FORMAL_PARAMETER_DECLARATION,
        /* Warning */
        NAME_SHADOWING_RESERVED_NAME,
        /* Error */
        SYMBOL_ALREADY_IN_USE,
        RETURN_STATEMENT_NOT_FOUND,
        MAIN_METHOD_NOT_FOUND,
        MAIN_METHOD_RETURN_TYPE_MISMATCH,
        MAIN_METHOD_ARGUMENT_MISMATCH,
        TYPE_MISMATCH,
        INCOMPATIBLE_TYPES,
        ILLEGAL_RELATIONAL_OPERATOR,
        ADDITIONAL_ERROR_DESCRIPTION,
        ILLEGAL_BREAK_STATEMENT,
        ILLEGAL_CONTINUE_STATEMENT,
        ILLEGAL_RETURN_STATEMENT,
        NOT_A_BASIC_TYPE,
        NON_VOID_RETURN_STATEMENT_INSIDE_VOID_FUNCTION,
        INCOMPATIBLE_RETURN_TYPE,
        CLASS_MEMBER_DESIGNATOR_NOT_SUPPORTED,
        INCOMPATIBLE_ARRAY_INDEX_TYPE,
        NON_ONE_DIMENSIONAL_ARRAY_DETECTED,
        UNDEFINED_SYMBOL,
        DETECTED_SYMBOL_USAGE,
        NON_BASIC_TYPE_READ,
        NON_ASSIGNABLE_SYMBOL,
        CLASS_INSTANTIATION_NOT_SUPPORTED,
        CLASS_DECLARATION_NOT_SUPPORTED,
    }

    public static String generateMessage(MessageType messageType, Object... params) {
        String name, type, actualType, expectedType, lhsType, rhsType, relationalOperator, additionalErrorDescription;
        String debugMessage, symbol, symbolDescription;
        SYMBOL_TYPE symbolType;
        switch (messageType) {
            case SYNTAX_NODE_TRAVERSAL:
                SyntaxNode syntaxNode = (SyntaxNode) params[0];
                return String.format("Traversing syntax node %s.", syntaxNode.getClass().getSimpleName());
            case DEBUG_SYMBOL_MESSAGE:
                debugMessage = (String) params[0];
                symbol = (String) params[1];
                return String.format("%s. %s.", debugMessage, symbol);
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
            case FORMAL_PARAMETER_DECLARATION:
                name = (String) params[0];
                type = (String) params[1];
                return String.format("Declared formal parameter %s of type %s.", name, type);
            case SYMBOL_ALREADY_IN_USE:
                String symbolName = (String) params[0];
                return String.format("Symbol %s is already in use.", symbolName);
            case RETURN_STATEMENT_NOT_FOUND:
                name = (String) params[0];
                return String.format("No return statement in method %s.", name);
            case MAIN_METHOD_NOT_FOUND:
                return "Program must have a main function with return type void and no arguments.";
            case MAIN_METHOD_RETURN_TYPE_MISMATCH:
                type = (String) params[0];
                return String.format("Program must have a main function with return type void. Declared function is of type %s.", type);
            case MAIN_METHOD_ARGUMENT_MISMATCH:
                return "Main function is declared with arguments, it shouldn't have any arguments.";
            case TYPE_MISMATCH:
                actualType = (String) params[0];
                expectedType = (String) params[1];
                return String.format("Type mismatch. Expected type %s, actual type %s.", expectedType, actualType);
            case INCOMPATIBLE_TYPES:
                lhsType = (String) params[0];
                rhsType = (String) params[1];
                return String.format("Incompatible types. Lhs type %s, rhs type %s.", lhsType, rhsType);
            case INCOMPATIBLE_RETURN_TYPE:
                actualType = (String) params[0];
                expectedType = (String) params[1];
                return String.format("Incompatible return type. Expected type %s, actual type %s.", expectedType, actualType);
            case ILLEGAL_RELATIONAL_OPERATOR:
                lhsType = (String) params[0];
                relationalOperator = (String) params[1];
                return String.format("Relational operator %s cannot be applied to lhs with type %s.", relationalOperator, lhsType);
            case ADDITIONAL_ERROR_DESCRIPTION:
                additionalErrorDescription = (String) params[0];
                return additionalErrorDescription;
            case ILLEGAL_RETURN_STATEMENT:
                return "Return statement not bound to any method.";
            case ILLEGAL_BREAK_STATEMENT:
                return "Break statement not bound to any loop.";
            case ILLEGAL_CONTINUE_STATEMENT:
                return "Continue statement not bound to any loop.";
            case NAME_SHADOWING_RESERVED_NAME:
                name = (String) params[0];
                return String.format("Name shadowing detected for reserved name %s.", name);
            case NOT_A_BASIC_TYPE:
                actualType = (String) params[0];
                return String.format("Expression must have a basic type (int, char, bool). Actual type is %s.", actualType);
            case NON_VOID_RETURN_STATEMENT_INSIDE_VOID_FUNCTION:
                actualType = (String) params[0];
                return String.format("Non-void return statement found inside a void function. Actual type is %s.", actualType);
            case CLASS_MEMBER_DESIGNATOR_NOT_SUPPORTED:
                return "Class member access operator detected. This is not supported in Acko's MJCompiler since it's not done for level C.";
            case CLASS_INSTANTIATION_NOT_SUPPORTED:
                return "Class instantiation detected. This is not supported in Acko's MJCompiler since it's not done for level C.";
            case CLASS_DECLARATION_NOT_SUPPORTED:
                return "Class declaration detected. This is not supported in Acko's MJCompiler since it's not done for level C.";
            case INCOMPATIBLE_ARRAY_INDEX_TYPE:
                actualType = (String) params[0];
                return String.format("Array index must be of type int. Actual type %s.", actualType);
            case NON_ONE_DIMENSIONAL_ARRAY_DETECTED:
                return "Detected array indexing of a multi-dimensional array. Only one-dimesional arrays are allowed.";
            case UNDEFINED_SYMBOL:
                name = (String) params[0];
                return String.format("Detected usage of undefined symbol with name %s.", name);
            case DETECTED_SYMBOL_USAGE:
                name = (String) params[0];
                symbolType = (SYMBOL_TYPE) params[1];
                actualType = GetSymbolTypeName(symbolType);
                symbolDescription = (String) params[2];
                return String.format("Detected symbol usage. Name %s, symbol type %s. %s.", name, actualType, symbolDescription);
            case NON_BASIC_TYPE_READ:
                actualType = (String) params[1];
                return String.format("You can only read basic types (int, char, bool). Actual type is %s.", actualType);
            case NON_ASSIGNABLE_SYMBOL:
                symbol = (String) params[0];
                return String.format("Cannot assign value to %s. You can only assign value to Var and Elem symbol types.", symbol);
            default:
                return "NOT_YET_IMPLEMENTED";
        }
    }

    public enum SYMBOL_TYPE {
        SYMBOLIC_CONSTANT,
        GLOBAL_VARIABLE,
        LOCAL_VARIABLE,
        FORMAL_PARAMETER,
        GLOBAL_FUNCTION_CALL,
        ARRAY_ELEMENT_ACCESS,
    }

    public static String GetSymbolTypeName(SYMBOL_TYPE symbolType) {
        switch (symbolType) {
            case SYMBOLIC_CONSTANT:
                return "symbolic constant";
            case GLOBAL_VARIABLE:
                return "global variable";
            case LOCAL_VARIABLE:
                return "local variable";
            case FORMAL_PARAMETER:
                return "formal parameter";
            case GLOBAL_FUNCTION_CALL:
                return "global function call";
            case ARRAY_ELEMENT_ACCESS:
                return "array element access";
            default:
                return "NOT_YET_IMPLEMENTED";
        }
    }
}
