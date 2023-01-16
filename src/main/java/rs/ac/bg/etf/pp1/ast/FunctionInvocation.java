// generated with ast extension for cup
// version 0.8
// 13/0/2023 5:29:16


package rs.ac.bg.etf.pp1.ast;

public class FunctionInvocation implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private MaybeActPars MaybeActPars;

    public FunctionInvocation (MaybeActPars MaybeActPars) {
        this.MaybeActPars=MaybeActPars;
        if(MaybeActPars!=null) MaybeActPars.setParent(this);
    }

    public MaybeActPars getMaybeActPars() {
        return MaybeActPars;
    }

    public void setMaybeActPars(MaybeActPars MaybeActPars) {
        this.MaybeActPars=MaybeActPars;
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
        if(MaybeActPars!=null) MaybeActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeActPars!=null) MaybeActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeActPars!=null) MaybeActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FunctionInvocation(\n");

        if(MaybeActPars!=null)
            buffer.append(MaybeActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FunctionInvocation]");
        return buffer.toString();
    }
}
