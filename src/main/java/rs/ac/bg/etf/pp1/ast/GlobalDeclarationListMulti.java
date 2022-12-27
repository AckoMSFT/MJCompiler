// generated with ast extension for cup
// version 0.8
// 27/11/2022 1:4:10


package rs.ac.bg.etf.pp1.ast;

public class GlobalDeclarationListMulti extends GlobalDeclarationList {

    private GlobalDeclarationList GlobalDeclarationList;
    private GlobalDeclaration GlobalDeclaration;

    public GlobalDeclarationListMulti (GlobalDeclarationList GlobalDeclarationList, GlobalDeclaration GlobalDeclaration) {
        this.GlobalDeclarationList=GlobalDeclarationList;
        if(GlobalDeclarationList!=null) GlobalDeclarationList.setParent(this);
        this.GlobalDeclaration=GlobalDeclaration;
        if(GlobalDeclaration!=null) GlobalDeclaration.setParent(this);
    }

    public GlobalDeclarationList getGlobalDeclarationList() {
        return GlobalDeclarationList;
    }

    public void setGlobalDeclarationList(GlobalDeclarationList GlobalDeclarationList) {
        this.GlobalDeclarationList=GlobalDeclarationList;
    }

    public GlobalDeclaration getGlobalDeclaration() {
        return GlobalDeclaration;
    }

    public void setGlobalDeclaration(GlobalDeclaration GlobalDeclaration) {
        this.GlobalDeclaration=GlobalDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalDeclarationList!=null) GlobalDeclarationList.accept(visitor);
        if(GlobalDeclaration!=null) GlobalDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalDeclarationList!=null) GlobalDeclarationList.traverseTopDown(visitor);
        if(GlobalDeclaration!=null) GlobalDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalDeclarationList!=null) GlobalDeclarationList.traverseBottomUp(visitor);
        if(GlobalDeclaration!=null) GlobalDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalDeclarationListMulti(\n");

        if(GlobalDeclarationList!=null)
            buffer.append(GlobalDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalDeclaration!=null)
            buffer.append(GlobalDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalDeclarationListMulti]");
        return buffer.toString();
    }
}
