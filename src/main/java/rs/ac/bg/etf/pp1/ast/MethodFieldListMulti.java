// generated with ast extension for cup
// version 0.8
// 22/11/2022 23:46:51


package src.main.java.rs.ac.bg.etf.pp1.ast;

public class MethodFieldListMulti extends MethodFieldList {

    private MethodField MethodField;
    private MethodFieldList MethodFieldList;

    public MethodFieldListMulti (MethodField MethodField, MethodFieldList MethodFieldList) {
        this.MethodField=MethodField;
        if(MethodField!=null) MethodField.setParent(this);
        this.MethodFieldList=MethodFieldList;
        if(MethodFieldList!=null) MethodFieldList.setParent(this);
    }

    public MethodField getMethodField() {
        return MethodField;
    }

    public void setMethodField(MethodField MethodField) {
        this.MethodField=MethodField;
    }

    public MethodFieldList getMethodFieldList() {
        return MethodFieldList;
    }

    public void setMethodFieldList(MethodFieldList MethodFieldList) {
        this.MethodFieldList=MethodFieldList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodField!=null) MethodField.accept(visitor);
        if(MethodFieldList!=null) MethodFieldList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodField!=null) MethodField.traverseTopDown(visitor);
        if(MethodFieldList!=null) MethodFieldList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodField!=null) MethodField.traverseBottomUp(visitor);
        if(MethodFieldList!=null) MethodFieldList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodFieldListMulti(\n");

        if(MethodField!=null)
            buffer.append(MethodField.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodFieldList!=null)
            buffer.append(MethodFieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodFieldListMulti]");
        return buffer.toString();
    }
}
