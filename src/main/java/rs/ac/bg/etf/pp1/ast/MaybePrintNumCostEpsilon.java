// generated with ast extension for cup
// version 0.8
// 22/11/2022 23:46:51


package src.main.java.rs.ac.bg.etf.pp1.ast;

public class MaybePrintNumCostEpsilon extends MaybePrintNumConst {

    public MaybePrintNumCostEpsilon () {
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
        buffer.append("MaybePrintNumCostEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [MaybePrintNumCostEpsilon]");
        return buffer.toString();
    }
}
