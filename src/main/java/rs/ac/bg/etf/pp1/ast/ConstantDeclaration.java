// generated with ast extension for cup
// version 0.8
// 22/11/2022 1:37:43


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclaration implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String variable;
    private Constant Constant;

    public ConstantDeclaration (String variable, Constant Constant) {
        this.variable=variable;
        this.Constant=Constant;
        if(Constant!=null) Constant.setParent(this);
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable=variable;
    }

    public Constant getConstant() {
        return Constant;
    }

    public void setConstant(Constant Constant) {
        this.Constant=Constant;
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
        if(Constant!=null) Constant.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Constant!=null) Constant.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Constant!=null) Constant.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantDeclaration(\n");

        buffer.append(" "+tab+variable);
        buffer.append("\n");

        if(Constant!=null)
            buffer.append(Constant.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclaration]");
        return buffer.toString();
    }
}
