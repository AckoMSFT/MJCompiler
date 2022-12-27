// generated with ast extension for cup
// version 0.8
// 27/11/2022 1:4:10


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarationListSingle extends ConstDeclarationList {

    private ConstAssignment ConstAssignment;

    public ConstDeclarationListSingle (ConstAssignment ConstAssignment) {
        this.ConstAssignment=ConstAssignment;
        if(ConstAssignment!=null) ConstAssignment.setParent(this);
    }

    public ConstAssignment getConstAssignment() {
        return ConstAssignment;
    }

    public void setConstAssignment(ConstAssignment ConstAssignment) {
        this.ConstAssignment=ConstAssignment;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstAssignment!=null) ConstAssignment.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstAssignment!=null) ConstAssignment.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstAssignment!=null) ConstAssignment.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarationListSingle(\n");

        if(ConstAssignment!=null)
            buffer.append(ConstAssignment.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarationListSingle]");
        return buffer.toString();
    }
}
