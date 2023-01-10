// generated with ast extension for cup
// version 0.8
// 10/0/2023 16:27:38


package rs.ac.bg.etf.pp1.ast;

public class MaybePrintWidthIsPrintWidth extends MaybePrintWidth {

    private Integer C1;

    public MaybePrintWidthIsPrintWidth (Integer C1) {
        this.C1=C1;
    }

    public Integer getC1() {
        return C1;
    }

    public void setC1(Integer C1) {
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
        buffer.append("MaybePrintWidthIsPrintWidth(\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MaybePrintWidthIsPrintWidth]");
        return buffer.toString();
    }
}
