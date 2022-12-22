// generated with ast extension for cup
// version 0.8
// 22/11/2022 23:46:51


package src.main.java.rs.ac.bg.etf.pp1.ast;

public class ExprSingleTerm extends Expr {

    private MaybeNegative MaybeNegative;
    private Term Term;

    public ExprSingleTerm (MaybeNegative MaybeNegative, Term Term) {
        this.MaybeNegative=MaybeNegative;
        if(MaybeNegative!=null) MaybeNegative.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public MaybeNegative getMaybeNegative() {
        return MaybeNegative;
    }

    public void setMaybeNegative(MaybeNegative MaybeNegative) {
        this.MaybeNegative=MaybeNegative;
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
        if(MaybeNegative!=null) MaybeNegative.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MaybeNegative!=null) MaybeNegative.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MaybeNegative!=null) MaybeNegative.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprSingleTerm(\n");

        if(MaybeNegative!=null)
            buffer.append(MaybeNegative.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprSingleTerm]");
        return buffer.toString();
    }
}
