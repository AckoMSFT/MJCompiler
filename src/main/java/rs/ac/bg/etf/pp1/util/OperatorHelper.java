package rs.ac.bg.etf.pp1.util;

import rs.ac.bg.etf.pp1.ast.*;

public class OperatorHelper {

    public static String getOperatorCode(AdditionOperator additionOperator) {
        if (additionOperator instanceof AdditionOperatorAddition) {
            return "+";
        }

        if (additionOperator instanceof AdditionOperatorSubtraction) {
            return "-";
        }

        return null;
    }

    public static String getOperatorCode(MultiplicationOperator multiplicationOperator) {
        if (multiplicationOperator instanceof MultiplicationOperatorMultiplication) {
            return "*";
        }

        if (multiplicationOperator instanceof MultiplicationOperatorDivision) {
            return "/";
        }

        if (multiplicationOperator instanceof MultiplicationOperatorModulo) {
            return "%";
        }

        return null;
    }

    public static String getOperatorCode(RelationalOperator relationalOperator) {
        if (relationalOperator instanceof RelationalOperatorEquals) {
            return "==";
        }

        if (relationalOperator instanceof RelationalOperatorNotEquals) {
            return "!=";
        }

        if (relationalOperator instanceof RelationalOperatorGreaterThan) {
            return ">";
        }

        if (relationalOperator instanceof RelationalOperatorGreaterOrEqualThan) {
            return ">=";
        }

        if (relationalOperator instanceof RelationalOperatorLessThan) {
            return "<";
        }

        if (relationalOperator instanceof RelationalOperatorLessOrEqualThan) {
            return "<=";
        }

        return null;
    }
}
