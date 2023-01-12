package rs.ac.bg.etf.pp1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.ac.bg.etf.pp1.SemanticAnalyzer;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;

public class InstructionHelper {

    static Logger logger = LogManager.getLogger(InstructionHelper.class);

    public static final int BYTE_ARRAY_OP_CODE = 0;
    public static final int WORD_ARRAY_OP_CODE = 1;

    public static int getOperatorCode(AdditionOperator additionOperator) {
        if (additionOperator instanceof AdditionOperatorAddition) {
            return Code.add;
        }

        if (additionOperator instanceof AdditionOperatorSubtraction) {
            return Code.sub;
        }

        // Should never happen
        logger.error("Unrecognized addition operator detected!!!");
        return -1;
    }

    public static int getOperatorCode(MultiplicationOperator multiplicationOperator) {
        if (multiplicationOperator instanceof MultiplicationOperatorMultiplication) {
            return Code.mul;
        }

        if (multiplicationOperator instanceof MultiplicationOperatorDivision) {
            return Code.div;
        }

        if (multiplicationOperator instanceof MultiplicationOperatorModulo) {
            return Code.rem;
        }

        // Should never happen
        logger.error("Unrecognized multiplication operator detected!!!");
        return -1;
    }
    public static int getOperatorCode(RelationalOperator relationalOperator) {
        if (relationalOperator instanceof RelationalOperatorEquals) {
            return Code.eq;
        }

        if (relationalOperator instanceof RelationalOperatorNotEquals) {
            return Code.ne;
        }

        if (relationalOperator instanceof RelationalOperatorGreaterThan) {
            return Code.gt;
        }

        if (relationalOperator instanceof RelationalOperatorGreaterOrEqualThan) {
            return Code.ge;
        }

        if (relationalOperator instanceof RelationalOperatorLessThan) {
            return Code.lt;
        }

        if (relationalOperator instanceof RelationalOperatorLessOrEqualThan) {
            return Code.le;
        }

        // Should never happen
        logger.error("Unrecognized relational operator detected!!!");
        return -1;
    }
}
