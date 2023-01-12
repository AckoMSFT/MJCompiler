// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class StatementForEach extends Statement {

    private StatementForEachHeader StatementForEachHeader;
    private StatementForEachDesignator StatementForEachDesignator;
    private Statement Statement;

    public StatementForEach (StatementForEachHeader StatementForEachHeader, StatementForEachDesignator StatementForEachDesignator, Statement Statement) {
        this.StatementForEachHeader=StatementForEachHeader;
        if(StatementForEachHeader!=null) StatementForEachHeader.setParent(this);
        this.StatementForEachDesignator=StatementForEachDesignator;
        if(StatementForEachDesignator!=null) StatementForEachDesignator.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StatementForEachHeader getStatementForEachHeader() {
        return StatementForEachHeader;
    }

    public void setStatementForEachHeader(StatementForEachHeader StatementForEachHeader) {
        this.StatementForEachHeader=StatementForEachHeader;
    }

    public StatementForEachDesignator getStatementForEachDesignator() {
        return StatementForEachDesignator;
    }

    public void setStatementForEachDesignator(StatementForEachDesignator StatementForEachDesignator) {
        this.StatementForEachDesignator=StatementForEachDesignator;
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
        if(StatementForEachHeader!=null) StatementForEachHeader.accept(visitor);
        if(StatementForEachDesignator!=null) StatementForEachDesignator.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementForEachHeader!=null) StatementForEachHeader.traverseTopDown(visitor);
        if(StatementForEachDesignator!=null) StatementForEachDesignator.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementForEachHeader!=null) StatementForEachHeader.traverseBottomUp(visitor);
        if(StatementForEachDesignator!=null) StatementForEachDesignator.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementForEach(\n");

        if(StatementForEachHeader!=null)
            buffer.append(StatementForEachHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementForEachDesignator!=null)
            buffer.append(StatementForEachDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementForEach]");
        return buffer.toString();
    }
}
