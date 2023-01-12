// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class MaybeElseStatementIsElseStatement extends MaybeElseStatement {

    private StatementElseHeader StatementElseHeader;
    private Statement Statement;

    public MaybeElseStatementIsElseStatement (StatementElseHeader StatementElseHeader, Statement Statement) {
        this.StatementElseHeader=StatementElseHeader;
        if(StatementElseHeader!=null) StatementElseHeader.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StatementElseHeader getStatementElseHeader() {
        return StatementElseHeader;
    }

    public void setStatementElseHeader(StatementElseHeader StatementElseHeader) {
        this.StatementElseHeader=StatementElseHeader;
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
        if(StatementElseHeader!=null) StatementElseHeader.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementElseHeader!=null) StatementElseHeader.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementElseHeader!=null) StatementElseHeader.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MaybeElseStatementIsElseStatement(\n");

        if(StatementElseHeader!=null)
            buffer.append(StatementElseHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MaybeElseStatementIsElseStatement]");
        return buffer.toString();
    }
}
