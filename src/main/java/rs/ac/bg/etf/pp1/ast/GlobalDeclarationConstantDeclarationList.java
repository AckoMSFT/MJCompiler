// generated with ast extension for cup
// version 0.8
// 19/11/2022 1:43:13


package rs.ac.bg.etf.pp1.ast;

public class GlobalDeclarationConstantDeclarationList extends GlobalDeclarataion {

    private ConstantDeclarationList ConstantDeclarationList;

    public GlobalDeclarationConstantDeclarationList (ConstantDeclarationList ConstantDeclarationList) {
        this.ConstantDeclarationList=ConstantDeclarationList;
        if(ConstantDeclarationList!=null) ConstantDeclarationList.setParent(this);
    }

    public ConstantDeclarationList getConstantDeclarationList() {
        return ConstantDeclarationList;
    }

    public void setConstantDeclarationList(ConstantDeclarationList ConstantDeclarationList) {
        this.ConstantDeclarationList=ConstantDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstantDeclarationList!=null) ConstantDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstantDeclarationList!=null) ConstantDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstantDeclarationList!=null) ConstantDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalDeclarationConstantDeclarationList(\n");

        if(ConstantDeclarationList!=null)
            buffer.append(ConstantDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalDeclarationConstantDeclarationList]");
        return buffer.toString();
    }
}
