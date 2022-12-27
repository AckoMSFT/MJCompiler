// generated with ast extension for cup
// version 0.8
// 27/11/2022 1:4:11


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementUnpack extends DesignatorStatement {

    private DesignatorList DesignatorList;
    private AssignmentOperator AssignmentOperator;
    private Designator Designator;

    public DesignatorStatementUnpack (DesignatorList DesignatorList, AssignmentOperator AssignmentOperator, Designator Designator) {
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
        this.AssignmentOperator=AssignmentOperator;
        if(AssignmentOperator!=null) AssignmentOperator.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public AssignmentOperator getAssignmentOperator() {
        return AssignmentOperator;
    }

    public void setAssignmentOperator(AssignmentOperator AssignmentOperator) {
        this.AssignmentOperator=AssignmentOperator;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.accept(visitor);
        if(AssignmentOperator!=null) AssignmentOperator.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
        if(AssignmentOperator!=null) AssignmentOperator.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        if(AssignmentOperator!=null) AssignmentOperator.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementUnpack(\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AssignmentOperator!=null)
            buffer.append(AssignmentOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementUnpack]");
        return buffer.toString();
    }
}
