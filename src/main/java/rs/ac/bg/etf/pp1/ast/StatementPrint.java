// generated with ast extension for cup
// version 0.8
// 26/11/2022 22:32:14


package rs.ac.bg.etf.pp1.ast;

public class StatementPrint extends Statement {

    private Expr Expr;
    private MaybePrintWidth MaybePrintWidth;

    public StatementPrint (Expr Expr, MaybePrintWidth MaybePrintWidth) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.MaybePrintWidth=MaybePrintWidth;
        if(MaybePrintWidth!=null) MaybePrintWidth.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public MaybePrintWidth getMaybePrintWidth() {
        return MaybePrintWidth;
    }

    public void setMaybePrintWidth(MaybePrintWidth MaybePrintWidth) {
        this.MaybePrintWidth=MaybePrintWidth;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(MaybePrintWidth!=null) MaybePrintWidth.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(MaybePrintWidth!=null) MaybePrintWidth.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(MaybePrintWidth!=null) MaybePrintWidth.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementPrint(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybePrintWidth!=null)
            buffer.append(MaybePrintWidth.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementPrint]");
        return buffer.toString();
    }
}
