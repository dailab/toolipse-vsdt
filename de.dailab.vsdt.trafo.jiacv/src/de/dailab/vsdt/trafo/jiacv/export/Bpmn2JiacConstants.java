package de.dailab.vsdt.trafo.jiacv.export;

import de.dailab.agentworld.AgentworldFactory;
import de.dailab.jiactng.jadl.JadlFactory;

public interface Bpmn2JiacConstants {

//	public static final BeansFactory beanFac=	BeansFactory.eINSTANCE;
	public static final AgentworldFactory aweFac= AgentworldFactory.eINSTANCE;
	public static final JadlFactory jadlFac=	JadlFactory.eINSTANCE;
	public static final JadlElementFactory jef= JadlElementFactory.INSTANCE;
	
	public static final String TYPE_INT=		"int";
	public static final String TYPE_BYTE=		"byte";
	public static final String TYPE_SHORT=		"short";
	public static final String TYPE_LONG=		"long";
	public static final String TYPE_STRING=		"string";
	public static final String TYPE_FLOAT=		"float";
	public static final String TYPE_DOUBLE=		"double";
	public static final String TYPE_BOOL=		"bool";
	public static final String TYPE_URL=		"url";
	
	public static final String LITERAL_POPEN=	"(";
	public static final String LITERAL_PCLOSE=	")";
	public static final String LITERAL_COPEN=	"{";
	public static final String LITERAL_CCLOSE=	"}";
	public static final String LITERAL_COLON=	":";
	
	/*
	 * LITERALS FROM JADL++ EBNF
	 * 
	And : "&&";
	Or  : "||";
	Not : "!";
	Fac : "!";
	Add : "+";
	Sub : "-";
	Mul : "*";
	Div : "/";
	Lower        : "<";
	LowerEqual   : "<=";
	Greater      : ">";
	GreaterEqual : ">=";
	Equal        : "==";
	NotEqual     : "!=";
	*/
}
