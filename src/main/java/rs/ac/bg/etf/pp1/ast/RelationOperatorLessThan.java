// generated with ast extension for cup
// version 0.8
// 19/11/2022 1:43:13


package rs.ac.bg.etf.pp1.ast;

public class RelationOperatorLessThan extends RelationOperator {

    public RelationOperatorLessThan () {
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
        buffer.append("RelationOperatorLessThan(\n");

        buffer.append(tab);
        buffer.append(") [RelationOperatorLessThan]");
        return buffer.toString();
    }
}
