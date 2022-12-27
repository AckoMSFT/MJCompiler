// generated with ast extension for cup
// version 0.8
// 27/11/2022 1:4:11


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementAssignment extends DesignatorStatement {

    private Designator Designator;
    private AssignmentOperation AssignmentOperation;

    public DesignatorStatementAssignment (Designator Designator, AssignmentOperation AssignmentOperation) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.AssignmentOperation=AssignmentOperation;
        if(AssignmentOperation!=null) AssignmentOperation.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public AssignmentOperation getAssignmentOperation() {
        return AssignmentOperation;
    }

    public void setAssignmentOperation(AssignmentOperation AssignmentOperation) {
        this.AssignmentOperation=AssignmentOperation;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(AssignmentOperation!=null) AssignmentOperation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(AssignmentOperation!=null) AssignmentOperation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(AssignmentOperation!=null) AssignmentOperation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementAssignment(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AssignmentOperation!=null)
            buffer.append(AssignmentOperation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementAssignment]");
        return buffer.toString();
    }
}
