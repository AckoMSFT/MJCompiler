// generated with ast extension for cup
// version 0.8
// 13/0/2023 5:29:16


package rs.ac.bg.etf.pp1.ast;

public class ConstantNumber extends Constant {

    private Sign Sign;
    private Integer value;

    public ConstantNumber (Sign Sign, Integer value) {
        this.Sign=Sign;
        if(Sign!=null) Sign.setParent(this);
        this.value=value;
    }

    public Sign getSign() {
        return Sign;
    }

    public void setSign(Sign Sign) {
        this.Sign=Sign;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value=value;
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

        buffer.append(" "+tab+value);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantNumber]");
        return buffer.toString();
    }
}
