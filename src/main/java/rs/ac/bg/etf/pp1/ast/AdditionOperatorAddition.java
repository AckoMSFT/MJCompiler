// generated with ast extension for cup
// version 0.8
// 19/11/2022 1:19:54


package rs.ac.bg.etf.pp1.ast;

public class AdditionOperatorAddition extends AdditionOperator {

    public AdditionOperatorAddition () {
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
        buffer.append("AdditionOperatorAddition(\n");

        buffer.append(tab);
        buffer.append(") [AdditionOperatorAddition]");
        return buffer.toString();
    }
}