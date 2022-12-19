package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

%%

%class MJLexer
%line
%column
%cup

%{
    Logger logger = LogManager.getLogger(MJLexer.class);

    private Symbol new_symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn);
    }

    private Symbol new_symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn, value);
    }
%}


%xstate COMMENT

%eofval{
    return new_symbol(sym.EOF);
%eofval}

%%

" " {}
"\b" {}
"\t" {}
"\r\n" {}
"\f" {}

/* Keywords */

"program" { return new_symbol(sym.PROGRAM, yytext()); }
"break" { return new_symbol(sym.BREAK, yytext()); }
"continue" { return new_symbol(sym.CONTINUE, yytext()); }
"read" { return new_symbol(sym.READ, yytext()); }
"print" { return new_symbol(sym.PRINT, yytext()); }
"while" { return new_symbol(sym.WHILE, yytext()); }
"foreach" { return new_symbol(sym.FOR_EACH, yytext()); }
"class" { return new_symbol(sym.CLASS, yytext()); }
"extends" { return new_symbol(sym.EXTENDS, yytext()); }
"new" { return new_symbol(sym.NEW, yytext()); }
"if" { return new_symbol(sym.IF, yytext()); }
"else" { return new_symbol(sym.ELSE, yytext()); }
"then" { return new_symbol(sym.THEN, yytext()); }
"static" { return new_symbol(sym.STATIC, yytext()); }
"const" { return new_symbol(sym.CONST, yytext()); }

/* Constants */

(true|false) { return new_symbol(sym.CONST_BOOLEAN, new Boolean(yytext()));}

/* Operators */

"+" { return new_symbol(sym.ADDITION, yytext()); }
"-" { return new_symbol(sym.SUBTRACTION, yytext()); }
"*" { return new_symbol(sym.MULTIPLICATION, yytext()); }
"/" { return new_symbol(sym.DIVISION, yytext()); }
"%" { return new_symbol(sym.MODULO, yytext()); }
"++" { return new_symbol(sym.INCREMENT, yytext()); }
"--" { return new_symbol(sym.DECREMENT, yytext()); }
"&&" { return new_symbol(sym.AND, yytext()); }
"||" { return new_symbol(sym.OR, yytext()); }
"=>" { return new_symbol(sym.LAMBDA, yytext()); }
"==" { return new_symbol(sym.EQUALS, yytext()); }
"!=" { return new_symbol(sym.NOT_EQUALS, yytext()); }
">" { return new_symbol(sym.GREATER_THAN, yytext()); }
"<" { return new_symbol(sym.LESS_THAN, yytext()); }
">=" { return new_symbol(sym.GREATER_OR_EQUAL_THAN, yytext()); }
"<=" { return new_symbol(sym.LESS_OR_EQUAL_THAN, yytext()); }
"=" { return new_symbol(sym.ASSIGNMENT, yytext()); }
"(" { return new_symbol(sym.LEFT_PARENTHESES, yytext()); }
")" { return new_symbol(sym.RIGHT_PARENTHESES, yytext()); }
"[" { return new_symbol(sym.LEFT_BRACKET, yytext()); }
"]" { return new_symbol(sym.RIGHT_BRACKET, yytext()); }
"{" { return new_symbol(sym.LEFT_BRACE, yytext()); }
"}" { return new_symbol(sym.RIGHT_BRACE, yytext()); }
"." { return new_symbol(sym.DOT, yytext()); }
"," { return new_symbol(sym.COLON, yytext()); }
";" { return new_symbol(sym.SEMI_COLON, yytext()); }

"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" {yybegin(YYINITIAL);}

[0-9]+ { return new_symbol(sym.CONST_NUMBER, new Integer(yytext())); }
([a-z]|[A-Z])[a-zA-Z0-9]*  { return new_symbol(sym.IDENTIFIER, yytext()); }

"'"[ -~]"'"		{ return new_symbol(sym.CONST_CHARACTER, new Character(yytext().charAt(1))); }

. {
    logger.error("Lexical analysis failure on line: " + (yyline + 1) + " with token: " + yytext());
}
