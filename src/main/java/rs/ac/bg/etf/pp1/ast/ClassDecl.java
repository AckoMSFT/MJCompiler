// generated with ast extension for cup
// version 0.8
// 3/0/2023 18:41:12


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private MaybeExtendedClass MaybeExtendedClass;
    private ClassVarDeclList ClassVarDeclList;
    private MaybeClassMethodList MaybeClassMethodList;

    public ClassDecl (String I1, MaybeExtendedClass MaybeExtendedClass, ClassVarDeclList ClassVarDeclList, MaybeClassMethodList MaybeClassMethodList) {
        this.I1=I1;
        this.MaybeExtendedClass=MaybeExtendedClass;
        if(MaybeExtendedClass!=null) MaybeExtendedClass.setParent(this);
        this.ClassVarDeclList=ClassVarDeclList;
        if(ClassVarDeclList!=null) ClassVarDeclList.setParent(this);
        this.MaybeClassMethodList=MaybeClassMethodList;
        if(MaybeClassMethodList!=null) MaybeClassMethodList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public MaybeExtendedClass getMaybeExtendedClass() {
        return MaybeExtendedClass;
    }

    public void setMaybeExtendedClass(MaybeExtendedClass MaybeExtendedClass) {
        this.MaybeExtendedClass=MaybeExtendedClass;
    }

    public ClassVarDeclList getClassVarDeclList() {
        return ClassVarDeclList;
    }

    public void setClassVarDeclList(ClassVarDeclList ClassVarDeclList) {
        this.ClassVarDeclList=ClassVarDeclList;
    }

    public MaybeClassMethodList getMaybeClassMethodList() {
        return MaybeClassMethodList;
    }

    public void setMaybeClassMethodList(MaybeClassMethodList MaybeClassMethodList) {
        this.MaybeClassMethodList=MaybeClassMethodList;
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
        if(MaybeExtendedClass!=null) MaybeExtendedClass.accept(visitor);
        if(ClassVarDeclList!=null) ClassVarDeclList.accept(visitor);
        if(MaybeClassMethodList!=null) MaybeClassMethodList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeExtendedClass!=null) MaybeExtendedClass.traverseTopDown(visitor);
        if(ClassVarDeclList!=null) ClassVarDeclList.traverseTopDown(visitor);
        if(MaybeClassMethodList!=null) MaybeClassMethodList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeExtendedClass!=null) MaybeExtendedClass.traverseBottomUp(visitor);
        if(ClassVarDeclList!=null) ClassVarDeclList.traverseBottomUp(visitor);
        if(MaybeClassMethodList!=null) MaybeClassMethodList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(MaybeExtendedClass!=null)
            buffer.append(MaybeExtendedClass.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassVarDeclList!=null)
            buffer.append(ClassVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeClassMethodList!=null)
            buffer.append(MaybeClassMethodList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
