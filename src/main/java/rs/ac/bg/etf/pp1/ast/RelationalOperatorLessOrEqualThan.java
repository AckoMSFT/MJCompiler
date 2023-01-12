// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class RelationalOperatorLessOrEqualThan extends RelationalOperator {

    public RelationalOperatorLessOrEqualThan () {
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
        buffer.append("RelationalOperatorLessOrEqualThan(\n");

        buffer.append(tab);
        buffer.append(") [RelationalOperatorLessOrEqualThan]");
        return buffer.toString();
    }
}
