// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:32:8


package rs.ac.bg.etf.pp1.ast;

public class FormParsSingle extends FormPars {

    private FormalParam FormalParam;

    public FormParsSingle (FormalParam FormalParam) {
        this.FormalParam=FormalParam;
        if(FormalParam!=null) FormalParam.setParent(this);
    }

    public FormalParam getFormalParam() {
        return FormalParam;
    }

    public void setFormalParam(FormalParam FormalParam) {
        this.FormalParam=FormalParam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormalParam!=null) FormalParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormalParam!=null) FormalParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormalParam!=null) FormalParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsSingle(\n");

        if(FormalParam!=null)
            buffer.append(FormalParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsSingle]");
        return buffer.toString();
    }
}
