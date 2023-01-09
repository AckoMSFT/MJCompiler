// generated with ast extension for cup
// version 0.8
// 9/0/2023 19:3:49


package rs.ac.bg.etf.pp1.ast;

public class DesignatorAccessListMember extends DesignatorAccessList {

    private DesignatorAccessList DesignatorAccessList;
    private MemberElement MemberElement;

    public DesignatorAccessListMember (DesignatorAccessList DesignatorAccessList, MemberElement MemberElement) {
        this.DesignatorAccessList=DesignatorAccessList;
        if(DesignatorAccessList!=null) DesignatorAccessList.setParent(this);
        this.MemberElement=MemberElement;
        if(MemberElement!=null) MemberElement.setParent(this);
    }

    public DesignatorAccessList getDesignatorAccessList() {
        return DesignatorAccessList;
    }

    public void setDesignatorAccessList(DesignatorAccessList DesignatorAccessList) {
        this.DesignatorAccessList=DesignatorAccessList;
    }

    public MemberElement getMemberElement() {
        return MemberElement;
    }

    public void setMemberElement(MemberElement MemberElement) {
        this.MemberElement=MemberElement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorAccessList!=null) DesignatorAccessList.accept(visitor);
        if(MemberElement!=null) MemberElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorAccessList!=null) DesignatorAccessList.traverseTopDown(visitor);
        if(MemberElement!=null) MemberElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorAccessList!=null) DesignatorAccessList.traverseBottomUp(visitor);
        if(MemberElement!=null) MemberElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorAccessListMember(\n");

        if(DesignatorAccessList!=null)
            buffer.append(DesignatorAccessList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MemberElement!=null)
            buffer.append(MemberElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorAccessListMember]");
        return buffer.toString();
    }
}
