// generated with ast extension for cup
// version 0.8
// 10/0/2023 16:27:38


package rs.ac.bg.etf.pp1.ast;

public class ConstructorDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private MaybeFormPars MaybeFormPars;

    public ConstructorDecl (String I1, MaybeFormPars MaybeFormPars) {
        this.I1=I1;
        this.MaybeFormPars=MaybeFormPars;
        if(MaybeFormPars!=null) MaybeFormPars.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public MaybeFormPars getMaybeFormPars() {
        return MaybeFormPars;
    }

    public void setMaybeFormPars(MaybeFormPars MaybeFormPars) {
        this.MaybeFormPars=MaybeFormPars;
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
        if(MaybeFormPars!=null) MaybeFormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeFormPars!=null) MaybeFormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeFormPars!=null) MaybeFormPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(MaybeFormPars!=null)
            buffer.append(MaybeFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorDecl]");
        return buffer.toString();
    }
}
