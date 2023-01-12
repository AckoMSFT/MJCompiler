// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementIntermezzo implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private AssignmentOperator AssignmentOperator;

    public DesignatorStatementIntermezzo (AssignmentOperator AssignmentOperator) {
        this.AssignmentOperator=AssignmentOperator;
        if(AssignmentOperator!=null) AssignmentOperator.setParent(this);
    }

    public AssignmentOperator getAssignmentOperator() {
        return AssignmentOperator;
    }

    public void setAssignmentOperator(AssignmentOperator AssignmentOperator) {
        this.AssignmentOperator=AssignmentOperator;
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
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignmentOperator!=null) AssignmentOperator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignmentOperator!=null) AssignmentOperator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementIntermezzo(\n");

        if(AssignmentOperator!=null)
            buffer.append(AssignmentOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementIntermezzo]");
        return buffer.toString();
    }
}
