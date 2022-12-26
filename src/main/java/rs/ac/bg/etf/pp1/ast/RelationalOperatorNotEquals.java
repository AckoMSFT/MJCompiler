// generated with ast extension for cup
// version 0.8
// 26/11/2022 22:57:51


package rs.ac.bg.etf.pp1.ast;

public class RelationalOperatorNotEquals extends RelationalOperator {

    public RelationalOperatorNotEquals () {
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
        buffer.append("RelationalOperatorNotEquals(\n");

        buffer.append(tab);
        buffer.append(") [RelationalOperatorNotEquals]");
        return buffer.toString();
    }
}
