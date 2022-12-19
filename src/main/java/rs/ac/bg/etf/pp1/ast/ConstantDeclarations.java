// generated with ast extension for cup
// version 0.8
// 19/11/2022 1:31:19


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclarations extends ConstantDeclarationList {

    private ConstantDeclarationList ConstantDeclarationList;
    private ConstantDeclaration ConstantDeclaration;

    public ConstantDeclarations (ConstantDeclarationList ConstantDeclarationList, ConstantDeclaration ConstantDeclaration) {
        this.ConstantDeclarationList=ConstantDeclarationList;
        if(ConstantDeclarationList!=null) ConstantDeclarationList.setParent(this);
        this.ConstantDeclaration=ConstantDeclaration;
        if(ConstantDeclaration!=null) ConstantDeclaration.setParent(this);
    }

    public ConstantDeclarationList getConstantDeclarationList() {
        return ConstantDeclarationList;
    }

    public void setConstantDeclarationList(ConstantDeclarationList ConstantDeclarationList) {
        this.ConstantDeclarationList=ConstantDeclarationList;
    }

    public ConstantDeclaration getConstantDeclaration() {
        return ConstantDeclaration;
    }

    public void setConstantDeclaration(ConstantDeclaration ConstantDeclaration) {
        this.ConstantDeclaration=ConstantDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstantDeclarationList!=null) ConstantDeclarationList.accept(visitor);
        if(ConstantDeclaration!=null) ConstantDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstantDeclarationList!=null) ConstantDeclarationList.traverseTopDown(visitor);
        if(ConstantDeclaration!=null) ConstantDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstantDeclarationList!=null) ConstantDeclarationList.traverseBottomUp(visitor);
        if(ConstantDeclaration!=null) ConstantDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantDeclarations(\n");

        if(ConstantDeclarationList!=null)
            buffer.append(ConstantDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstantDeclaration!=null)
            buffer.append(ConstantDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclarations]");
        return buffer.toString();
    }
}
