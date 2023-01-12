// generated with ast extension for cup
// version 0.8
// 12/0/2023 4:43:31


package rs.ac.bg.etf.pp1.ast;

public class TermMulti extends Term {

    private Term Term;
    private MultiplicationOperator MultiplicationOperator;
    private Factor Factor;

    public TermMulti (Term Term, MultiplicationOperator MultiplicationOperator, Factor Factor) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.MultiplicationOperator=MultiplicationOperator;
        if(MultiplicationOperator!=null) MultiplicationOperator.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public MultiplicationOperator getMultiplicationOperator() {
        return MultiplicationOperator;
    }

    public void setMultiplicationOperator(MultiplicationOperator MultiplicationOperator) {
        this.MultiplicationOperator=MultiplicationOperator;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(MultiplicationOperator!=null) MultiplicationOperator.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(MultiplicationOperator!=null) MultiplicationOperator.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(MultiplicationOperator!=null) MultiplicationOperator.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermMulti(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MultiplicationOperator!=null)
            buffer.append(MultiplicationOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermMulti]");
        return buffer.toString();
    }
}
