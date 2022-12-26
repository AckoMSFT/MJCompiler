// generated with ast extension for cup
// version 0.8
// 26/11/2022 22:32:14


package rs.ac.bg.etf.pp1.ast;

public class FactorNewArray extends Factor {

    private Type Type;
    private ArrayElement ArrayElement;

    public FactorNewArray (Type Type, ArrayElement ArrayElement) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ArrayElement=ArrayElement;
        if(ArrayElement!=null) ArrayElement.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(ArrayElement!=null) ArrayElement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayElement!=null) ArrayElement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayElement!=null) ArrayElement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewArray(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ArrayElement!=null)
            buffer.append(ArrayElement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewArray]");
        return buffer.toString();
    }
}