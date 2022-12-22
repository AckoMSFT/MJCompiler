// generated with ast extension for cup
// version 0.8
// 22/11/2022 1:37:43


package rs.ac.bg.etf.pp1.ast;

public class GlobalDeclarations extends GlobalDeclarationList {

    private GlobalDeclarationList GlobalDeclarationList;
    private GlobalDeclarataion GlobalDeclarataion;

    public GlobalDeclarations (GlobalDeclarationList GlobalDeclarationList, GlobalDeclarataion GlobalDeclarataion) {
        this.GlobalDeclarationList=GlobalDeclarationList;
        if(GlobalDeclarationList!=null) GlobalDeclarationList.setParent(this);
        this.GlobalDeclarataion=GlobalDeclarataion;
        if(GlobalDeclarataion!=null) GlobalDeclarataion.setParent(this);
    }

    public GlobalDeclarationList getGlobalDeclarationList() {
        return GlobalDeclarationList;
    }

    public void setGlobalDeclarationList(GlobalDeclarationList GlobalDeclarationList) {
        this.GlobalDeclarationList=GlobalDeclarationList;
    }

    public GlobalDeclarataion getGlobalDeclarataion() {
        return GlobalDeclarataion;
    }

    public void setGlobalDeclarataion(GlobalDeclarataion GlobalDeclarataion) {
        this.GlobalDeclarataion=GlobalDeclarataion;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalDeclarationList!=null) GlobalDeclarationList.accept(visitor);
        if(GlobalDeclarataion!=null) GlobalDeclarataion.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalDeclarationList!=null) GlobalDeclarationList.traverseTopDown(visitor);
        if(GlobalDeclarataion!=null) GlobalDeclarataion.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalDeclarationList!=null) GlobalDeclarationList.traverseBottomUp(visitor);
        if(GlobalDeclarataion!=null) GlobalDeclarataion.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalDeclarations(\n");

        if(GlobalDeclarationList!=null)
            buffer.append(GlobalDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalDeclarataion!=null)
            buffer.append(GlobalDeclarataion.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalDeclarations]");
        return buffer.toString();
    }
}
