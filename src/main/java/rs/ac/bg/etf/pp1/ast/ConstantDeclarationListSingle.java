// generated with ast extension for cup
// version 0.8
// 22/11/2022 0:5:25


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclarationListSingle extends ConstantDeclarationList {

    private ConstantDeclaration ConstantDeclaration;

    public ConstantDeclarationListSingle (ConstantDeclaration ConstantDeclaration) {
        this.ConstantDeclaration=ConstantDeclaration;
        if(ConstantDeclaration!=null) ConstantDeclaration.setParent(this);
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
        if(ConstantDeclaration!=null) ConstantDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstantDeclaration!=null) ConstantDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstantDeclaration!=null) ConstantDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantDeclarationListSingle(\n");

        if(ConstantDeclaration!=null)
            buffer.append(ConstantDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclarationListSingle]");
        return buffer.toString();
    }
}
