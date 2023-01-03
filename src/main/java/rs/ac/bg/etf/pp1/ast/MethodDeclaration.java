// generated with ast extension for cup
// version 0.8
// 3/0/2023 0:28:3


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclaration implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private MethodDeclarationHeader MethodDeclarationHeader;
    private MaybeFormPars MaybeFormPars;
    private LocalVarDeclList LocalVarDeclList;
    private StatementList StatementList;

    public MethodDeclaration (MethodDeclarationHeader MethodDeclarationHeader, MaybeFormPars MaybeFormPars, LocalVarDeclList LocalVarDeclList, StatementList StatementList) {
        this.MethodDeclarationHeader=MethodDeclarationHeader;
        if(MethodDeclarationHeader!=null) MethodDeclarationHeader.setParent(this);
        this.MaybeFormPars=MaybeFormPars;
        if(MaybeFormPars!=null) MaybeFormPars.setParent(this);
        this.LocalVarDeclList=LocalVarDeclList;
        if(LocalVarDeclList!=null) LocalVarDeclList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodDeclarationHeader getMethodDeclarationHeader() {
        return MethodDeclarationHeader;
    }

    public void setMethodDeclarationHeader(MethodDeclarationHeader MethodDeclarationHeader) {
        this.MethodDeclarationHeader=MethodDeclarationHeader;
    }

    public MaybeFormPars getMaybeFormPars() {
        return MaybeFormPars;
    }

    public void setMaybeFormPars(MaybeFormPars MaybeFormPars) {
        this.MaybeFormPars=MaybeFormPars;
    }

    public LocalVarDeclList getLocalVarDeclList() {
        return LocalVarDeclList;
    }

    public void setLocalVarDeclList(LocalVarDeclList LocalVarDeclList) {
        this.LocalVarDeclList=LocalVarDeclList;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclarationHeader!=null) MethodDeclarationHeader.accept(visitor);
        if(MaybeFormPars!=null) MaybeFormPars.accept(visitor);
        if(LocalVarDeclList!=null) LocalVarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclarationHeader!=null) MethodDeclarationHeader.traverseTopDown(visitor);
        if(MaybeFormPars!=null) MaybeFormPars.traverseTopDown(visitor);
        if(LocalVarDeclList!=null) LocalVarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclarationHeader!=null) MethodDeclarationHeader.traverseBottomUp(visitor);
        if(MaybeFormPars!=null) MaybeFormPars.traverseBottomUp(visitor);
        if(LocalVarDeclList!=null) LocalVarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclaration(\n");

        if(MethodDeclarationHeader!=null)
            buffer.append(MethodDeclarationHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeFormPars!=null)
            buffer.append(MaybeFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVarDeclList!=null)
            buffer.append(LocalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclaration]");
        return buffer.toString();
    }
}
