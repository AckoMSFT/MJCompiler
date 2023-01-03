// generated with ast extension for cup
// version 0.8
// 3/0/2023 18:22:17


package rs.ac.bg.etf.pp1.ast;

public class FormParsMulti extends FormPars {

    private FormPars FormPars;
    private FormalParam FormalParam;

    public FormParsMulti (FormPars FormPars, FormalParam FormalParam) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.FormalParam=FormalParam;
        if(FormalParam!=null) FormalParam.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
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
        if(FormPars!=null) FormPars.accept(visitor);
        if(FormalParam!=null) FormalParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(FormalParam!=null) FormalParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(FormalParam!=null) FormalParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsMulti(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormalParam!=null)
            buffer.append(FormalParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsMulti]");
        return buffer.toString();
    }
}
