// generated with ast extension for cup
// version 0.8
// 13/0/2023 5:29:16


package rs.ac.bg.etf.pp1.ast;

public class StatementIfElseHeader implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private StatementIfElseIntermezzo StatementIfElseIntermezzo;
    private ConditionErrorRecovery ConditionErrorRecovery;

    public StatementIfElseHeader (StatementIfElseIntermezzo StatementIfElseIntermezzo, ConditionErrorRecovery ConditionErrorRecovery) {
        this.StatementIfElseIntermezzo=StatementIfElseIntermezzo;
        if(StatementIfElseIntermezzo!=null) StatementIfElseIntermezzo.setParent(this);
        this.ConditionErrorRecovery=ConditionErrorRecovery;
        if(ConditionErrorRecovery!=null) ConditionErrorRecovery.setParent(this);
    }

    public StatementIfElseIntermezzo getStatementIfElseIntermezzo() {
        return StatementIfElseIntermezzo;
    }

    public void setStatementIfElseIntermezzo(StatementIfElseIntermezzo StatementIfElseIntermezzo) {
        this.StatementIfElseIntermezzo=StatementIfElseIntermezzo;
    }

    public ConditionErrorRecovery getConditionErrorRecovery() {
        return ConditionErrorRecovery;
    }

    public void setConditionErrorRecovery(ConditionErrorRecovery ConditionErrorRecovery) {
        this.ConditionErrorRecovery=ConditionErrorRecovery;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementIfElseIntermezzo!=null) StatementIfElseIntermezzo.accept(visitor);
        if(ConditionErrorRecovery!=null) ConditionErrorRecovery.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementIfElseIntermezzo!=null) StatementIfElseIntermezzo.traverseTopDown(visitor);
        if(ConditionErrorRecovery!=null) ConditionErrorRecovery.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementIfElseIntermezzo!=null) StatementIfElseIntermezzo.traverseBottomUp(visitor);
        if(ConditionErrorRecovery!=null) ConditionErrorRecovery.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementIfElseHeader(\n");

        if(StatementIfElseIntermezzo!=null)
            buffer.append(StatementIfElseIntermezzo.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionErrorRecovery!=null)
            buffer.append(ConditionErrorRecovery.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementIfElseHeader]");
        return buffer.toString();
    }
}
