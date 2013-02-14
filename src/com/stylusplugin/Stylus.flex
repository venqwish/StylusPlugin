package com.stylusplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.stylusplugin.psi.StylusTypes;
import com.intellij.psi.TokenType;

%%

%class StylusLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
LINE_TERMINATOR = \r|\n|\r\n
INPUT_CHARACTER = [^\r\n]
NUMBER = [1-9]

COMMENT = {COMMENT_CSS} | {COMMENT_SILENT}

COMMENT_CSS   = "/*" [^*] ~"*/"
COMMENT_SILENT = {WHITE_SPACE}* "//" .*

FIRST_VALUE_CHARACTER=[^ \n\r\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".

SEPARATOR=[::]
KEY_CHARACTER=[^:=\ \n\r\t\f\\] | "\\"{CRLF} | "\\".

%state WAITING_VALUE

%%

<YYINITIAL> {COMMENT}                           { yybegin(YYINITIAL); return StylusTypes.COMMENT; }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return StylusTypes.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return StylusTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}                                     { yybegin(YYINITIAL); return StylusTypes.CRLF; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return StylusTypes.VALUE; }

{CRLF}                                                     { yybegin(YYINITIAL); return StylusTypes.CRLF; }

{WHITE_SPACE}+                                              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }