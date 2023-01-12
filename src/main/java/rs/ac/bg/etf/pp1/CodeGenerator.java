package rs.ac.bg.etf.pp1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.util.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.ArrayList;
import java.util.Objects;

import static rs.ac.bg.etf.pp1.SymbolTable.DUMMY_LEVEL;
import static rs.ac.bg.etf.pp1.SymbolTable.DUMMY_NAME;
import static rs.ac.bg.etf.pp1.util.InstructionHelper.BYTE_ARRAY_OP_CODE;
import static rs.ac.bg.etf.pp1.util.InstructionHelper.WORD_ARRAY_OP_CODE;

public class CodeGenerator extends VisitorAdaptor {

    private static int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int MINUS_ONE = -1;

    private static final int TRUE = 1;
    private static final int FALSE = 0;

    private static final String AND = "&&";

    private static final String OR = "||";

    private static final String MAIN_METHOD_NAME = "main";

    private static final int UNCONDITIONAL_JUMP = 0;

    Logger logger = LogManager.getLogger(CodeGenerator.class);

    private int runtimeErrorCount = 0;

    private Obj programSymbol = SymbolTable.noObj;

    private BranchJumpAddressStack branchJumpAddressStack;

    private LoopJumpAddressStack loopJumpAddressStack;

    CodeGenerator() {
        // Reset static variables
        Code.pc = 0;
        Code.mainPc = -1;
        Code.dataSize = 0;
        Code.greska = false;

        // Add built-in method char chr(int e)
        SymbolTable.chrObj.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.exit);
        Code.put(Code.return_);

