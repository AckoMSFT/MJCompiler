// generated with ast extension for cup
// version 0.8
// 22/11/2022 23:46:51


package src.main.java.rs.ac.bg.etf.pp1.ast;

public class MaybePrintNumCostIsPrintNumCost extends MaybePrintNumConst {

    private Integer C1;

    public MaybePrintNumCostIsPrintNumCost (Integer C1) {
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
        buffer.append("MaybePrintNumCostIsPrintNumCost(\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MaybePrintNumCostIsPrintNumCost]");
        return buffer.toString();
    }
}
