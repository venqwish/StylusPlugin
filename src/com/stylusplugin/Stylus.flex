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

WHITESPACE = [ \t]

COMMENT = {TRADITIONAL_COMMENT} | {DOCUMENTATION_COMMENT} | {LINE_COMMENT}

TRADITIONAL_COMMENT   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
DOCUMENTATION_COMMENT = "/**" {COMMENT_CONTENT} "*"+ "/"
COMMENT_CONTENT = ( [^*] | \*+ [^/*] )*
LINE_COMMENT = {WHITESPACE}* "//" .*

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
FIRST_VALUE_CHARACTER=[^ \n\r\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".

SEPARATOR=[:=]
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