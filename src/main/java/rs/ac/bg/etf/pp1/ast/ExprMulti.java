// generated with ast extension for cup
// version 0.8
// 26/11/2022 2:26:45


package rs.ac.bg.etf.pp1.ast;

public class ExprMulti extends Expr {

    private Expr Expr;
    private AdditionOperator AdditionOperator;
    private Term Term;

    public ExprMulti (Expr Expr, AdditionOperator AdditionOperator, Term Term) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.AdditionOperator=AdditionOperator;
        if(AdditionOperator!=null) AdditionOperator.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public AdditionOperator getAdditionOperator() {
        return AdditionOperator;
    }

    public void setAdditionOperator(AdditionOperator AdditionOperator) {
        this.AdditionOperator=AdditionOperator;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(AdditionOperator!=null) AdditionOperator.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(AdditionOperator!=null) AdditionOperator.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(AdditionOperator!=null) AdditionOperator.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprMulti(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AdditionOperator!=null)
            buffer.append(AdditionOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprMulti]");
        return buffer.toString();
    }
}
