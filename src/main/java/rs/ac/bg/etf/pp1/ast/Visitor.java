// generated with ast extension for cup
// version 0.8
// 26/11/2022 2:26:45


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Designator Designator);
    public void visit(GlobalDeclarationList GlobalDeclarationList);
    public void visit(ConstFactor ConstFactor);
    public void visit(Factor Factor);
    public void visit(GlobalDeclaration GlobalDeclaration);
    public void visit(Sign Sign);
    public void visit(Constant Constant);
    public void visit(ConstDeclarationList ConstDeclarationList);
    public void visit(MaybeArray MaybeArray);
    public void visit(VariableDeclarationList VariableDeclarationList);
    public void visit(MultiplicationOperator MultiplicationOperator);
    public void visit(Expr Expr);
    public void visit(RelationalOperator RelationalOperator);
    public void visit(VarDecl VarDecl);
    public void visit(AdditionOperator AdditionOperator);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(Statement Statement);
    public void visit(MethodDeclarationList MethodDeclarationList);
    public void visit(Term Term);
    public void visit(MaybeArrayEpsilon MaybeArrayEpsilon);
    public void visit(MaybeArrayIsArray MaybeArrayIsArray);
    public void visit(SignEpsilon SignEpsilon);
    public void visit(SignNegative SignNegative);
    public void visit(SignPositive SignPositive);
    public void visit(Type Type);
    public void visit(RelationalOperatorLessOrEqualThan RelationalOperatorLessOrEqualThan);
    public void visit(RelationalOperatorLessThan RelationalOperatorLessThan);
    public void visit(RelationalOperatorGreaterOrEqualThan RelationalOperatorGreaterOrEqualThan);
    public void visit(RelationalOperatorGreaterThan RelationalOperatorGreaterThan);
    public void visit(RelationalOperatorNotEquals RelationalOperatorNotEquals);
    public void visit(RelationalOperatorEquals RelationalOperatorEquals);
    public void visit(MultiplicationOperatorModulo MultiplicationOperatorModulo);
    public void visit(MultiplicationOperatorDivision MultiplicationOperatorDivision);
    public void visit(MultiplicationOperatorMultiplication MultiplicationOperatorMultiplication);
    public void visit(AdditionOperatorSubtraction AdditionOperatorSubtraction);
    public void visit(AdditionOperatorAddition AdditionOperatorAddition);
    public void visit(AssignmentOperator AssignmentOperator);
    public void visit(DesignatorIdentifier DesignatorIdentifier);
    public void visit(ConstFactorDerived3 ConstFactorDerived3);
    public void visit(ConstFactorDerived2 ConstFactorDerived2);
    public void visit(ConstFactorDerived1 ConstFactorDerived1);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(FactorConstant FactorConstant);
    public void visit(TermSingle TermSingle);
    public void visit(TermMulti TermMulti);
    public void visit(ExprSingle ExprSingle);
    public void visit(ExprMulti ExprMulti);
    public void visit(StatementPrint StatementPrint);
    public void visit(MethodDeclarationDerived1 MethodDeclarationDerived1);
    public void visit(MethodDeclarationListEpsilon MethodDeclarationListEpsilon);
    public void visit(MethodDeclarationListMulti MethodDeclarationListMulti);
    public void visit(VariableDeclaration VariableDeclaration);
    public void visit(VariableDeclarationSingle VariableDeclarationSingle);
    public void visit(VariableDeclarationListMulti VariableDeclarationListMulti);
    public void visit(VarDeclDerived1 VarDeclDerived1);
    public void visit(ConstantBoolean ConstantBoolean);
    public void visit(ConstantCharacter ConstantCharacter);
    public void visit(ConstantNumber ConstantNumber);
    public void visit(ConstAssignment ConstAssignment);
    public void visit(ConstDeclarationListSingle ConstDeclarationListSingle);
    public void visit(ConstDeclarationListMulti ConstDeclarationListMulti);
    public void visit(ConstDecl ConstDecl);
    public void visit(GlobalDeclarationVarDecl GlobalDeclarationVarDecl);
    public void visit(GlobalDeclarationConstDecl GlobalDeclarationConstDecl);
    public void visit(GlobalDeclarationListEpsilon GlobalDeclarationListEpsilon);
    public void visit(GlobalDeclarationListMulti GlobalDeclarationListMulti);
    public void visit(Program Program);

}
