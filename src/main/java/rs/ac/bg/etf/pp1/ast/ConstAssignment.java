// generated with ast extension for cup
// version 0.8
// 27/11/2022 1:4:10


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignment implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private AssignmentOperator AssignmentOperator;
    private Constant Constant;

    public ConstAssignment (String I1, AssignmentOperator AssignmentOperator, Constant Constant) {
        this.I1=I1;
        this.AssignmentOperator=AssignmentOperator;
        if(AssignmentOperator!=null) AssignmentOperator.setParent(this);
        this.Constant=Constant;
        if(Constant!=null) Constant.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public AssignmentOperator getAssignmentOperator() {
        return AssignmentOperator;
    }

    public void setAssignmentOperator(AssignmentOperator AssignmentOperator) {
        this.AssignmentOperator=AssignmentOperator;
    }

    public Constant getConstant() {
        return Constant;
    }

    public void setConstant(Constant Constant) {
        this.Constant=Constant;
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
        if(AssignmentOperator!=null) AssignmentOperator.accept(visitor);
        if(Constant!=null) Constant.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignmentOperator!=null) AssignmentOperator.traverseTopDown(visitor);
        if(Constant!=null) Constant.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignmentOperator!=null) AssignmentOperator.traverseBottomUp(visitor);
        if(Constant!=null) Constant.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstAssignment(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(AssignmentOperator!=null)
            buffer.append(AssignmentOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Constant!=null)
            buffer.append(Constant.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignment]");
        return buffer.toString();
    }
}
