// generated with ast extension for cup
// version 0.8
// 26/11/2022 23:27:11


package rs.ac.bg.etf.pp1.ast;

public class MaybeExtendedClassEpsilon extends MaybeExtendedClass {

    public MaybeExtendedClassEpsilon () {
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
        buffer.append("MaybeExtendedClassEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [MaybeExtendedClassEpsilon]");
        return buffer.toString();
    }
}
