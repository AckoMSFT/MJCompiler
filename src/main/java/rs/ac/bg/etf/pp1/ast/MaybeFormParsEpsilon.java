// generated with ast extension for cup
// version 0.8
// 9/0/2023 21:47:18


package rs.ac.bg.etf.pp1.ast;

public class MaybeFormParsEpsilon extends MaybeFormPars {

    public MaybeFormParsEpsilon () {
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
        buffer.append("MaybeFormParsEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [MaybeFormParsEpsilon]");
        return buffer.toString();
    }
}
