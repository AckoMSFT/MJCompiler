// generated with ast extension for cup
// version 0.8
// 26/11/2022 2:26:45


package rs.ac.bg.etf.pp1.ast;

public class GlobalDeclarationListEpsilon extends GlobalDeclarationList {

    public GlobalDeclarationListEpsilon () {
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
        buffer.append("GlobalDeclarationListEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [GlobalDeclarationListEpsilon]");
        return buffer.toString();
    }
}