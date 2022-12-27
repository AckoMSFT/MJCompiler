// generated with ast extension for cup
// version 0.8
// 27/11/2022 1:4:11


package rs.ac.bg.etf.pp1.ast;

public class DesignatorAccessListElement extends DesignatorAccessList {

    private DesignatorAccessList DesignatorAccessList;
    private ArrayElement ArrayElement;

    public DesignatorAccessListElement (DesignatorAccessList DesignatorAccessList, ArrayElement ArrayElement) {
        this.DesignatorAccessList=DesignatorAccessList;
        if(DesignatorAccessList!=null) DesignatorAccessList.setParent(this);
        this.ArrayElement=ArrayElement;
        if(ArrayElement!=null) ArrayElement.setParent(this);
    }

    public DesignatorAccessList getDesignatorAccessList() {
        return DesignatorAccessList;
    }

    public void setDesignatorAccessList(DesignatorAccessList DesignatorAccessList) {
        this.DesignatorAccessList=DesignatorAccessList;
    }

    public ArrayElement getArrayElement() {
        return ArrayElement;
    }

    public void setArrayElement(ArrayElement ArrayElement) {
        this.ArrayElement=ArrayElement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorAccessList!=null) DesignatorAccessList.accept(visitor);
        if(ArrayElement!=null) ArrayElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorAccessList!=null) DesignatorAccessList.traverseTopDown(visitor);
        if(ArrayElement!=null) ArrayElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorAccessList!=null) DesignatorAccessList.traverseBottomUp(visitor);
        if(ArrayElement!=null) ArrayElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorAccessListElement(\n");

        if(DesignatorAccessList!=null)
            buffer.append(DesignatorAccessList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ArrayElement!=null)
            buffer.append(ArrayElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorAccessListElement]");
        return buffer.toString();
    }
}
