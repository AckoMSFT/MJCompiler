// generated with ast extension for cup
// version 0.8
// 10/0/2023 16:27:38


package rs.ac.bg.etf.pp1.ast;

public class LocalVariableDeclaration implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String variableName;
    private MaybeArray MaybeArray;

    public LocalVariableDeclaration (String variableName, MaybeArray MaybeArray) {
        this.variableName=variableName;
        this.MaybeArray=MaybeArray;
        if(MaybeArray!=null) MaybeArray.setParent(this);
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName=variableName;
    }

    public MaybeArray getMaybeArray() {
        return MaybeArray;
    }

    public void setMaybeArray(MaybeArray MaybeArray) {
        this.MaybeArray=MaybeArray;
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
        if(MaybeArray!=null) MaybeArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeArray!=null) MaybeArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeArray!=null) MaybeArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVariableDeclaration(\n");

        buffer.append(" "+tab+variableName);
        buffer.append("\n");

        if(MaybeArray!=null)
            buffer.append(MaybeArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVariableDeclaration]");
        return buffer.toString();
    }
}
