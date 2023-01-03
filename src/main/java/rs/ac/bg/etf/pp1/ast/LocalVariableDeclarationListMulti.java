// generated with ast extension for cup
// version 0.8
// 3/0/2023 18:41:12


package rs.ac.bg.etf.pp1.ast;

public class LocalVariableDeclarationListMulti extends LocalVariableDeclarationList {

    private LocalVariableDeclarationList LocalVariableDeclarationList;
    private LocalVariableDeclaration LocalVariableDeclaration;

    public LocalVariableDeclarationListMulti (LocalVariableDeclarationList LocalVariableDeclarationList, LocalVariableDeclaration LocalVariableDeclaration) {
        this.LocalVariableDeclarationList=LocalVariableDeclarationList;
        if(LocalVariableDeclarationList!=null) LocalVariableDeclarationList.setParent(this);
        this.LocalVariableDeclaration=LocalVariableDeclaration;
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.setParent(this);
    }

    public LocalVariableDeclarationList getLocalVariableDeclarationList() {
        return LocalVariableDeclarationList;
    }

    public void setLocalVariableDeclarationList(LocalVariableDeclarationList LocalVariableDeclarationList) {
        this.LocalVariableDeclarationList=LocalVariableDeclarationList;
    }

    public LocalVariableDeclaration getLocalVariableDeclaration() {
        return LocalVariableDeclaration;
    }

    public void setLocalVariableDeclaration(LocalVariableDeclaration LocalVariableDeclaration) {
        this.LocalVariableDeclaration=LocalVariableDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LocalVariableDeclarationList!=null) LocalVariableDeclarationList.accept(visitor);
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LocalVariableDeclarationList!=null) LocalVariableDeclarationList.traverseTopDown(visitor);
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LocalVariableDeclarationList!=null) LocalVariableDeclarationList.traverseBottomUp(visitor);
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVariableDeclarationListMulti(\n");

        if(LocalVariableDeclarationList!=null)
            buffer.append(LocalVariableDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVariableDeclaration!=null)
            buffer.append(LocalVariableDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVariableDeclarationListMulti]");
        return buffer.toString();
    }
}
