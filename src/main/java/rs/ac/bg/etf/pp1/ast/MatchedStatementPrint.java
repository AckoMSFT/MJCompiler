// generated with ast extension for cup
// version 0.8
// 22/11/2022 23:46:51


package src.main.java.rs.ac.bg.etf.pp1.ast;

public class MatchedStatementPrint extends MatchedStatement {

    private Expr Expr;
    private MaybePrintNumConst MaybePrintNumConst;

    public MatchedStatementPrint (Expr Expr, MaybePrintNumConst MaybePrintNumConst) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.MaybePrintNumConst=MaybePrintNumConst;
        if(MaybePrintNumConst!=null) MaybePrintNumConst.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public MaybePrintNumConst getMaybePrintNumConst() {
        return MaybePrintNumConst;
    }

    public void setMaybePrintNumConst(MaybePrintNumConst MaybePrintNumConst) {
        this.MaybePrintNumConst=MaybePrintNumConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(MaybePrintNumConst!=null) MaybePrintNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(MaybePrintNumConst!=null) MaybePrintNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(MaybePrintNumConst!=null) MaybePrintNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedStatementPrint(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MaybePrintNumConst!=null)
            buffer.append(MaybePrintNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedStatementPrint]");
        return buffer.toString();
    }
}
