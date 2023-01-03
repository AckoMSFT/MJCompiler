// generated with ast extension for cup
// version 0.8
// 3/0/2023 0:28:3


package rs.ac.bg.etf.pp1.ast;

public class ConstFactorBoolean extends ConstFactor {

    private Boolean C1;

    public ConstFactorBoolean (Boolean C1) {
        this.C1=C1;
    }

    public Boolean getC1() {
        return C1;
    }

    public void setC1(Boolean C1) {
        this.C1=C1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstFactorBoolean(\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstFactorBoolean]");
        return buffer.toString();
    }
}
