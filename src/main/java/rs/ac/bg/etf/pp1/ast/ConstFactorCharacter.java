// generated with ast extension for cup
// version 0.8
// 3/0/2023 18:22:17


package rs.ac.bg.etf.pp1.ast;

public class ConstFactorCharacter extends ConstFactor {

    private Character value;

    public ConstFactorCharacter (Character value) {
        this.value=value;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value=value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstFactorCharacter(\n");

        buffer.append(" "+tab+value);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstFactorCharacter]");
        return buffer.toString();
    }
}
