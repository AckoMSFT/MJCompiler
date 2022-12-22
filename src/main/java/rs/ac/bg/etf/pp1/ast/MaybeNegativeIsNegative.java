// generated with ast extension for cup
// version 0.8
// 22/11/2022 1:37:43


package rs.ac.bg.etf.pp1.ast;

public class MaybeNegativeIsNegative extends MaybeNegative {

    public MaybeNegativeIsNegative () {
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
        buffer.append("MaybeNegativeIsNegative(\n");

        buffer.append(tab);
        buffer.append(") [MaybeNegativeIsNegative]");
        return buffer.toString();
    }
}
