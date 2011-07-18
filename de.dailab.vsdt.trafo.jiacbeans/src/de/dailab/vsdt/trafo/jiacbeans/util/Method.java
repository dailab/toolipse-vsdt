package de.dailab.vsdt.trafo.jiacbeans.util;

import java.util.Set;

public class Method {
	public static final int PRIVATE = 0;
	public static final int PROTECTED = 1;
	public static final int PUBLIC = 2;
	
	boolean isStatic = false;
	boolean isFinal = false;
	int visibility;
	String name;
	String returnType;
	String content;
	Set<Variable> parameters;
	
	
	public Method(int visibility, boolean isStatic, boolean isFinal, String name){
		
	}
	
	private void addParameter(Variable var){
		parameters.add(var);
		
	}
	
	private void setStatic(boolean b){
		isStatic = b;
	}
	
	private boolean isStatic(){
		return isStatic;
	}
	
	private void setFinal(boolean b){
		isFinal = b;
	}
	
	private boolean isFinal(){
		return isFinal;
	}
}
