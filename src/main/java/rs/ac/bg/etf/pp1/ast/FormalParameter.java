// generated with ast extension for cup
// version 0.8
// 3/0/2023 18:22:17


package rs.ac.bg.etf.pp1.ast;

public class FormalParameter extends FormalParam {

    private Type Type;
    private String I2;
    private MaybeArray MaybeArray;

    public FormalParameter (Type Type, String I2, MaybeArray MaybeArray) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.MaybeArray=MaybeArray;
        if(MaybeArray!=null) MaybeArray.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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
        if(Type!=null) Type.accept(visitor);
        if(MaybeArray!=null) MaybeArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(MaybeArray!=null) MaybeArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(MaybeArray!=null) MaybeArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParameter(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(MaybeArray!=null)
            buffer.append(MaybeArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParameter]");
        return buffer.toString();
    }
}
