// generated with ast extension for cup
// version 0.8
// 9/0/2023 19:3:49


package rs.ac.bg.etf.pp1.ast;

public class RelationalOperatorGreaterThan extends RelationalOperator {

    public RelationalOperatorGreaterThan () {
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
        buffer.append("RelationalOperatorGreaterThan(\n");

        buffer.append(tab);
        buffer.append(") [RelationalOperatorGreaterThan]");
        return buffer.toString();
    }
}
