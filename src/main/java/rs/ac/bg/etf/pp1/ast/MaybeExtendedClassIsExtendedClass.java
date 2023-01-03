// generated with ast extension for cup
// version 0.8
// 3/0/2023 18:41:12


package rs.ac.bg.etf.pp1.ast;

public class MaybeExtendedClassIsExtendedClass extends MaybeExtendedClass {

    private ExtendedClass ExtendedClass;

    public MaybeExtendedClassIsExtendedClass (ExtendedClass ExtendedClass) {
        this.ExtendedClass=ExtendedClass;
        if(ExtendedClass!=null) ExtendedClass.setParent(this);
    }

    public ExtendedClass getExtendedClass() {
        return ExtendedClass;
    }

    public void setExtendedClass(ExtendedClass ExtendedClass) {
        this.ExtendedClass=ExtendedClass;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendedClass!=null) ExtendedClass.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendedClass!=null) ExtendedClass.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendedClass!=null) ExtendedClass.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MaybeExtendedClassIsExtendedClass(\n");

        if(ExtendedClass!=null)
            buffer.append(ExtendedClass.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MaybeExtendedClassIsExtendedClass]");
        return buffer.toString();
    }
}
