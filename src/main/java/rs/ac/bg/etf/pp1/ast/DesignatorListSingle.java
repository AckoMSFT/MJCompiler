// generated with ast extension for cup
// version 0.8
// 3/0/2023 18:22:17


package rs.ac.bg.etf.pp1.ast;

public class DesignatorListSingle extends DesignatorList {

    private MaybeDesignator MaybeDesignator;

    public DesignatorListSingle (MaybeDesignator MaybeDesignator) {
        this.MaybeDesignator=MaybeDesignator;
        if(MaybeDesignator!=null) MaybeDesignator.setParent(this);
    }

    public MaybeDesignator getMaybeDesignator() {
        return MaybeDesignator;
    }

    public void setMaybeDesignator(MaybeDesignator MaybeDesignator) {
        this.MaybeDesignator=MaybeDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MaybeDesignator!=null) MaybeDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeDesignator!=null) MaybeDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeDesignator!=null) MaybeDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorListSingle(\n");

        if(MaybeDesignator!=null)
            buffer.append(MaybeDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorListSingle]");
        return buffer.toString();
    }
}
