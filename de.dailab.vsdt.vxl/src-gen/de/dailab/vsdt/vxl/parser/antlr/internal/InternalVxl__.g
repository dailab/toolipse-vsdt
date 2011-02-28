lexer grammar InternalVxl;
@header {
package de.dailab.vsdt.vxl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : '(' ;
T12 : ')' ;
T13 : 'not' ;
T14 : '-' ;
T15 : '[' ;
T16 : ']' ;
T17 : '.' ;
T18 : ',' ;
T19 : 'true' ;
T20 : 'false' ;
T21 : 'null' ;
T22 : '<' ;
T23 : '<=' ;
T24 : '==' ;
T25 : '!=' ;
T26 : '>' ;
T27 : '>=' ;
T28 : '+' ;
T29 : '*' ;
T30 : '/' ;
T31 : '%' ;
T32 : 'and' ;
T33 : 'or' ;
T34 : '++' ;

// $ANTLR src "../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1176
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1178
RULE_INT : ('0'..'9')+;

// $ANTLR src "../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1180
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1182
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1184
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1186
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.dailab.vsdt.vxl/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1188
RULE_ANY_OTHER : .;


