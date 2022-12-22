// generated with ast extension for cup
// version 0.8
// 22/11/2022 1:37:43


package rs.ac.bg.etf.pp1.ast;

public class VariableDeclarations extends VariableDeclarationList {

    private VariableDeclarationListWithSeparator VariableDeclarationListWithSeparator;
    private VariableDeclaration VariableDeclaration;

    public VariableDeclarations (VariableDeclarationListWithSeparator VariableDeclarationListWithSeparator, VariableDeclaration VariableDeclaration) {
        this.VariableDeclarationListWithSeparator=VariableDeclarationListWithSeparator;
        if(VariableDeclarationListWithSeparator!=null) VariableDeclarationListWithSeparator.setParent(this);
        this.VariableDeclaration=VariableDeclaration;
        if(VariableDeclaration!=null) VariableDeclaration.setParent(this);
    }

    public VariableDeclarationListWithSeparator getVariableDeclarationListWithSeparator() {
        return VariableDeclarationListWithSeparator;
    }

    public void setVariableDeclarationListWithSeparator(VariableDeclarationListWithSeparator VariableDeclarationListWithSeparator) {
        this.VariableDeclarationListWithSeparator=VariableDeclarationListWithSeparator;
    }

    public VariableDeclaration getVariableDeclaration() {
        return VariableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration VariableDeclaration) {
        this.VariableDeclaration=VariableDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VariableDeclarationListWithSeparator!=null) VariableDeclarationListWithSeparator.accept(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableDeclarationListWithSeparator!=null) VariableDeclarationListWithSeparator.traverseTopDown(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableDeclarationListWithSeparator!=null) VariableDeclarationListWithSeparator.traverseBottomUp(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableDeclarations(\n");

        if(VariableDeclarationListWithSeparator!=null)
            buffer.append(VariableDeclarationListWithSeparator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariableDeclaration!=null)
            buffer.append(VariableDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableDeclarations]");
        return buffer.toString();
    }
}
