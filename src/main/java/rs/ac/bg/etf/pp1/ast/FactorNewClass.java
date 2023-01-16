// generated with ast extension for cup
// version 0.8
// 13/0/2023 5:29:16


package rs.ac.bg.etf.pp1.ast;

public class FactorNewClass extends Factor {

    private Type Type;
    private FunctionInvocation FunctionInvocation;

    public FactorNewClass (Type Type, FunctionInvocation FunctionInvocation) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FunctionInvocation=FunctionInvocation;
        if(FunctionInvocation!=null) FunctionInvocation.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(FunctionInvocation!=null) FunctionInvocation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FunctionInvocation!=null) FunctionInvocation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FunctionInvocation!=null) FunctionInvocation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewClass(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FunctionInvocation!=null)
            buffer.append(FunctionInvocation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewClass]");
        return buffer.toString();
    }
}
