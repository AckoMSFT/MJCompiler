// generated with ast extension for cup
// version 0.8
// 26/11/2022 22:57:51


package rs.ac.bg.etf.pp1.ast;

public class StatementIfElse extends Statement {

    private Condition Condition;
    private Statement Statement;
    private MaybeElseStatement MaybeElseStatement;

    public StatementIfElse (Condition Condition, Statement Statement, MaybeElseStatement MaybeElseStatement) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.MaybeElseStatement=MaybeElseStatement;
        if(MaybeElseStatement!=null) MaybeElseStatement.setParent(this);
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

    public MaybeElseStatement getMaybeElseStatement() {
        return MaybeElseStatement;
    }

    public void setMaybeElseStatement(MaybeElseStatement MaybeElseStatement) {
        this.MaybeElseStatement=MaybeElseStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(MaybeElseStatement!=null) MaybeElseStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(MaybeElseStatement!=null) MaybeElseStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(MaybeElseStatement!=null) MaybeElseStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementIfElse(\n");

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

        if(MaybeElseStatement!=null)
            buffer.append(MaybeElseStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementIfElse]");
        return buffer.toString();
    }
}
