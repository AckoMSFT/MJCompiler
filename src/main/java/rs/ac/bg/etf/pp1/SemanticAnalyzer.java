package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class SemanticAnalyzer extends VisitorAdaptor {
    public int cntStaticVars = 0;

    public int cntArrays = 0;

 /*   public void visit(ConstantDeclaration constantDeclaration) {
        cntStaticVars++;
    }

    public void visit(MaybeArrayIsArray maybeArrayIsArray) {
        cntArrays++;
    }*/
}
