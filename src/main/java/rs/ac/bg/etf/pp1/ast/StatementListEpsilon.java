// generated with ast extension for cup
// version 0.8
// 26/11/2022 22:32:14


package rs.ac.bg.etf.pp1.ast;

public class StatementListEpsilon extends StatementList {

    public StatementListEpsilon () {
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
        buffer.append("StatementListEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [StatementListEpsilon]");
        return buffer.toString();
    }
}
