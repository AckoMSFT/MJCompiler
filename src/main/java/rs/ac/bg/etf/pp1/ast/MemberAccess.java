// generated with ast extension for cup
// version 0.8
// 10/0/2023 18:19:30


package rs.ac.bg.etf.pp1.ast;

public class MemberAccess implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String designator;
    private DesignatorAccessList DesignatorAccessList;

    public MemberAccess (String designator, DesignatorAccessList DesignatorAccessList) {
        this.designator=designator;
        this.DesignatorAccessList=DesignatorAccessList;
        if(DesignatorAccessList!=null) DesignatorAccessList.setParent(this);
    }

    public String getDesignator() {
        return designator;
    }

    public void setDesignator(String designator) {
        this.designator=designator;
    }

    public DesignatorAccessList getDesignatorAccessList() {
        return DesignatorAccessList;
    }

    public void setDesignatorAccessList(DesignatorAccessList DesignatorAccessList) {
        this.DesignatorAccessList=DesignatorAccessList;
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
        if(DesignatorAccessList!=null) DesignatorAccessList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorAccessList!=null) DesignatorAccessList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorAccessList!=null) DesignatorAccessList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MemberAccess(\n");

        buffer.append(" "+tab+designator);
        buffer.append("\n");

        if(DesignatorAccessList!=null)
            buffer.append(DesignatorAccessList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MemberAccess]");
        return buffer.toString();
    }
}
