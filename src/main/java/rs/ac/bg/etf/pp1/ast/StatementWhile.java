// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class StatementWhile extends Statement {

    private StatementWhileHeader StatementWhileHeader;
    private Condition Condition;
    private Statement Statement;

    public StatementWhile (StatementWhileHeader StatementWhileHeader, Condition Condition, Statement Statement) {
        this.StatementWhileHeader=StatementWhileHeader;
        if(StatementWhileHeader!=null) StatementWhileHeader.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StatementWhileHeader getStatementWhileHeader() {
        return StatementWhileHeader;
    }

    public void setStatementWhileHeader(StatementWhileHeader StatementWhileHeader) {
        this.StatementWhileHeader=StatementWhileHeader;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementWhileHeader!=null) StatementWhileHeader.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementWhileHeader!=null) StatementWhileHeader.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementWhileHeader!=null) StatementWhileHeader.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementWhile(\n");

        if(StatementWhileHeader!=null)
            buffer.append(StatementWhileHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementWhile]");
        return buffer.toString();
    }
}
