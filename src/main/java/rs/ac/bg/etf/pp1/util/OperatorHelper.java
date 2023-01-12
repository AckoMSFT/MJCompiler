package rs.ac.bg.etf.pp1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;

public class OperatorHelper {

    static Logger logger = LogManager.getLogger(OperatorHelper.class);

    public static String getOperatorCode(AdditionOperator additionOperator) {
        if (additionOperator instanceof AdditionOperatorAddition) {
            return "+";
        }

        if (additionOperator instanceof AdditionOperatorSubtraction) {
            return "-";
        }

        // Should never happen
        logger.error("Unrecognized addition operator detected!!!");
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

        // Should never happen
        logger.error("Unrecognized multiplication operator detected!!!");
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

        // Should never happen
        logger.error("Unrecognized relational operator detected!!!");
        return null;
    }
}
