// generated with ast extension for cup
// version 0.8
// 19/11/2022 1:31:19


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclarationEpsilon extends ConstantDeclarationList {

    public ConstantDeclarationEpsilon () {
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
        buffer.append("ConstantDeclarationEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclarationEpsilon]");
        return buffer.toString();
    }
}
