// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class StatementReturn extends Statement {

    private MaybeReturnValue MaybeReturnValue;

    public StatementReturn (MaybeReturnValue MaybeReturnValue) {
        this.MaybeReturnValue=MaybeReturnValue;
        if(MaybeReturnValue!=null) MaybeReturnValue.setParent(this);
    }

    public MaybeReturnValue getMaybeReturnValue() {
        return MaybeReturnValue;
    }

    public void setMaybeReturnValue(MaybeReturnValue MaybeReturnValue) {
        this.MaybeReturnValue=MaybeReturnValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MaybeReturnValue!=null) MaybeReturnValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeReturnValue!=null) MaybeReturnValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeReturnValue!=null) MaybeReturnValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementReturn(\n");

        if(MaybeReturnValue!=null)
            buffer.append(MaybeReturnValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementReturn]");
        return buffer.toString();
    }
}
