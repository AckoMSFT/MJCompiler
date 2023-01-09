// generated with ast extension for cup
// version 0.8
// 9/0/2023 19:3:49


package rs.ac.bg.etf.pp1.ast;

public class VariableDeclaration extends VarDeclaration {

    private String variableName;
    private MaybeArray MaybeArray;

    public VariableDeclaration (String variableName, MaybeArray MaybeArray) {
        this.variableName=variableName;
        this.MaybeArray=MaybeArray;
        if(MaybeArray!=null) MaybeArray.setParent(this);
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName=variableName;
    }

    public MaybeArray getMaybeArray() {
        return MaybeArray;
    }

    public void setMaybeArray(MaybeArray MaybeArray) {
        this.MaybeArray=MaybeArray;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MaybeArray!=null) MaybeArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeArray!=null) MaybeArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeArray!=null) MaybeArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableDeclaration(\n");

        buffer.append(" "+tab+variableName);
        buffer.append("\n");

        if(MaybeArray!=null)
            buffer.append(MaybeArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableDeclaration]");
        return buffer.toString();
    }
}
