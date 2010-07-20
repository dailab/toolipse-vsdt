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
T18 : 'true' ;
T19 : 'false' ;
T20 : 'null' ;
T21 : '<' ;
T22 : '<=' ;
T23 : '==' ;
T24 : '!=' ;
T25 : '>' ;
T26 : '>=' ;
T27 : '+' ;
T28 : '*' ;
T29 : '/' ;
T30 : '%' ;
T31 : 'and' ;
T32 : 'or' ;
T33 : '++' ;

// $ANTLR src "../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1049
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1051
RULE_INT : ('0'..'9')+;

// $ANTLR src "../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1053
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1055
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1057
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1059
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g" 1061
RULE_ANY_OTHER : .;


