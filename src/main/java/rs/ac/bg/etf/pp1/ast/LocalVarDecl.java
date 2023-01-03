// generated with ast extension for cup
// version 0.8
// 3/0/2023 18:22:17


package rs.ac.bg.etf.pp1.ast;

public class LocalVarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private LocalVariableDeclarationList LocalVariableDeclarationList;

    public LocalVarDecl (Type Type, LocalVariableDeclarationList LocalVariableDeclarationList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.LocalVariableDeclarationList=LocalVariableDeclarationList;
        if(LocalVariableDeclarationList!=null) LocalVariableDeclarationList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public LocalVariableDeclarationList getLocalVariableDeclarationList() {
        return LocalVariableDeclarationList;
    }

    public void setLocalVariableDeclarationList(LocalVariableDeclarationList LocalVariableDeclarationList) {
        this.LocalVariableDeclarationList=LocalVariableDeclarationList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(LocalVariableDeclarationList!=null) LocalVariableDeclarationList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(LocalVariableDeclarationList!=null) LocalVariableDeclarationList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(LocalVariableDeclarationList!=null) LocalVariableDeclarationList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVarDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVariableDeclarationList!=null)
            buffer.append(LocalVariableDeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVarDecl]");
        return buffer.toString();
    }
}
