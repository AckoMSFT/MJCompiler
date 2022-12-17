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

"program" { return new_symbol(sym.PROGRAM, yytext()); }
";" { return new_symbol(sym.SEMI_COLON, yytext()); }

"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" {yybegin(YYINITIAL);}

[0-9]+ { return new_symbol(sym.NUMBER, new Integer(yytext())); }
([a-z]|[A-Z])[a-zA-Z0-9]*  { return new_symbol(sym.IDENT, yytext()); }

. {
    logger.error("Lexical analysis failure on line: " + (yyline + 1) + " with token: " + yytext());
}
