// generated with ast extension for cup
// version 0.8
// 10/0/2023 16:27:38


package rs.ac.bg.etf.pp1.ast;

public class StatementForEach extends Statement {

    private MemberAccess MemberAccess;
    private String I2;
    private Statement Statement;

    public StatementForEach (MemberAccess MemberAccess, String I2, Statement Statement) {
        this.MemberAccess=MemberAccess;
        if(MemberAccess!=null) MemberAccess.setParent(this);
        this.I2=I2;
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public MemberAccess getMemberAccess() {
        return MemberAccess;
    }

    public void setMemberAccess(MemberAccess MemberAccess) {
        this.MemberAccess=MemberAccess;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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
        if(MemberAccess!=null) MemberAccess.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MemberAccess!=null) MemberAccess.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MemberAccess!=null) MemberAccess.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementForEach(\n");

        if(MemberAccess!=null)
            buffer.append(MemberAccess.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
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
