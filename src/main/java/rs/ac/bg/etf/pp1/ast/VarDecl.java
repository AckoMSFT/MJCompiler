// generated with ast extension for cup
// version 0.8
// 26/11/2022 22:57:51


package rs.ac.bg.etf.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private VariableDeclarationList VariableDeclarationList;

    public VarDecl (Type Type, VariableDeclarationList VariableDeclarationList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VariableDeclarationList=VariableDeclarationList;
        if(VariableDeclarationList!=null) VariableDeclarationList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VariableDeclarationList getVariableDeclarationList() {
        return VariableDeclarationList;
    }

    public void setVariableDeclarationList(VariableDeclarationList VariableDeclarationList) {
        this.VariableDeclarationList=VariableDeclarationList;
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
        if(Type!=null) Type.accept(visitor);
        if(VariableDeclarationList!=null) VariableDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VariableDeclarationList!=null) VariableDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VariableDeclarationList!=null) VariableDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariableDeclarationList!=null)
            buffer.append(VariableDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