        // Add build-in method int ord(char c)
        SymbolTable.ordObj.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.exit);
        Code.put(Code.return_);

        // Add built-in method int len(char arr[]) / int len(int arr[])
        SymbolTable.lenObj.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.arraylength);
        Code.put(Code.exit);
        Code.put(Code.return_);

        // Initialize private members
        branchJumpAddressStack = new BranchJumpAddressStack();
        //loopJumpAddressStack = new JumpAddressStack();
        loopJumpAddressStack = new LoopJumpAddressStack();
    }

    private void logInfo(SyntaxNode syntaxNode, ErrorMessageGenerator.MessageType messageType, Object... params) {
        String message = ErrorMessageGenerator.generateMessage(messageType, params);
        logger.info(String.format("[Line #%d] %s", syntaxNode.getLine(), message));
    }

    private void logDebug(SyntaxNode syntaxNode, ErrorMessageGenerator.MessageType messageType, Object... params) {
        String message = ErrorMessageGenerator.generateMessage(messageType, params);
        logger.debug(String.format("[Line #%d] %s", syntaxNode.getLine(), message));
    }

    private void logWarning(SyntaxNode syntaxNode, ErrorMessageGenerator.MessageType messageType, Object... params) {
        String message = ErrorMessageGenerator.generateMessage(messageType, params);
        logger.warn(String.format("[Line #%d] %s", syntaxNode.getLine(), message));
    }

    private void logError(SyntaxNode syntaxNode, ErrorMessageGenerator.MessageType messageType, Object... params) {
        runtimeErrorCount++;
        String message = ErrorMessageGenerator.generateMessage(messageType, params);
        logger.error(String.format("[Line #%d] Semantic error: %s", syntaxNode.getLine(), message));
    }

    private void logSyntaxNodeTraversal(SyntaxNode syntaxNode) {
        logDebug(syntaxNode, ErrorMessageGenerator.MessageType.SYNTAX_NODE_TRAVERSAL, syntaxNode);
    }

    private void logDebugMessage(SyntaxNode syntaxNode, String debugMessage) {
        logDebug(syntaxNode, ErrorMessageGenerator.MessageType.DEBUG_MESSAGE, debugMessage);
    }

    private void logDebugOperationMessage(SyntaxNode syntaxNode, String debugMessage, String operation)
    {
        logDebug(syntaxNode, ErrorMessageGenerator.MessageType.DEBUG_OPERATION_MESSAGE, debugMessage, operation);
    }

    private void logSymbolDebugMessage(SyntaxNode syntaxNode, String debugMessage, Obj symbol) {
        String symbolString = SymbolTable.ObjToString(symbol);
        logDebug(syntaxNode, ErrorMessageGenerator.MessageType.DEBUG_SYMBOL_MESSAGE, debugMessage, symbolString);
    }

    /****************************************** Program ***************************************************************/

    @Override
    public void visit(ProgramName programName) {
        logSyntaxNodeTraversal(programName);

        programSymbol = programName.obj;
    }

    @Override
    public void visit(Program program) {
        logSyntaxNodeTraversal(program);

        // TODO (acko): Check if PC has exceeded max code size
        programSymbol = SymbolTable.noObj;
    }

    /****************************************** Program ***************************************************************/

    /****************************************** Methods ***************************************************************/

    public void visit(MethodDeclarationHeader methodDeclarationHeader) {
        logSyntaxNodeTraversal(methodDeclarationHeader);

        String methodName = methodDeclarationHeader.getMethodName();

        if (MAIN_METHOD_NAME.equals(methodName)) {
            logDebugMessage(methodDeclarationHeader, "Detected mainPc = " + Code.pc);
            Code.mainPc = Code.pc;
        }

        Obj methodSymbol = methodDeclarationHeader.obj;
        int methodLevel = methodSymbol.getLevel();
        int methodSymbolCount = methodSymbol.getLocalSymbols().size();

        logDebugMessage(methodDeclarationHeader, String.format("Generated enter instruction for method %s, " +
                "level %d, symbolCount %d", methodName, methodLevel, methodSymbolCount));

        Code.put(Code.enter);
        Code.put(methodLevel);
        Code.put(methodSymbolCount);
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        logSyntaxNodeTraversal(methodDeclaration);

        MethodDeclarationHeader methodDeclarationHeader = methodDeclaration.getMethodDeclarationHeader();
        ReturnType returnType = methodDeclarationHeader.getReturnType();

        Struct methodReturnType = returnType.struct;
        if (methodReturnType.equals(SymbolTable.noType)) {
            logDebugMessage(methodDeclaration, "Generating exit and return_ instructions to always properly " +
                    "return from method which has no return value");

            Code.put(Code.exit);
            Code.put(Code.return_);
        } else {
            logDebugMessage(methodDeclaration, "Generating trap instruction to make sure we have a runtime error " +
                    "if we do not return properly from a method which has a return value");

            Code.put(Code.trap);
            Code.put(ONE);
        }
    }

    /****************************************** Methods ***************************************************************/

    @Override
    public void visit(FunctionInvocation functionInvocation) {
        logSyntaxNodeTraversal(functionInvocation);

        FactorFunctionInvocation factorFunctionInvocation = (FactorFunctionInvocation) functionInvocation.getParent();
        Designator designator = factorFunctionInvocation.getFunctionInvocationHeader().getDesignator();
        Obj methodSymbol = designator.obj;

        //System.out.println("FUNCTION INVOCATION ASDASDASASDASDA " + SymbolTable.ObjToString(methodSymbol));
        //System.out.println(methodSymbol.getAdr());
        //System.out.println(methodSymbol.getAdr() - Code.pc + 1);

        Code.put(Code.call);
        Code.put2(methodSymbol.getAdr() - Code.pc + 1);
    }

    /****************************************** Global variables ******************************************************/

    @Override
    public void visit(VariableDeclaration variableDeclaration) {
        logSyntaxNodeTraversal(variableDeclaration);

        Obj globalVariableSymbol = programSymbol.getLocalSymbols().stream().
        filter(s -> Objects.equals(s.getName(), variableDeclaration.getVariableName())).findAny().get();

        globalVariableSymbol.setAdr(Code.dataSize++);

        logSymbolDebugMessage(variableDeclaration, "Added global variable to StaticData " +
                "memory section", globalVariableSymbol);
    }

    /****************************************** Global variables ******************************************************/

    /****************************************** Condition *************************************************************/

    @Override
    public void visit(ConditionMulti conditionMulti) {
        logSyntaxNodeTraversal(conditionMulti);

        Condition condition = conditionMulti.getCondition();
        CondTerm condTerm = conditionMulti.getCondTerm();

        Obj conditionSymbol = condition.obj;
        Obj condTermSymbol = condTerm.obj;

        int condTermValue = condTermSymbol.getAdr();
        int condTermLevel = condTermSymbol.getLevel();

        ArrayList<String> parts = new ArrayList<>();
        parts.add(conditionSymbol.getName());
        parts.add(OR);
        parts.add(String.valueOf(condTermValue));

        String name = String.join(" ", parts);
        Obj conditionMultiSymbol = new Obj(Obj.Con, name, SymbolTable.boolType, condTermValue, condTermLevel);
        int conditionMultiValue = conditionMultiSymbol.getAdr();

        logSymbolDebugMessage(conditionMulti, "Generated ConditionMulti", conditionMultiSymbol);

        conditionMulti.obj = conditionMultiSymbol;

        SyntaxNode parent = condTerm.getParent();
        if (parent instanceof ConditionMulti) {
            logDebugMessage(conditionMulti, "This is not the last Term in the Condition. Need to add a true branch jump");

            Code.put(Code.jcc + conditionMultiValue);
            Code.put2(ZERO - Code.pc + ONE);
            branchJumpAddressStack.pushTrueJump(Code.pc - TWO);
        }
    }

    @Override
    public void visit(ConditionSingle conditionSingle) {
        logSyntaxNodeTraversal(conditionSingle);

        CondTerm condTerm = conditionSingle.getCondTerm();
        Obj condTermSymbol = condTerm.obj;
        int condTermValue = condTermSymbol.getAdr();

        conditionSingle.obj = condTermSymbol;

        logSymbolDebugMessage(conditionSingle, "Propagating CondTerm symbol to ConditionSingle", condTermSymbol);

        SyntaxNode parent = condTerm.getParent();
        if (parent instanceof ConditionMulti) {
            logDebugMessage(conditionSingle, "This is not the last Term in the Condition. Need to add a true branch jump");

            Code.put(Code.jcc + condTermValue);
            Code.put2(ZERO - Code.pc + ONE);
            branchJumpAddressStack.pushTrueJump(Code.pc - TWO);
        }
    }

    /****************************************** Condition *************************************************************/

    /****************************************** Cond Term *************************************************************/

    @Override
    public void visit(CondTermMulti condTermMulti) {
        logSyntaxNodeTraversal(condTermMulti);

        CondTerm condTerm = condTermMulti.getCondTerm();
        CondFact condFact = condTermMulti.getCondFact();

        Obj condTermSymbol = condTerm.obj;
        Obj condFactSymbol = condFact.obj;

        int condFactValue = condFactSymbol.getAdr();
        int condFactLevel = condFactSymbol.getLevel();

        ArrayList<String> parts = new ArrayList<>();
        parts.add(condTermSymbol.getName());
        parts.add(AND);
        parts.add(String.valueOf(condFactValue));

        String name = String.join(" ", parts);
        Obj condTermMultiSymbol = new Obj(Obj.Con, name, SymbolTable.boolType, condFactValue, condFactLevel);
        int condTermMultiValue = condTermMultiSymbol.getAdr();

        condTermMulti.obj = condTermMultiSymbol;
        logSymbolDebugMessage(condTermMulti, "Generated CondTermMulti", condTermMultiSymbol);

        SyntaxNode parent = condFact.getParent();
        if (parent instanceof CondTermMulti) {
            logDebugMessage(condTermMulti, "This is not the last Factor in the Term. Need to add a false branch jump");
            Code.putFalseJump(condTermMultiValue, ZERO);
            branchJumpAddressStack.pushFalseJump(Code.pc - TWO);
        }
    }

    @Override
    public void visit(CondTermSingle condTermSingle) {
        logSyntaxNodeTraversal(condTermSingle);

        CondFact condFact = condTermSingle.getCondFact();
        Obj condFactSymbol = condFact.obj;

        int condFactValue = condFactSymbol.getAdr();
        condTermSingle.obj = condFactSymbol;

        logSymbolDebugMessage(condTermSingle, "Propagating CondFact symbol to CondTermSingle", condFactSymbol);

        SyntaxNode parent = condFact.getParent();
        if (parent instanceof CondTermMulti) {
            logDebugMessage(condTermSingle, "This is not the last Factor in the Term. Need to add a false branch jump");
            Code.putFalseJump(condFactValue, ZERO);
            branchJumpAddressStack.pushFalseJump(Code.pc - TWO);
        }
    }

    /****************************************** Cond Term *************************************************************/

    /****************************************** Cond Fact *************************************************************/

    @Override
    public void visit(CondFactMulti condFactMulti) {
        logSyntaxNodeTraversal(condFactMulti);

        Expr lhsExpr = condFactMulti.getExpr();
        Expr rhsExpr = condFactMulti.getExpr1();
        RelationalOperator relationalOperator = condFactMulti.getRelationalOperator();

        int relationalOperationCode = InstructionHelper.getOperatorCode(relationalOperator);
        String relationalOperation = OperatorHelper.getOperatorCode(relationalOperator);

        Obj lhsExprSymbol = lhsExpr.obj;
        Obj rhsExprSymbol = rhsExpr.obj;

        ArrayList<String> parts = new ArrayList<>();
        parts.add(lhsExprSymbol.getName());
        parts.add(relationalOperation);
        parts.add(rhsExprSymbol.getName());

        String name = String.join(" ", parts);

        Obj condFactMultiSymbol = new Obj(Obj.Con, name, SymbolTable.boolType, relationalOperationCode, DUMMY_LEVEL);
        condFactMulti.obj = condFactMultiSymbol;

        logSymbolDebugMessage(condFactMulti, "Performing relational operation", condFactMultiSymbol);
    }

    @Override
    public void visit(CondFactSingle condFactSingle) {
        logSyntaxNodeTraversal(condFactSingle);

        Expr expr = condFactSingle.getExpr();
        Obj exprSymbol = expr.obj;

        String condFactSingleSymbolName = exprSymbol.getName();
        Obj condFactSingleSymbol = new Obj(Obj.Con, condFactSingleSymbolName, SymbolTable.boolType, Code.ne, DUMMY_LEVEL);
        condFactSingle.obj = condFactSingleSymbol;

        logSymbolDebugMessage(condFactSingle, "Loading boolean constant false for comparison with Expr [Expr neq false]", condFactSingleSymbol);
        Code.loadConst(FALSE);
    }

    /****************************************** Cond Fact *************************************************************/

    /****************************************** Expr ******************************************************************/

    @Override
    public void visit(ExprMulti exprMulti) {
        logSyntaxNodeTraversal(exprMulti);

        AdditionOperator additionOperator = exprMulti.getAdditionOperator();
        int additionOperatorCode = InstructionHelper.getOperatorCode(additionOperator);
        String additionOperation = OperatorHelper.getOperatorCode(additionOperator);

        logDebugOperationMessage(exprMulti, "Generating addition operation", additionOperation);
        Code.put(additionOperatorCode);
    }

    @Override
    public void visit(ExprSingle exprSingle) {
        logSyntaxNodeTraversal(exprSingle);

        Sign sign = exprSingle.getSign();
        if (sign instanceof SignNegative) {
            logDebugMessage(exprSingle, "Generating instruction for negation since Sign is SignNegative");
            Code.put(Code.neg);
        }
    }

    /****************************************** Expr ******************************************************************/

    /****************************************** Term ******************************************************************/

    @Override
    public void visit(TermMulti termMulti) {
        logSyntaxNodeTraversal(termMulti);

        MultiplicationOperator multiplicationOperator = termMulti.getMultiplicationOperator();
        int multiplicationOperatorCode = InstructionHelper.getOperatorCode(multiplicationOperator);
        String multiplicationOperation = OperatorHelper.getOperatorCode(multiplicationOperator);

        logDebugOperationMessage(termMulti, "Generating multiplication operation", multiplicationOperation);
        Code.put(multiplicationOperatorCode);
    }

    @Override
    public void visit(TermSingle termSingle) {
        logSyntaxNodeTraversal(termSingle);

        Factor factor = termSingle.getFactor();
        Obj factorSymbol = factor.obj;

        termSingle.obj = factorSymbol;
        logSymbolDebugMessage(termSingle, "Propagating Factor symbol to TermSingle", factorSymbol);
    }

    /****************************************** Term ******************************************************************/

    /****************************************** Factor ****************************************************************/
    @Override
    public void visit(FactorDesignator factorDesignator) {
        logSyntaxNodeTraversal(factorDesignator);

        Designator designator = factorDesignator.getDesignator();
        Obj designatorSymbol = designator.obj;

        logSymbolDebugMessage(factorDesignator, "Propagating Designator symbol to FactorDesignator", designatorSymbol);
        factorDesignator.obj = designatorSymbol;

        int designatorKind = designatorSymbol.getKind();
        // If designator is array element and exists on the rhs of assignment operator we need to duplicate it
        if (designatorKind == Obj.Elem) {
            SyntaxNode factorDesignatorParent = factorDesignator.getParent();
            if (factorDesignatorParent instanceof TermSingle) {
                SyntaxNode termSingleParent = factorDesignatorParent.getParent();
                if (termSingleParent instanceof ExprSingle) {
                    SyntaxNode exprSingleParent = termSingleParent.getParent();
                    if (exprSingleParent instanceof AssignmentOperationExpr) {
                        logDebugMessage(factorDesignator, "Duplicating designator - OR DO I?");
                       //    Code.put(Code.dup2);
                    }
                }
            }
        }

        logSymbolDebugMessage(factorDesignator, "Loading designator", designatorSymbol);
        Code.load(designatorSymbol);
    }
    @Override
    public void visit(FactorConstant factorConstant) {
        logSyntaxNodeTraversal(factorConstant);

        Obj factorConstantSymbol = factorConstant.obj;

        logSymbolDebugMessage(factorConstant, "Loading constant factor", factorConstantSymbol);
        Code.load(factorConstant.obj);
    }

    @Override
    public void visit(FactorNewArray factorNewArray) {
        logSyntaxNodeTraversal(factorNewArray);

        Type type = factorNewArray.getType();
        Struct arrayType = type.struct;

        // Dummy object for printing purposes
        Obj arrayObject = new Obj(Obj.Var, DUMMY_NAME, arrayType);
        logSymbolDebugMessage(factorNewArray, "Allocating new array", arrayObject);

        Code.put(Code.newarray);
        if (arrayType.equals(SymbolTable.charType)) {
            // Array of bytes
            Code.put(BYTE_ARRAY_OP_CODE);
        } else {
            // Array of word
            Code.put(WORD_ARRAY_OP_CODE);
        }

    }

    @Override
    public void visit(DesignatorStatementAssignment designatorStatementAssignment) {
        logSyntaxNodeTraversal(designatorStatementAssignment);

        Obj designatorSymbol = designatorStatementAssignment.getDesignator().obj;
         Code.store(designatorSymbol);

        logSymbolDebugMessage(designatorStatementAssignment, "Storing value to designator (assignment)", designatorSymbol);
    }

    @Override
    public void visit(DesignatorStatementIncrement designatorStatementIncrement) {
        logSyntaxNodeTraversal(designatorStatementIncrement);

        Obj designatorSymbol = designatorStatementIncrement.obj;
        int designatorLevel = designatorSymbol.getLevel();
        int designatorValue = designatorSymbol.getAdr();

        if (designatorSymbol.getKind() != Obj.Var) {
            // TODO ( acko) ???
            return;
        }

        logSymbolDebugMessage(designatorStatementIncrement, "Incrementing designator", designatorSymbol);


        if (designatorLevel == SymbolTable.LEVEL_GLOBAL) {
            // Global variable
            Code.load(designatorSymbol);
            Code.loadConst(ONE);
            Code.put(Code.add);
            Code.store(designatorSymbol);
        } else {
            // Local variable
            Code.put(Code.inc);
            Code.put(designatorValue);
            Code.put(ONE);
        }
    }

    @Override
    public void visit(DesignatorStatementDecrement designatorStatementDecrement) {
        logSyntaxNodeTraversal(designatorStatementDecrement);

        Obj designatorSymbol = designatorStatementDecrement.obj;
        int designatorLevel = designatorSymbol.getLevel();
        int designatorValue = designatorSymbol.getAdr();

        logSymbolDebugMessage(designatorStatementDecrement, "Decrementing designator", designatorSymbol);

        if (designatorLevel == SymbolTable.LEVEL_GLOBAL) {
            // Global variable
            Code.load(designatorSymbol);
            Code.loadConst(ONE);
            Code.put(Code.sub);
            Code.store(designatorSymbol);
        } else {
            // Local variable
            Code.put(Code.inc);
            Code.put(designatorValue);
            Code.put(MINUS_ONE);
        }
    }


    /****************************************** Factor ****************************************************************/

    /****************************************** Designator ************************************************************/

    @Override
    public void visit(DesignatorIdentifier designatorIdentifier) {
        SyntaxNode designatorIdentifierParent = designatorIdentifier.getParent();

        if (designatorIdentifierParent instanceof DesignatorElementAccess) {
            Obj designatorIdentifierSymbol = designatorIdentifier.obj;

            logSymbolDebugMessage(designatorIdentifier, "Loading designator for array element access", designatorIdentifierSymbol);
            Code.load(designatorIdentifierSymbol);
        }
    }

    @Override
    public void visit(DesignatorElementAccess designatorElementAccess) {
        logSyntaxNodeTraversal(designatorElementAccess);

        SyntaxNode designatorElementAccessParent = designatorElementAccess.getParent();
        if (designatorElementAccessParent instanceof DesignatorIdentifier) {
            Obj designatorElementAccessSymbol = designatorElementAccess.obj;

            logSymbolDebugMessage(designatorElementAccess, "Loading array element", designatorElementAccessSymbol);
            Code.load(designatorElementAccessSymbol);
        }
    }

    /****************************************** Designator ************************************************************/

    /****************************************** Statement *************************************************************/

    @Override
    public void visit(StatementIfElseHeader statementIfElseHeader) {
        logSyntaxNodeTraversal(statementIfElseHeader);

        ConditionErrorRecovery conditionErrorRecovery = statementIfElseHeader.getConditionErrorRecovery();
        if (conditionErrorRecovery instanceof ConditionErrorRecoveryError) {
            // TODO (acko): Fatal error here please.
            return;
        }

        Condition condition = ((ConditionErrorRecoveryCondition) conditionErrorRecovery).getCondition();
        Obj conditionSymbol = condition.obj;

        //System.out.println("STATEMENT IF ELSE CONDITION " + SymbolTable.ObjToString(conditionSymbol));

        Code.putFalseJump(conditionSymbol.getAdr(), 0);
        branchJumpAddressStack.pushFalseJump(Code.pc - 2);
        branchJumpAddressStack.patchTrueJumps();

        // TODO (acko): else statement

    }

    @Override
    public void visit(StatementIfElseIntermezzo statementIfElseIntermezzo) {
        logSyntaxNodeTraversal(statementIfElseIntermezzo);

        // TODO (acko): else statement

        branchJumpAddressStack.pushNewEntry();
    }

    @Override
    public void visit(StatementIfElse statementIfElse) {
        logSyntaxNodeTraversal(statementIfElse);

        // TODO (acko): else statement

        branchJumpAddressStack.patchFalseJumps();
        branchJumpAddressStack.pop();
    }

    @Override
    public void visit(StatementBreak statementBreak) {
        logSyntaxNodeTraversal(statementBreak);

        logDebugMessage(statementBreak, "Adding break statement address jump");

        Code.putJump(UNCONDITIONAL_JUMP);
        loopJumpAddressStack.pushBreakJumpAddress(Code.pc - TWO);
    }

    @Override
    public void visit(StatementContinue statementContinue) {
        logSyntaxNodeTraversal(statementContinue);

        logDebugMessage(statementContinue, "Adding continue statement address jump");

        Code.putJump(UNCONDITIONAL_JUMP);
        loopJumpAddressStack.pushContinueJumpAddress(Code.pc - TWO);
    }

    @Override
    public void visit(StatementRead statementRead) {
        logSyntaxNodeTraversal(statementRead);

        Designator designator = statementRead.getDesignator();
        Obj designatorSymbol = designator.obj;

        Struct designatorType = designatorSymbol.getType();
        logSymbolDebugMessage(statementRead, "Reading designator", designatorSymbol);

        if (designatorType.equals(SymbolTable.charType)) {
            // Read byte
            Code.put(Code.bread);
        } else {
            // Read word
            Code.put(Code.read);
        }

        Code.store(designatorSymbol);
    }

    @Override
    public void visit(StatementReturn statementReturn) {
        logSyntaxNodeTraversal(statementReturn);

        logDebugMessage(statementReturn, "Return statement");
        Code.put(Code.exit);
        Code.put(Code.return_);
    }
    @Override
    public void visit(StatementPrint statementPrint) {
        logSyntaxNodeTraversal(statementPrint);

        Expr expr = statementPrint.getExpr();
        MaybePrintWidth maybePrintWidth = statementPrint.getMaybePrintWidth();

        int printWidth = 0;
        if (maybePrintWidth instanceof MaybePrintWidthIsPrintWidth) {
            printWidth = ((MaybePrintWidthIsPrintWidth) maybePrintWidth).getPrintWidth();
        }

        Obj exprSymbol = expr.obj;
        Struct exprType = exprSymbol.getType();
        logSymbolDebugMessage(statementPrint, "Printing expr", exprSymbol);

        Code.loadConst(printWidth);
        if (exprType.equals(SymbolTable.charType)) {
            // Print word
            Code.put(Code.bprint);
        } else {
            // Print write
            Code.put(Code.print);
        }
    }

    /****************************************** Statement *************************************************************/
}
