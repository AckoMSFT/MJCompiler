// generated with ast extension for cup
// version 0.8
// 3/0/2023 18:41:12


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementFunctionInvocation extends DesignatorStatement {

    private Designator Designator;
    private FunctionInvocation FunctionInvocation;

    public DesignatorStatementFunctionInvocation (Designator Designator, FunctionInvocation FunctionInvocation) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.FunctionInvocation=FunctionInvocation;
        if(FunctionInvocation!=null) FunctionInvocation.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public FunctionInvocation getFunctionInvocation() {
        return FunctionInvocation;
    }

    public void setFunctionInvocation(FunctionInvocation FunctionInvocation) {
        this.FunctionInvocation=FunctionInvocation;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(FunctionInvocation!=null) FunctionInvocation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(FunctionInvocation!=null) FunctionInvocation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(FunctionInvocation!=null) FunctionInvocation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementFunctionInvocation(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FunctionInvocation!=null)
            buffer.append(FunctionInvocation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementFunctionInvocation]");
        return buffer.toString();
    }
}
