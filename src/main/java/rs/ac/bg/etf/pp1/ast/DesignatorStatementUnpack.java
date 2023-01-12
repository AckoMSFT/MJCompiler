// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementUnpack extends DesignatorStatement {

    private DesignatorStatementUnpackHeader DesignatorStatementUnpackHeader;
    private DesignatorList DesignatorList;
    private DesignatorStatementIntermezzo DesignatorStatementIntermezzo;
    private Designator Designator;

    public DesignatorStatementUnpack (DesignatorStatementUnpackHeader DesignatorStatementUnpackHeader, DesignatorList DesignatorList, DesignatorStatementIntermezzo DesignatorStatementIntermezzo, Designator Designator) {
        this.DesignatorStatementUnpackHeader=DesignatorStatementUnpackHeader;
        if(DesignatorStatementUnpackHeader!=null) DesignatorStatementUnpackHeader.setParent(this);
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
        this.DesignatorStatementIntermezzo=DesignatorStatementIntermezzo;
        if(DesignatorStatementIntermezzo!=null) DesignatorStatementIntermezzo.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesignatorStatementUnpackHeader getDesignatorStatementUnpackHeader() {
        return DesignatorStatementUnpackHeader;
    }

    public void setDesignatorStatementUnpackHeader(DesignatorStatementUnpackHeader DesignatorStatementUnpackHeader) {
        this.DesignatorStatementUnpackHeader=DesignatorStatementUnpackHeader;
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public DesignatorStatementIntermezzo getDesignatorStatementIntermezzo() {
        return DesignatorStatementIntermezzo;
    }

    public void setDesignatorStatementIntermezzo(DesignatorStatementIntermezzo DesignatorStatementIntermezzo) {
        this.DesignatorStatementIntermezzo=DesignatorStatementIntermezzo;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementUnpackHeader!=null) DesignatorStatementUnpackHeader.accept(visitor);
        if(DesignatorList!=null) DesignatorList.accept(visitor);
        if(DesignatorStatementIntermezzo!=null) DesignatorStatementIntermezzo.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementUnpackHeader!=null) DesignatorStatementUnpackHeader.traverseTopDown(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
        if(DesignatorStatementIntermezzo!=null) DesignatorStatementIntermezzo.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementUnpackHeader!=null) DesignatorStatementUnpackHeader.traverseBottomUp(visitor);
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        if(DesignatorStatementIntermezzo!=null) DesignatorStatementIntermezzo.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementUnpack(\n");

        if(DesignatorStatementUnpackHeader!=null)
            buffer.append(DesignatorStatementUnpackHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementIntermezzo!=null)
            buffer.append(DesignatorStatementIntermezzo.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementUnpack]");
        return buffer.toString();
    }
}
