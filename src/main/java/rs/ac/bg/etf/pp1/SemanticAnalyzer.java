package rs.ac.bg.etf.pp1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.util.ErrorMessageGenerator;
import rs.ac.bg.etf.pp1.util.ErrorMessageGenerator.MessageType;
import rs.ac.bg.etf.pp1.util.OperatorHelper;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

import java.util.Arrays;

public class SemanticAnalyzer extends VisitorAdaptor {

    Logger logger = LogManager.getLogger(SemanticAnalyzer.class);

    public int semanticErrorCount = 0;

    public int constCount = 0;

    public int globalVarCount = 0;

    public int localVarCount = 0;


    /**
     * Helpers
     **/
    private Struct currentTypeSymbol = SymbolTable.noType;

    private boolean hasReturnStatement = false;

    private boolean declaredMain = false;

    private static final String MAIN_METHOD_NAME = "main";

    private Obj currentMethodSymbol = Tab.noObj;

    private void logInfo(SyntaxNode syntaxNode, MessageType messageType, Object... params) {
        String message = ErrorMessageGenerator.generateMessage(messageType, params);
        logger.info(String.format("[Line #%d] %s", syntaxNode.getLine(), message));
    }

    private void logDebug(SyntaxNode syntaxNode, MessageType messageType, Object... params) {
        String message = ErrorMessageGenerator.generateMessage(messageType, params);
        logger.debug(String.format("[Line #%d] %s", syntaxNode.getLine(), message));
    }

    private void logError(SyntaxNode syntaxNode, MessageType messageType, Object... params) {
        semanticErrorCount++;
        String message = ErrorMessageGenerator.generateMessage(messageType, params);
        logger.error(String.format("[Line #%d] Semantic error: %s", syntaxNode.getLine(), message));
    }

    private void logSyntaxNodeTraversal(SyntaxNode syntaxNode) {
        logDebug(syntaxNode, MessageType.SYNTAX_NODE_TRAVERSAL, syntaxNode);
    }

    private void logConstDeclaration(SyntaxNode syntaxNode, String name, String type, int value) {
        constCount++;
        logInfo(syntaxNode, MessageType.CONST_DECLARATION, name, type, value);
    }

    private void logGlobalVariableDeclaration(SyntaxNode syntaxNode, String name, String type) {
        globalVarCount++;
        logInfo(syntaxNode, MessageType.GLOBAL_VARIABLE_DECLARATION, name, type);
    }

    private void logLocalVariableDeclaration(SyntaxNode syntaxNode, String name, String type) {
        localVarCount++;
        logInfo(syntaxNode, MessageType.GLOBAL_VARIABLE_DECLARATION, name, type);
    }

    private void logTypeMismatchError(SyntaxNode syntaxNode, Struct actualType, Struct expectedType) {
        String actualTypeName = SymbolTable.getTypeName(actualType);
        String expectedTypeName = SymbolTable.getTypeName(expectedType);

        logError(syntaxNode, MessageType.TYPE_MISMATCH, actualTypeName, expectedTypeName);
    }

    private void logIncompatibleTypesError(SyntaxNode syntaxNode, Struct lhsType, Struct rhsType) {
        String lhsTypeName = SymbolTable.getTypeName(lhsType);
        String rhsTypeName = SymbolTable.getTypeName(rhsType);

        logError(syntaxNode, MessageType.INCOMPATIBLE_TYPES, lhsTypeName, rhsTypeName);
    }

    private void logIllegalRelationalOperatorError(SyntaxNode syntaxNode, Struct lhsType, RelationalOperator relationalOperator) {
        String lhsTypeName = SymbolTable.getTypeName(lhsType);
        String operatorCode = OperatorHelper.getOperatorCode(relationalOperator);

        logError(syntaxNode, MessageType.ILLEGAL_RELATIONAL_OPERATOR, lhsTypeName, operatorCode);
    }

    private void logAdditionalErrorDescription(SyntaxNode syntaxNode, String additionalErrorDescrpition) {
        String message = ErrorMessageGenerator.generateMessage(MessageType.ADDITIONAL_ERROR_DESCRIPTION, additionalErrorDescrpition);
        logger.error(String.format("[Line #%d] Additional error description: %s", syntaxNode.getLine(), message));
    }

    private boolean checkIfSymbolIsInUse(SyntaxNode node, String symbolName) {
        return checkIfSymbolIsInUse(node, symbolName, false);
    }

