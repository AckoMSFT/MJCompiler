// generated with ast extension for cup
// version 0.8
// 27/11/2022 1:4:11


package rs.ac.bg.etf.pp1.ast;

public class DeisgnatorListMulti extends DesignatorList {

    private DesignatorList DesignatorList;
    private MaybeDesignator MaybeDesignator;

    public DeisgnatorListMulti (DesignatorList DesignatorList, MaybeDesignator MaybeDesignator) {
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
        this.MaybeDesignator=MaybeDesignator;
        if(MaybeDesignator!=null) MaybeDesignator.setParent(this);
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
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
        if(DesignatorList!=null) DesignatorList.accept(visitor);
        if(MaybeDesignator!=null) MaybeDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
        if(MaybeDesignator!=null) MaybeDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        if(MaybeDesignator!=null) MaybeDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeisgnatorListMulti(\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybeDesignator!=null)
            buffer.append(MaybeDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeisgnatorListMulti]");
        return buffer.toString();
    }
}
