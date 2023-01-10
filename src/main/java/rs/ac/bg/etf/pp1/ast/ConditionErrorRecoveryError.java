// generated with ast extension for cup
// version 0.8
// 10/0/2023 16:27:38


package rs.ac.bg.etf.pp1.ast;

public class ConditionErrorRecoveryError extends ConditionErrorRecovery {

    public ConditionErrorRecoveryError () {
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
        buffer.append("ConditionErrorRecoveryError(\n");

        buffer.append(tab);
        buffer.append(") [ConditionErrorRecoveryError]");
        return buffer.toString();
    }
}
