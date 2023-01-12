// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignment implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String name;
    private AssignmentOperator AssignmentOperator;
    private Constant Constant;

    public ConstAssignment (String name, AssignmentOperator AssignmentOperator, Constant Constant) {
        this.name=name;
        this.AssignmentOperator=AssignmentOperator;
        if(AssignmentOperator!=null) AssignmentOperator.setParent(this);
        this.Constant=Constant;
        if(Constant!=null) Constant.setParent(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
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

        buffer.append(" "+tab+name);
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
