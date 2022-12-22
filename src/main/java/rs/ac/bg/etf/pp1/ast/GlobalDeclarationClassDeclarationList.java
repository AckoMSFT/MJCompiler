// generated with ast extension for cup
// version 0.8
// 22/11/2022 0:5:25


package rs.ac.bg.etf.pp1.ast;

public class GlobalDeclarationClassDeclarationList extends GlobalDeclarataion {

    private ClassDeclarationList ClassDeclarationList;

    public GlobalDeclarationClassDeclarationList (ClassDeclarationList ClassDeclarationList) {
        this.ClassDeclarationList=ClassDeclarationList;
        if(ClassDeclarationList!=null) ClassDeclarationList.setParent(this);
    }

    public ClassDeclarationList getClassDeclarationList() {
        return ClassDeclarationList;
    }

    public void setClassDeclarationList(ClassDeclarationList ClassDeclarationList) {
        this.ClassDeclarationList=ClassDeclarationList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassDeclarationList!=null) ClassDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclarationList!=null) ClassDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclarationList!=null) ClassDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalDeclarationClassDeclarationList(\n");

        if(ClassDeclarationList!=null)
            buffer.append(ClassDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalDeclarationClassDeclarationList]");
        return buffer.toString();
    }
}
