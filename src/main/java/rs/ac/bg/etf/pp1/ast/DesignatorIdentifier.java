// generated with ast extension for cup
// version 0.8
// 26/11/2022 22:32:14


package rs.ac.bg.etf.pp1.ast;

public class DesignatorIdentifier extends Designator {

    private String I1;
    private DesignatorAccessList DesignatorAccessList;

    public DesignatorIdentifier (String I1, DesignatorAccessList DesignatorAccessList) {
        this.I1=I1;
        this.DesignatorAccessList=DesignatorAccessList;
        if(DesignatorAccessList!=null) DesignatorAccessList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public DesignatorAccessList getDesignatorAccessList() {
        return DesignatorAccessList;
    }

    public void setDesignatorAccessList(DesignatorAccessList DesignatorAccessList) {
        this.DesignatorAccessList=DesignatorAccessList;
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
        buffer.append("DesignatorIdentifier(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(DesignatorAccessList!=null)
            buffer.append(DesignatorAccessList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorIdentifier]");
        return buffer.toString();
    }
}
