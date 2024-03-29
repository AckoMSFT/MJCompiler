// generated with ast extension for cup
// version 0.8
// 13/0/2023 5:29:16


package rs.ac.bg.etf.pp1.ast;

public class FactorFunctionInvocation extends Factor {

    private FunctionInvocationHeader FunctionInvocationHeader;
    private FunctionInvocation FunctionInvocation;

    public FactorFunctionInvocation (FunctionInvocationHeader FunctionInvocationHeader, FunctionInvocation FunctionInvocation) {
        this.FunctionInvocationHeader=FunctionInvocationHeader;
        if(FunctionInvocationHeader!=null) FunctionInvocationHeader.setParent(this);
        this.FunctionInvocation=FunctionInvocation;
        if(FunctionInvocation!=null) FunctionInvocation.setParent(this);
    }

    public FunctionInvocationHeader getFunctionInvocationHeader() {
        return FunctionInvocationHeader;
    }

    public void setFunctionInvocationHeader(FunctionInvocationHeader FunctionInvocationHeader) {
        this.FunctionInvocationHeader=FunctionInvocationHeader;
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
        if(FunctionInvocationHeader!=null) FunctionInvocationHeader.accept(visitor);
        if(FunctionInvocation!=null) FunctionInvocation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FunctionInvocationHeader!=null) FunctionInvocationHeader.traverseTopDown(visitor);
        if(FunctionInvocation!=null) FunctionInvocation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FunctionInvocationHeader!=null) FunctionInvocationHeader.traverseBottomUp(visitor);
        if(FunctionInvocation!=null) FunctionInvocation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorFunctionInvocation(\n");

        if(FunctionInvocationHeader!=null)
            buffer.append(FunctionInvocationHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FunctionInvocation!=null)
            buffer.append(FunctionInvocation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorFunctionInvocation]");
        return buffer.toString();
    }
}
