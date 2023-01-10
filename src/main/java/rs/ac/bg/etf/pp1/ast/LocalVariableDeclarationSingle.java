// generated with ast extension for cup
// version 0.8
// 10/0/2023 18:19:30


package rs.ac.bg.etf.pp1.ast;

public class LocalVariableDeclarationSingle extends LocalVariableDeclarationList {

    private LocalVariableDeclaration LocalVariableDeclaration;

    public LocalVariableDeclarationSingle (LocalVariableDeclaration LocalVariableDeclaration) {
        this.LocalVariableDeclaration=LocalVariableDeclaration;
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.setParent(this);
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
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVariableDeclarationSingle(\n");

        if(LocalVariableDeclaration!=null)
            buffer.append(LocalVariableDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVariableDeclarationSingle]");
        return buffer.toString();
    }
}
