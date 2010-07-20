package de.dailab.vsdt.vxl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.antlr.runtime.CharStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.parser.antlr.Lexer;

public class InternalVxlLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int Tokens=34;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_STRING=5;
    public static final int RULE_INT=6;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int RULE_WS=9;
    public static final int T15=15;
    public static final int T33=33;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T30=30;
    public static final int T19=19;
    public static final int T32=32;
    public static final int T31=31;
    public InternalVxlLexer() {;} 
    public InternalVxlLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:10:5: ( '(' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:10:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:11:5: ( ')' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:11:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:12:5: ( 'not' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:12:7: 'not'
            {
            match("not"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:13:5: ( '-' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:13:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:14:5: ( '[' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:14:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:15:5: ( ']' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:15:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:16:5: ( '.' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:16:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:17:5: ( 'true' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:17:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:18:5: ( 'false' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:18:7: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:19:5: ( 'null' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:19:7: 'null'
            {
            match("null"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:20:5: ( '<' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:20:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:21:5: ( '<=' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:21:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:22:5: ( '==' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:22:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:23:5: ( '!=' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:23:7: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:24:5: ( '>' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:24:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:25:5: ( '>=' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:25:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:26:5: ( '+' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:26:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:27:5: ( '*' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:27:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:28:5: ( '/' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:28:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:29:5: ( '%' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:29:7: '%'
            {
            match('%'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:30:5: ( 'and' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:30:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:31:5: ( 'or' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:31:7: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:32:5: ( '++' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:32:7: '++'
            {
            match("++"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1049:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1049:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1049:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1049:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1049:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1051:10: ( ( '0' .. '9' )+ )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1051:12: ( '0' .. '9' )+
            {
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1051:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1051:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1053:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:62: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1053:129: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1055:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1055:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1055:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFE')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1055:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1057:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1057:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1057:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1057:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1057:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1057:41: ( '\\r' )? '\\n'
                    {
                    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1057:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1057:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1059:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1059:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1059:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1061:16: ( . )
            // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1061:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=30;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='(') ) {
            alt12=1;
        }
        else if ( (LA12_0==')') ) {
            alt12=2;
        }
        else if ( (LA12_0=='n') ) {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA12_29 = input.LA(3);

                if ( (LA12_29=='t') ) {
                    int LA12_56 = input.LA(4);

                    if ( ((LA12_56>='0' && LA12_56<='9')||(LA12_56>='A' && LA12_56<='Z')||LA12_56=='_'||(LA12_56>='a' && LA12_56<='z')) ) {
                        alt12=24;
                    }
                    else {
                        alt12=3;}
                }
                else {
                    alt12=24;}
                }
                break;
            case 'u':
                {
                int LA12_30 = input.LA(3);

                if ( (LA12_30=='l') ) {
                    int LA12_57 = input.LA(4);

                    if ( (LA12_57=='l') ) {
                        int LA12_63 = input.LA(5);

                        if ( ((LA12_63>='0' && LA12_63<='9')||(LA12_63>='A' && LA12_63<='Z')||LA12_63=='_'||(LA12_63>='a' && LA12_63<='z')) ) {
                            alt12=24;
                        }
                        else {
                            alt12=10;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
                }
                break;
            default:
                alt12=24;}

        }
        else if ( (LA12_0=='-') ) {
            alt12=4;
        }
        else if ( (LA12_0=='[') ) {
            alt12=5;
        }
        else if ( (LA12_0==']') ) {
            alt12=6;
        }
        else if ( (LA12_0=='.') ) {
            alt12=7;
        }
        else if ( (LA12_0=='t') ) {
            int LA12_8 = input.LA(2);

            if ( (LA12_8=='r') ) {
                int LA12_36 = input.LA(3);

                if ( (LA12_36=='u') ) {
                    int LA12_58 = input.LA(4);

                    if ( (LA12_58=='e') ) {
                        int LA12_64 = input.LA(5);

                        if ( ((LA12_64>='0' && LA12_64<='9')||(LA12_64>='A' && LA12_64<='Z')||LA12_64=='_'||(LA12_64>='a' && LA12_64<='z')) ) {
                            alt12=24;
                        }
                        else {
                            alt12=8;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
            }
            else {
                alt12=24;}
        }
        else if ( (LA12_0=='f') ) {
            int LA12_9 = input.LA(2);

            if ( (LA12_9=='a') ) {
                int LA12_37 = input.LA(3);

                if ( (LA12_37=='l') ) {
                    int LA12_59 = input.LA(4);

                    if ( (LA12_59=='s') ) {
                        int LA12_65 = input.LA(5);

                        if ( (LA12_65=='e') ) {
                            int LA12_69 = input.LA(6);

                            if ( ((LA12_69>='0' && LA12_69<='9')||(LA12_69>='A' && LA12_69<='Z')||LA12_69=='_'||(LA12_69>='a' && LA12_69<='z')) ) {
                                alt12=24;
                            }
                            else {
                                alt12=9;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
            }
            else {
                alt12=24;}
        }
        else if ( (LA12_0=='<') ) {
            int LA12_10 = input.LA(2);

            if ( (LA12_10=='=') ) {
                alt12=12;
            }
            else {
                alt12=11;}
        }
        else if ( (LA12_0=='=') ) {
            int LA12_11 = input.LA(2);

            if ( (LA12_11=='=') ) {
                alt12=13;
            }
            else {
                alt12=30;}
        }
        else if ( (LA12_0=='!') ) {
            int LA12_12 = input.LA(2);

            if ( (LA12_12=='=') ) {
                alt12=14;
            }
            else {
                alt12=30;}
        }
        else if ( (LA12_0=='>') ) {
            int LA12_13 = input.LA(2);

            if ( (LA12_13=='=') ) {
                alt12=16;
            }
            else {
                alt12=15;}
        }
        else if ( (LA12_0=='+') ) {
            int LA12_14 = input.LA(2);

            if ( (LA12_14=='+') ) {
                alt12=23;
            }
            else {
                alt12=17;}
        }
        else if ( (LA12_0=='*') ) {
            alt12=18;
        }
        else if ( (LA12_0=='/') ) {
            switch ( input.LA(2) ) {
            case '*':
                {
                alt12=27;
                }
                break;
            case '/':
                {
                alt12=28;
                }
                break;
            default:
                alt12=19;}

        }
        else if ( (LA12_0=='%') ) {
            alt12=20;
        }
        else if ( (LA12_0=='a') ) {
            int LA12_18 = input.LA(2);

            if ( (LA12_18=='n') ) {
                int LA12_51 = input.LA(3);

                if ( (LA12_51=='d') ) {
                    int LA12_60 = input.LA(4);

                    if ( ((LA12_60>='0' && LA12_60<='9')||(LA12_60>='A' && LA12_60<='Z')||LA12_60=='_'||(LA12_60>='a' && LA12_60<='z')) ) {
                        alt12=24;
                    }
                    else {
                        alt12=21;}
                }
                else {
                    alt12=24;}
            }
            else {
                alt12=24;}
        }
        else if ( (LA12_0=='o') ) {
            int LA12_19 = input.LA(2);

            if ( (LA12_19=='r') ) {
                int LA12_52 = input.LA(3);

                if ( ((LA12_52>='0' && LA12_52<='9')||(LA12_52>='A' && LA12_52<='Z')||LA12_52=='_'||(LA12_52>='a' && LA12_52<='z')) ) {
                    alt12=24;
                }
                else {
                    alt12=22;}
            }
            else {
                alt12=24;}
        }
        else if ( (LA12_0=='^') ) {
            int LA12_20 = input.LA(2);

            if ( ((LA12_20>='A' && LA12_20<='Z')||LA12_20=='_'||(LA12_20>='a' && LA12_20<='z')) ) {
                alt12=24;
            }
            else {
                alt12=30;}
        }
        else if ( ((LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='b' && LA12_0<='e')||(LA12_0>='g' && LA12_0<='m')||(LA12_0>='p' && LA12_0<='s')||(LA12_0>='u' && LA12_0<='z')) ) {
            alt12=24;
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12=25;
        }
        else if ( (LA12_0=='\"') ) {
            int LA12_23 = input.LA(2);

            if ( ((LA12_23>='\u0000' && LA12_23<='\uFFFE')) ) {
                alt12=26;
            }
            else {
                alt12=30;}
        }
        else if ( (LA12_0=='\'') ) {
            int LA12_24 = input.LA(2);

            if ( ((LA12_24>='\u0000' && LA12_24<='\uFFFE')) ) {
                alt12=26;
            }
            else {
                alt12=30;}
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12=29;
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='#' && LA12_0<='$')||LA12_0=='&'||LA12_0==','||(LA12_0>=':' && LA12_0<=';')||(LA12_0>='?' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFE')) ) {
            alt12=30;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

            throw nvae;
        }
        switch (alt12) {
            case 1 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:90: T31
                {
                mT31(); 

                }
                break;
            case 22 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:94: T32
                {
                mT32(); 

                }
                break;
            case 23 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:98: T33
                {
                mT33(); 

                }
                break;
            case 24 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:102: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 25 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:110: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 26 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:119: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 27 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:131: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 28 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:147: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 29 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:163: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 30 :
                // ../de.dailab.vsdt.vxl4/src-gen/de/dailab/vsdt/vxl/parser/antlr/internal/InternalVxl.g:1:171: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}