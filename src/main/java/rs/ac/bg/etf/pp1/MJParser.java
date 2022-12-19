
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Mon Dec 19 01:19:54 CET 2022
//----------------------------------------------------

package rs.ac.bg.etf.pp1;

import java_cup.runtime.*;
import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** CUP v0.10k generated parser.
  * @version Mon Dec 19 01:19:54 CET 2022
  */
public class MJParser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public MJParser() {super();}

  /** Constructor which sets the default scanner. */
  public MJParser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\036\000\002\003\010\000\002\002\004\000\002\004" +
    "\003\000\002\005\004\000\002\005\002\000\002\006\003" +
    "\000\002\006\003\000\002\006\003\000\002\007\003\000" +
    "\002\010\003\000\002\011\003\000\002\012\004\000\002" +
    "\012\002\000\002\020\012\000\002\017\003\000\002\021" +
    "\004\000\002\022\003\000\002\023\003\000\002\013\003" +
    "\000\002\014\003\000\002\014\003\000\002\014\003\000" +
    "\002\014\003\000\002\014\003\000\002\014\003\000\002" +
    "\015\003\000\002\015\003\000\002\016\003\000\002\016" +
    "\003\000\002\016\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\004\004\005\001\002\000\004\002\041\001" +
    "\002\000\004\005\007\001\002\000\012\005\ufffd\015\ufffd" +
    "\024\ufffd\043\ufffd\001\002\000\012\005\uffff\015\uffff\024" +
    "\uffff\043\uffff\001\002\000\012\005\013\015\014\024\016" +
    "\043\017\001\002\000\012\005\ufffe\015\ufffe\024\ufffe\043" +
    "\ufffe\001\002\000\012\005\ufffb\015\ufffb\024\ufffb\043\ufffb" +
    "\001\002\000\012\005\ufff8\015\ufff8\024\ufff8\043\ufff8\001" +
    "\002\000\012\005\ufff7\015\ufff7\024\ufff7\043\ufff7\001\002" +
    "\000\012\005\ufffc\015\ufffc\024\ufffc\043\ufffc\001\002\000" +
    "\012\005\ufff9\015\ufff9\024\ufff9\043\ufff9\001\002\000\006" +
    "\005\ufff5\044\ufff5\001\002\000\012\005\ufffa\015\ufffa\024" +
    "\ufffa\043\ufffa\001\002\000\006\005\025\044\023\001\002" +
    "\000\004\005\040\001\002\000\004\002\001\001\002\000" +
    "\006\005\ufff6\044\ufff6\001\002\000\004\005\ufff3\001\002" +
    "\000\004\037\027\001\002\000\004\036\030\001\002\000" +
    "\004\040\ufff1\001\002\000\004\040\032\001\002\000\004" +
    "\005\013\001\002\000\004\043\034\001\002\000\004\027" +
    "\035\001\002\000\004\044\ufff0\001\002\000\004\044\037" +
    "\001\002\000\006\005\ufff4\044\ufff4\001\002\000\004\037" +
    "\ufff2\001\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\004\003\003\001\001\000\002\001\001\000" +
    "\004\004\005\001\001\000\004\005\007\001\001\000\002" +
    "\001\001\000\012\006\010\007\014\010\011\011\017\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\012\020\001\001\000\002\001\001\000\010\017\021" +
    "\020\023\021\025\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\022\030\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\010\032\001\001\000\002\001\001\000\004" +
    "\023\035\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$MJParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$MJParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$MJParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {

    Symbol symbol = this.getScanner().next_token();
    if (symbol != null && symbol.value != null) {
        logger.info("Line " + symbol.left + ": " + "Parsed symbol: " + symbol.value + " - " + LexerUtils.GetLexicalIdentifier(symbol.toString()));
    }
    return symbol;

    }


    Logger logger = LogManager.getLogger(MJParser.class);

    // slede redefinisani metodi za prijavu gresaka radi izmene teksta poruke

    boolean errorDetected = false;

    public void report_fatal_error(String message, Object info) throws java.lang.Exception {
        done_parsing();
        report_error(message, info);
    }

    public void syntax_error(Symbol curr_token) {
        report_error("Syntax error while parsing", curr_token);
    }

    public void unrecovered_syntax_error(Symbol curr_token) throws java.lang.Exception {
        report_fatal_error("Could not recover from syntax error", curr_token);
    }

    public void report_error(String message, Object info) {
        StringBuilder msg = new StringBuilder(message);
        if (info instanceof Symbol) {
            Symbol symbol = (Symbol) info;
            msg.append(" on line ").append(symbol.left);
            msg.append(" and column ").append(symbol.right);
            msg.append(" while parsing ").append(LexerUtils.GetLexicalIdentifier(symbol.toString()));
            msg.append(" with value ").append(symbol.value);
        }
        logger.error(msg.toString());

        errorDetected = true;
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$MJParser$actions {
  private final MJParser parser;

  /** Constructor */
  CUP$MJParser$actions(MJParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$MJParser$do_action(
    int                        CUP$MJParser$act_num,
    java_cup.runtime.lr_parser CUP$MJParser$parser,
    java.util.Stack            CUP$MJParser$stack,
    int                        CUP$MJParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$MJParser$result;

      /* select the action based on the action number */
      switch (CUP$MJParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // MultiplicationOperator ::= MODULO 
            {
              MultiplicationOperator RESULT = null;
		 RESULT=new MultiplicationOperatorModulo(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(12/*MultiplicationOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // MultiplicationOperator ::= DIVISION 
            {
              MultiplicationOperator RESULT = null;
		 RESULT=new MultiplicationOperatorDivision(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(12/*MultiplicationOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // MultiplicationOperator ::= MULTIPLICATION 
            {
              MultiplicationOperator RESULT = null;
		 RESULT=new MultiplicationOperatorMultiplication(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(12/*MultiplicationOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // AdditionOperator ::= SUBTRACTION 
            {
              AdditionOperator RESULT = null;
		 RESULT=new AdditionOperatorSubtraction(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(11/*AdditionOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // AdditionOperator ::= ADDITION 
            {
              AdditionOperator RESULT = null;
		 RESULT=new AdditionOperatorAddition(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(11/*AdditionOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // RelationOperator ::= LESS_OR_EQUAL_THAN 
            {
              RelationOperator RESULT = null;
		 RESULT=new RelationOperatorLessOrEqualThan(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*RelationOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // RelationOperator ::= LESS_THAN 
            {
              RelationOperator RESULT = null;
		 RESULT=new RelationOperatorLessThan(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*RelationOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // RelationOperator ::= GREATER_OR_EQUAL_THAN 
            {
              RelationOperator RESULT = null;
		 RESULT=new RelationOperatorGreaterOrEqualThan(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*RelationOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // RelationOperator ::= GREATER_THAN 
            {
              RelationOperator RESULT = null;
		 RESULT=new RelationOperatorGreaterThan(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*RelationOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // RelationOperator ::= NOT_EQUALS 
            {
              RelationOperator RESULT = null;
		 RESULT=new RelationOperatorNotEquals(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*RelationOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // RelationOperator ::= EQUALS 
            {
              RelationOperator RESULT = null;
		 RESULT=new RelationOperatorquals(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(10/*RelationOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // AssignmentOperator ::= ASSIGNMENT 
            {
              AssignmentOperator RESULT = null;
		 RESULT=new AssignmentOperator(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(9/*AssignmentOperator*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // StatementList ::= MULTIPLICATION 
            {
              StatementList RESULT = null;
		 RESULT=new StatementList(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(17/*StatementList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // FormalParameters ::= LAMBDA 
            {
              FormalParameters RESULT = null;
		 RESULT=new FormalParameters(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(16/*FormalParameters*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // MethodTypeName ::= Type IDENTIFIER 
            {
              MethodTypeName RESULT = null;
		int returnTypeleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int returnTyperight = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		Type returnType = (Type)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		int methodNameleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int methodNameright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		String methodName = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new MethodTypeName(returnType, methodName); RESULT.setLine(returnTypeleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(15/*MethodTypeName*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // Type ::= IDENTIFIER 
            {
              Type RESULT = null;
		int typeNameleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int typeNameright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		String typeName = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new Type(typeName); RESULT.setLine(typeNameleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(13/*Type*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // MethodDeclaration ::= MethodTypeName LEFT_PARENTHESES FormalParameters RIGHT_PARENTHESES VariableDeclarationList LEFT_BRACE StatementList RIGHT_BRACE 
            {
              MethodDeclaration RESULT = null;
		int M1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-7)).left;
		int M1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-7)).right;
		MethodTypeName M1 = (MethodTypeName)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-7)).value;
		int F2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-5)).left;
		int F2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-5)).right;
		FormalParameters F2 = (FormalParameters)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-5)).value;
		int V3left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left;
		int V3right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).right;
		VariableDeclarationList V3 = (VariableDeclarationList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).value;
		int S4left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int S4right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		StatementList S4 = (StatementList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new MethodDeclaration(M1, F2, V3, S4); RESULT.setLine(M1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(14/*MethodDeclaration*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-7)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // MethodDeclarationList ::= 
            {
              MethodDeclarationList RESULT = null;
		 RESULT=new MethodDeclarationEpsilon(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(8/*MethodDeclarationList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // MethodDeclarationList ::= MethodDeclarationList MethodDeclaration 
            {
              MethodDeclarationList RESULT = null;
		int M1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int M1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		MethodDeclarationList M1 = (MethodDeclarationList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		int M2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int M2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		MethodDeclaration M2 = (MethodDeclaration)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new MethodDeclarations(M1, M2); RESULT.setLine(M1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(8/*MethodDeclarationList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // ClassDeclarationList ::= CLASS 
            {
              ClassDeclarationList RESULT = null;
		 RESULT=new ClassDeclarationList(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(7/*ClassDeclarationList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // VariableDeclarationList ::= IDENTIFIER 
            {
              VariableDeclarationList RESULT = null;
		int I1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int I1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		String I1 = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new VariableDeclarationList(I1); RESULT.setLine(I1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(6/*VariableDeclarationList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // ConstantDeclarationList ::= CONST_BOOLEAN 
            {
              ConstantDeclarationList RESULT = null;
		 RESULT=new ConstantDeclarationList(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(5/*ConstantDeclarationList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // GlobalDeclarataion ::= ClassDeclarationList 
            {
              GlobalDeclarataion RESULT = null;
		int C1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int C1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		ClassDeclarationList C1 = (ClassDeclarationList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new GlobalDeclarationClassDeclarationList(C1); RESULT.setLine(C1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(4/*GlobalDeclarataion*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // GlobalDeclarataion ::= VariableDeclarationList 
            {
              GlobalDeclarataion RESULT = null;
		int V1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int V1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		VariableDeclarationList V1 = (VariableDeclarationList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new GlobalDeclarationVariableDeclarationList(V1); RESULT.setLine(V1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(4/*GlobalDeclarataion*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // GlobalDeclarataion ::= ConstantDeclarationList 
            {
              GlobalDeclarataion RESULT = null;
		int C1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int C1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		ConstantDeclarationList C1 = (ConstantDeclarationList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new GlobalDeclarationConstantDeclarationList(C1); RESULT.setLine(C1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(4/*GlobalDeclarataion*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // GlobalDeclarationList ::= 
            {
              GlobalDeclarationList RESULT = null;
		 RESULT=new GlobalDeclarationEpsilon(); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*GlobalDeclarationList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // GlobalDeclarationList ::= GlobalDeclarationList GlobalDeclarataion 
            {
              GlobalDeclarationList RESULT = null;
		int G1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int G1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		GlobalDeclarationList G1 = (GlobalDeclarationList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		int G2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int G2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		GlobalDeclarataion G2 = (GlobalDeclarataion)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new GlobalDeclarations(G1, G2); RESULT.setLine(G1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(3/*GlobalDeclarationList*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // ProgramName ::= IDENTIFIER 
            {
              ProgramName RESULT = null;
		int programNameleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left;
		int programNameright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right;
		String programName = (String)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).value;
		 RESULT=new ProgramName(programName); RESULT.setLine(programNameleft); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(2/*ProgramName*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= Program EOF 
            {
              SyntaxNode RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		Program start_val = (Program)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		RESULT = start_val;
              CUP$MJParser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$MJParser$parser.done_parsing();
          return CUP$MJParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // Program ::= PROGRAM ProgramName GlobalDeclarationList LEFT_BRACE MethodDeclarationList RIGHT_BRACE 
            {
              Program RESULT = null;
		int P1left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).left;
		int P1right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).right;
		ProgramName P1 = (ProgramName)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-4)).value;
		int G2left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).left;
		int G2right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).right;
		GlobalDeclarationList G2 = (GlobalDeclarationList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-3)).value;
		int M3left = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).left;
		int M3right = ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).right;
		MethodDeclarationList M3 = (MethodDeclarationList)((java_cup.runtime.Symbol) CUP$MJParser$stack.elementAt(CUP$MJParser$top-1)).value;
		 RESULT=new Program(P1, G2, M3); RESULT.setLine(P1left); 
              CUP$MJParser$result = new java_cup.runtime.Symbol(1/*Program*/, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-5)).left, ((java_cup.runtime.Symbol)CUP$MJParser$stack.elementAt(CUP$MJParser$top-0)).right, RESULT);
            }
          return CUP$MJParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

