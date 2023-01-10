// generated with ast extension for cup
// version 0.8
// 10/0/2023 18:19:30


package rs.ac.bg.etf.pp1.ast;

public class StatementForEachHeader implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private MemberAccess MemberAccess;

    public StatementForEachHeader (MemberAccess MemberAccess) {
        this.MemberAccess=MemberAccess;
        if(MemberAccess!=null) MemberAccess.setParent(this);
    }

    public MemberAccess getMemberAccess() {
        return MemberAccess;
    }

    public void setMemberAccess(MemberAccess MemberAccess) {
        this.MemberAccess=MemberAccess;
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
        if(MemberAccess!=null) MemberAccess.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MemberAccess!=null) MemberAccess.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MemberAccess!=null) MemberAccess.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementForEachHeader(\n");

        if(MemberAccess!=null)
            buffer.append(MemberAccess.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementForEachHeader]");
        return buffer.toString();
    }
}
