// generated with ast extension for cup
// version 0.8
// 27/11/2022 1:4:10


package rs.ac.bg.etf.pp1.ast;

public class ConstantNumber extends Constant {

    private Sign Sign;
    private Integer C2;

    public ConstantNumber (Sign Sign, Integer C2) {
        this.Sign=Sign;
        if(Sign!=null) Sign.setParent(this);
        this.C2=C2;
    }

    public Sign getSign() {
        return Sign;
    }

    public void setSign(Sign Sign) {
        this.Sign=Sign;
    }

    public Integer getC2() {
        return C2;
    }

    public void setC2(Integer C2) {
        this.C2=C2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Sign!=null) Sign.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Sign!=null) Sign.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Sign!=null) Sign.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantNumber(\n");

        if(Sign!=null)
            buffer.append(Sign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+C2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantNumber]");
        return buffer.toString();
    }
}
