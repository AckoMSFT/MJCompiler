// generated with ast extension for cup
// version 0.8
// 13/0/2023 5:29:16


package rs.ac.bg.etf.pp1.ast;

public class ActParsMulti extends ActPars {

    private ActPars ActPars;
    private ActualParameter ActualParameter;

    public ActParsMulti (ActPars ActPars, ActualParameter ActualParameter) {
        this.ActPars=ActPars;
        if(ActPars!=null) ActPars.setParent(this);
        this.ActualParameter=ActualParameter;
        if(ActualParameter!=null) ActualParameter.setParent(this);
    }

    public ActPars getActPars() {
        return ActPars;
    }

    public void setActPars(ActPars ActPars) {
        this.ActPars=ActPars;
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
        if(ActPars!=null) ActPars.accept(visitor);
        if(ActualParameter!=null) ActualParameter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActPars!=null) ActPars.traverseTopDown(visitor);
        if(ActualParameter!=null) ActualParameter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActPars!=null) ActPars.traverseBottomUp(visitor);
        if(ActualParameter!=null) ActualParameter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsMulti(\n");

        if(ActPars!=null)
            buffer.append(ActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActualParameter!=null)
            buffer.append(ActualParameter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsMulti]");
        return buffer.toString();
    }
}
