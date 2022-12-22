// generated with ast extension for cup
// version 0.8
// 22/11/2022 23:46:51


package src.main.java.rs.ac.bg.etf.pp1.ast;

public class DesignatorIdentifier extends Designator {

    private String I1;
    private MaybeSubscript MaybeSubscript;

    public DesignatorIdentifier (String I1, MaybeSubscript MaybeSubscript) {
        this.I1=I1;
        this.MaybeSubscript=MaybeSubscript;
        if(MaybeSubscript!=null) MaybeSubscript.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public MaybeSubscript getMaybeSubscript() {
        return MaybeSubscript;
    }

    public void setMaybeSubscript(MaybeSubscript MaybeSubscript) {
        this.MaybeSubscript=MaybeSubscript;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MaybeSubscript!=null) MaybeSubscript.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeSubscript!=null) MaybeSubscript.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeSubscript!=null) MaybeSubscript.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorIdentifier(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(MaybeSubscript!=null)
            buffer.append(MaybeSubscript.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorIdentifier]");
        return buffer.toString();
    }
}