    private boolean checkIfSymbolIsInUse(SyntaxNode node, String symbolName, boolean inCurrentScope) {
        Obj symbol = SymbolTable.getSymbol(symbolName, inCurrentScope);
        if (SymbolTable.isValidSymbol(symbol)) {
            logError(node, MessageType.SYMBOL_ALREADY_IN_USE, symbolName);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void visit(Program program) {
        //nVars = SymbolTable.currentScope.getnVars();
        SymbolTable.chainLocalSymbols(program.getProgramName().obj);
        SymbolTable.closeScope();
    }

    @Override
    public void visit(ProgramName programName) {
        String programNameStr = programName.getProgramName();
        programName.obj = SymbolTable.insert(Obj.Prog, programNameStr, SymbolTable.noType);
        SymbolTable.openScope();
    }

    public void visit(Type type) {
        logSyntaxNodeTraversal(type);

        String name = type.getType();
        logger.debug("Type name: " + name);

        // Check if type is present in SymbolTable in any enclosing scope.
        Obj typeSymbol = SymbolTable.getSymbol(name, false);
        if (SymbolTable.isSymbolType(typeSymbol)) {
            logger.debug("Found valid type!");
            currentTypeSymbol = typeSymbol.getType();
        } else {
            logger.error("Semantic error on line " + type.getLine() + ". " + name + " isn't a declared type in the scope.");
            semanticErrorCount++;
            currentTypeSymbol = SymbolTable.noType;
        }
    }

    public void visit(ConstAssignment constAssignment) {
        logSyntaxNodeTraversal(constAssignment);

        String name = constAssignment.getName();
        Constant constant = constAssignment.getConstant();

        // Check if symbol is in use
        if (checkIfSymbolIsInUse(constAssignment, name)) {
            return;
        }

        // Check if name is reserved
        if (SymbolTable.isReservedName(name)) {
            logger.warn("Name shadowing detected on line " + constAssignment.getLine() + ". Using reserved name " +
                    "[" + name + "] for constant declaration ");
        }

        // Check if this is a basic type since we can only have basic type constants defined.
        if (SymbolTable.isBasicType(currentTypeSymbol)) {
            logger.debug("Basic type constant declaration!");
        } else {
            logger.error("Semantic error on line " + constAssignment.getLine() + ". Cannot use non-basic type in constant declaration.");
            semanticErrorCount++;
            return;
        }

        Struct rhsType = SymbolTable.noType;
        int rhsValue = 0;

        if (constant instanceof ConstantNumber) {
            ConstantNumber rhs = (ConstantNumber) constant;

            rhsType = SymbolTable.intType;
            rhsValue = rhs.getValue();

            Sign sign = rhs.getSign();
            if (sign instanceof SignNegative) {
                rhsValue *= -1;
            }
        } else if (constant instanceof ConstantCharacter) {
            ConstantCharacter rhs = (ConstantCharacter) constant;

            rhsType = SymbolTable.charType;
            rhsValue = rhs.getValue();
        } else if (constant instanceof ConstantBoolean) {
            ConstantBoolean rhs = (ConstantBoolean) constant;

            rhsType = SymbolTable.boolType;
            rhsValue = rhs.getValue() ? 1 : 0;
        }

        if (!rhsType.equals(currentTypeSymbol)) {
            logger.error("Incompatible types " + SymbolTable.getTypeName(currentTypeSymbol) + " and " +
                    SymbolTable.getTypeName(rhsType) + " on line " + constAssignment.getLine());
            semanticErrorCount++;
            return;
        }

        Obj sym = SymbolTable.insert(Obj.Con, name, rhsType);
        sym.setAdr(rhsValue);

        logConstDeclaration(constAssignment, name, SymbolTable.getTypeName(currentTypeSymbol), rhsValue);
    }

    @Override
    public void visit(VariableDeclaration variableDeclaration) {
        logSyntaxNodeTraversal(variableDeclaration);
        if (!SymbolTable.isValidSymbol(currentTypeSymbol)) {
            // Invalid type, we have logged this error beforehand. Do nothing.
            return;
        }

        String variableName = variableDeclaration.getVariableName();
        if (checkIfSymbolIsInUse(variableDeclaration, variableName)) {
            return;
        }

        // TODO (acko): Name shadowing

        boolean isArray = variableDeclaration.getMaybeArray() instanceof MaybeArrayIsArray;
        Obj sym = SymbolTable.insert(Obj.Var, variableName, isArray ? new Struct(Struct.Array, currentTypeSymbol) : currentTypeSymbol);

        logGlobalVariableDeclaration(variableDeclaration, variableName, SymbolTable.getTypeName(currentTypeSymbol) + (isArray ? "[]" : ""));
    }

    @Override
    public void visit(LocalVariableDeclaration localVariableDeclaration) {
        logSyntaxNodeTraversal(localVariableDeclaration);
        if (!SymbolTable.isValidSymbol(currentTypeSymbol)) {
            // Invalid type, we have logged this error beforehand. Do nothing.
            return;
        }

        String variableName = localVariableDeclaration.getVariableName();
        if (checkIfSymbolIsInUse(localVariableDeclaration, variableName)) {
            return;
        }

        // TODO (acko): Name shadowing

        boolean isArray = localVariableDeclaration.getMaybeArray() instanceof MaybeArrayIsArray;
        Obj sym = SymbolTable.insert(Obj.Var, variableName, isArray ? new Struct(Struct.Array, currentTypeSymbol) : currentTypeSymbol);

        logLocalVariableDeclaration(localVariableDeclaration, variableName, SymbolTable.getTypeName(currentTypeSymbol) + (isArray ? "[]" : ""));

    }

    /**
     * Method section
     **/

    @Override
    public void visit(ReturnTypeVoid returnTypeVoid) {
        logSyntaxNodeTraversal(returnTypeVoid);

        returnTypeVoid.struct = Tab.noType;
    }

    @Override
    public void visit(ReturnTypeNonVoid returnTypeNonVoid) {
        logSyntaxNodeTraversal(returnTypeNonVoid);

        returnTypeNonVoid.struct = currentTypeSymbol;
    }

    @Override
    public void visit(MethodDeclarationHeader methodDeclarationHeader) {
        logSyntaxNodeTraversal(methodDeclarationHeader);

        String methodName = methodDeclarationHeader.getMethodName();
        Struct returnType = methodDeclarationHeader.getReturnType().struct;

        currentMethodSymbol = SymbolTable.insert(Obj.Meth, methodName, returnType);
        methodDeclarationHeader.obj = currentMethodSymbol;
        SymbolTable.openScope();
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        logSyntaxNodeTraversal(methodDeclaration);

        SymbolTable.chainLocalSymbols(currentMethodSymbol);
        SymbolTable.closeScope();

        MethodDeclarationHeader methodDeclarationHeader = methodDeclaration.getMethodDeclarationHeader();
        String methodName = methodDeclarationHeader.getMethodName();
        ReturnType returnType = methodDeclarationHeader.getReturnType();

        if (methodName.equals(MAIN_METHOD_NAME)) {
            if (returnType instanceof ReturnTypeNonVoid) {
                String returnTypeString = ((ReturnTypeNonVoid) returnType).getType().getType();
                logError(methodDeclaration, MessageType.MAIN_METHOD_RETURN_TYPE_MISMATCH, returnTypeString);
            }

            // TODO (acko): Arguments...
        } else {
            if (!hasReturnStatement) {
                logError(methodDeclaration, MessageType.RETURN_STATEMENT_NOT_FOUND, currentMethodSymbol.getName());
            }
        }

        hasReturnStatement = false;
        currentMethodSymbol = null;

        // if(!returnFound && currentMethod.getType() != Tab.noType){
        //    report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
        // }
        // Tab.chainLocalSymbols(currentMethod);
        //Tab.closeScope();

//        returnFound = false;
        //      currentMethod = null;
    }

    /****************************************** Factor ****************************************************************/

    /*
     Factor

     Factor ::=
     (FactorDesignator) Designator
     | (FactorFunctionInvocation) Designator FunctionInvocation
     | (FactorConstant) ConstFactor
     | (FactorNewArray) NEW Type ArrayElement
     | (FactorNewClass) NEW Type FunctionInvocation
     | (FactorExpr) LEFT_PARENTHESES Expr RIGHT_PARENTHESES;
    */

    @Override
    public void visit(FactorDesignator factorDesignator) {
        logSyntaxNodeTraversal(factorDesignator);
    }


    @Override
    public void visit(FactorFunctionInvocation factorFunctionInvocation) {
        logSyntaxNodeTraversal(factorFunctionInvocation);
    }

    @Override
    public void visit(FactorConstant factorConstant) {
        logSyntaxNodeTraversal(factorConstant);

        ConstFactor constFactor = factorConstant.getConstFactor();

        String constFactorName = "";
        Struct constFactorType = SymbolTable.noType;
        int constFactorValue = 0;

        if (constFactor instanceof ConstFactorNumber) {
            ConstFactorNumber constFactorNumber = (ConstFactorNumber) constFactor;
            constFactorName = String.valueOf(constFactorNumber.getValue());
            constFactorType = SymbolTable.intType;
            constFactorValue = constFactorNumber.getValue();
        } else if (constFactor instanceof ConstFactorCharacter) {
            ConstFactorCharacter constFactorCharacter = (ConstFactorCharacter) constFactor;
            constFactorName = String.valueOf(constFactorCharacter.getValue());
            constFactorType = SymbolTable.charType;
            constFactorValue = constFactorCharacter.getValue();
        } else if (constFactor instanceof ConstFactorBoolean) {
            ConstFactorBoolean constFactorBoolean = (ConstFactorBoolean) constFactor;
            constFactorName = String.valueOf(constFactorBoolean.getValue());
            constFactorType = SymbolTable.boolType;
            constFactorValue = constFactorBoolean.getValue() ? 1 : 0;
        }

        Obj constFactorObj = new Obj(Obj.Con, constFactorName, constFactorType, constFactorValue, 0);
        factorConstant.obj = constFactorObj;
    }

    @Override
    public void visit(FactorNewArray factorNewArray) {
        logSyntaxNodeTraversal(factorNewArray);
    }

    @Override
    public void visit(FactorNewClass factorNewClass) {
        logSyntaxNodeTraversal(factorNewClass);
    }

    @Override
    public void visit(FactorExpr factorExpr) {
        logSyntaxNodeTraversal(factorExpr);

        Expr expr = factorExpr.getExpr();
        factorExpr.obj = expr.obj;
    }

    /***************************************** Factor *****************************************************************/

    /**************************************** Condition ***************************************************************/

    /*
        Condition = CondTerm {"||" CondTerm}

        Condition ::=
            (ConditionMulti) Condition OR CondTerm
            | (ConditionSingle) CondTerm;

        CondTerm = CondFact {"&&" CondFact}

        CondTerm ::=
            (CondTermMulti) CondTerm AND CondFact
            | (CondTermSingle) CondFact;

        CondFact = Expr [Relop Expr]

        CondFact ::=
            (CondFactMulti) Expr RelationalOperator Expr
            | (CondFactSingle) Expr;

        Expr = ["-"] Term {Addop Term}

        Expr ::=
            (ExprMulti) Expr AdditionOperator Term
            | (ExprSingle) Sign Term;

        Term := Factor {Mulop Factor}

        Term ::=
            (TermMulti) Term MultiplicationOperator Factor
            | (TermSingle) Factor;
    */

    @Override
    public void visit(TermSingle termSingle) {
        logSyntaxNodeTraversal(termSingle);

        Factor factor = termSingle.getFactor();
        termSingle.obj = factor.obj;
    }

    @Override
    public void visit(TermMulti termMulti) {
        logSyntaxNodeTraversal(termMulti);

        termMulti.obj = SymbolTable.noObj;

        Term lhsTerm = termMulti.getTerm();
        Factor rhsFactor = termMulti.getFactor();

        Obj lhsSymbol = lhsTerm.obj;
        Obj rhsSymbol = rhsFactor.obj;

        // TODO (acko): check if symbols are valid

        Struct lhsType = lhsSymbol.getType();
        Struct rhsType = rhsSymbol.getType();

        if (!lhsType.equals(SymbolTable.intType)) {
            logTypeMismatchError(termMulti, lhsType, SymbolTable.intType);
            return;
        }

        if (!rhsType.equals(SymbolTable.intType)) {
            logTypeMismatchError(termMulti, rhsType, SymbolTable.intType);
            return;
        }

        MultiplicationOperator multiplicationOperator = termMulti.getMultiplicationOperator();
        String operatorCode = OperatorHelper.getOperatorCode(multiplicationOperator);

        String lhsName = lhsSymbol.getName();
        String rhsName = rhsSymbol.getName();

        String name = String.join(" ", Arrays.asList(lhsName, operatorCode, rhsName));

        Obj termMultiObj = new Obj(Obj.Con, name, SymbolTable.intType);
        termMulti.obj = termMultiObj;
    }

    @Override
    public void visit(ExprSingle exprSingle) {
        logSyntaxNodeTraversal(exprSingle);

        Sign sign = exprSingle.getSign();
        Term term = exprSingle.getTerm();

        Obj exprSingleObj = term.obj;
        if (sign instanceof SignNegative) {
            // public Obj(int kind, String name, Struct type, int adr, int level) {
            exprSingleObj = new Obj(Obj.Con, exprSingleObj.getName(), exprSingleObj.getType(), exprSingleObj.getAdr(), exprSingleObj.getLevel());
        }

        exprSingle.obj = exprSingleObj;
    }

    @Override
    public void visit(ExprMulti exprMulti) {
        logSyntaxNodeTraversal(exprMulti);

        exprMulti.obj = SymbolTable.noObj;

        Expr lhsExpr = exprMulti.getExpr();
        Term rhsTerm = exprMulti.getTerm();

        Obj lhsSymbol = lhsExpr.obj;
        Obj rhsSymbol = rhsTerm.obj;

        // TODO (acko): check if symbols are valid

        Struct lhsType = lhsSymbol.getType();
        Struct rhsType = rhsSymbol.getType();

        if (!lhsType.equals(SymbolTable.intType)) {
            logTypeMismatchError(exprMulti, lhsType, SymbolTable.intType);
            return;
        }

        if (!rhsType.equals(SymbolTable.intType)) {
            logTypeMismatchError(exprMulti, rhsType, SymbolTable.intType);
            return;
        }

        AdditionOperator additionOperator = exprMulti.getAdditionOperator();
        String operatorCode = OperatorHelper.getOperatorCode(additionOperator);

        String lhsName = lhsSymbol.getName();
        String rhsName = rhsSymbol.getName();

        String name = String.join(" ", Arrays.asList(lhsName, operatorCode, rhsName));

        Obj exprMultiObj = new Obj(Obj.Con, name, SymbolTable.intType);
        exprMulti.obj = exprMultiObj;
    }

    @Override
    public void visit(CondFactSingle condFactSingle) {
        logSyntaxNodeTraversal(condFactSingle);

        Expr expr = condFactSingle.getExpr();
        Obj exprObj = expr.obj;
        Struct exprType = exprObj.getType();

        // Terminal fact must be of type bool in order for the whole condition to be of type bool.
        if (!exprType.equals(SymbolTable.boolType)) {
            logTypeMismatchError(condFactSingle, exprType, SymbolTable.boolType);
        }
    }

    @Override
    public void visit(CondFactMulti condFactMulti) {
        logSyntaxNodeTraversal(condFactMulti);

        Expr lhsExpr = condFactMulti.getExpr();
        Expr rhsExpr = condFactMulti.getExpr1();

        Obj lhsSymbol = lhsExpr.obj;
        Obj rhsSymbol = rhsExpr.obj;

        // TODO (acko): check if symbols are valid

        Struct lhsType = lhsSymbol.getType();
        Struct rhsType = rhsSymbol.getType();

        if(!lhsType.compatibleWith(rhsType)) {
            logIncompatibleTypesError(condFactMulti, lhsType, rhsType);
            return;
        }

        // Arrays and classes can only use == and != as relational operator
        if (lhsType.getKind() == Struct.Array || lhsType.getKind() == Struct.Class) {
            RelationalOperator relationalOperator = condFactMulti.getRelationalOperator();

            if (!(relationalOperator instanceof RelationalOperatorEquals) && !(relationalOperator instanceof RelationalOperatorNotEquals)) {
                logIllegalRelationalOperatorError(condFactMulti, lhsType, relationalOperator);
                logAdditionalErrorDescription(condFactMulti, "Arrays and classes can only use == and != relational operators.");
            }
        }
    }

    /**************************************** Condition ***************************************************************/

    /** Statements **/

    @Override
    public void visit(StatementReturn statementReturn) {
        logSyntaxNodeTraversal(statementReturn);

        if (SymbolTable.isValidSymbol(currentMethodSymbol)) {
            hasReturnStatement = true;
        } else {
            logError(statementReturn, MessageType.RETURN_STATEMENT_OUTSIDE_OF_METHOD);
        }
    }
}
