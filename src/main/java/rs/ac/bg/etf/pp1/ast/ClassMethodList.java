// generated with ast extension for cup
// version 0.8
// 27/11/2022 1:4:10


package rs.ac.bg.etf.pp1.ast;

public class ClassMethodList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MethodDeclarationList MethodDeclarationList;

    public ClassMethodList (MethodDeclarationList MethodDeclarationList) {
        this.MethodDeclarationList=MethodDeclarationList;
        if(MethodDeclarationList!=null) MethodDeclarationList.setParent(this);
    }

    public MethodDeclarationList getMethodDeclarationList() {
        return MethodDeclarationList;
    }

    public void setMethodDeclarationList(MethodDeclarationList MethodDeclarationList) {
        this.MethodDeclarationList=MethodDeclarationList;
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
        if(MethodDeclarationList!=null) MethodDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclarationList!=null) MethodDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclarationList!=null) MethodDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassMethodList(\n");

        if(MethodDeclarationList!=null)
            buffer.append(MethodDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassMethodList]");
        return buffer.toString();
    }
}
