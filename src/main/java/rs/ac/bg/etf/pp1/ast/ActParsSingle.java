// generated with ast extension for cup
// version 0.8
// 13/0/2023 5:29:16


package rs.ac.bg.etf.pp1.ast;

public class ActParsSingle extends ActPars {

    private ActualParameter ActualParameter;

    public ActParsSingle (ActualParameter ActualParameter) {
        this.ActualParameter=ActualParameter;
        if(ActualParameter!=null) ActualParameter.setParent(this);
    }

    public ActualParameter getActualParameter() {
        return ActualParameter;
    }

    public void setActualParameter(ActualParameter ActualParameter) {
        this.ActualParameter=ActualParameter;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActualParameter!=null) ActualParameter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParameter!=null) ActualParameter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParameter!=null) ActualParameter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsSingle(\n");

        if(ActualParameter!=null)
            buffer.append(ActualParameter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsSingle]");
        return buffer.toString();
    }
}
