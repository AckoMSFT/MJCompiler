// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class DesignatorElementAccess extends Designator {

    private Designator Designator;
    private ArrayElement ArrayElement;

    public DesignatorElementAccess (Designator Designator, ArrayElement ArrayElement) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ArrayElement=ArrayElement;
        if(ArrayElement!=null) ArrayElement.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
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
        if(Designator!=null) Designator.accept(visitor);
        if(ArrayElement!=null) ArrayElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ArrayElement!=null) ArrayElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ArrayElement!=null) ArrayElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorElementAccess(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ArrayElement!=null)
            buffer.append(ArrayElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorElementAccess]");
        return buffer.toString();
    }
}
