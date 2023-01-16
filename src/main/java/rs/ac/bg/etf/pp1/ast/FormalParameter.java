// generated with ast extension for cup
// version 0.8
// 13/0/2023 5:29:16


package rs.ac.bg.etf.pp1.ast;

public class FormalParameter extends FormalParam {

    private Type Type;
    private String name;
    private MaybeArray MaybeArray;

    public FormalParameter (Type Type, String name, MaybeArray MaybeArray) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.name=name;
        this.MaybeArray=MaybeArray;
        if(MaybeArray!=null) MaybeArray.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
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

        buffer.append(" "+tab+name);
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
