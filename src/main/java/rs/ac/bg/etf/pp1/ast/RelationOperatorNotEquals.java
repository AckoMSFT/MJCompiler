// generated with ast extension for cup
// version 0.8
// 19/11/2022 1:19:54


package rs.ac.bg.etf.pp1.ast;

public class RelationOperatorNotEquals extends RelationOperator {

    public RelationOperatorNotEquals () {
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
        buffer.append("RelationOperatorNotEquals(\n");

        buffer.append(tab);
        buffer.append(") [RelationOperatorNotEquals]");
        return buffer.toString();
    }
}
