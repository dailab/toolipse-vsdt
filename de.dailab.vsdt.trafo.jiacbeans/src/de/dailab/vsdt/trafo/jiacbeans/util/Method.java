package de.dailab.vsdt.trafo.jiacbeans.util;

import java.util.Set;

public class Method {
	public static final int PRIVATE = 0;
	public static final int PROTECTED = 1;
	public static final int PUBLIC = 2;
	public static final String[] VISIBILITIES = new String[]{"private","protected","public"};
	boolean isStatic = false;
	boolean isFinal = false;
	int visibility;
	String name;
	String returnType = "void";
	String content = "";
	Set<Variable> parameters;
	
	
	public Method(int visibility, boolean isStatic, boolean isFinal, String name){
		this.visibility = visibility;
		this.isStatic = isStatic;
		this.isFinal = isFinal;
		this.name = name;
	}
	
	public void addParameter(Variable var){
		parameters.add(var);
		
	}
	
	public void setStatic(boolean b){
		isStatic = b;
	}
	
	public boolean isStatic(){
		return isStatic;
	}
	
	public void setFinal(boolean b){
		isFinal = b;
	}
	
	public boolean isFinal(){
		return isFinal;
	}
	
	public String getName(){
		return name;
	}
	
	public String getReturnType(){
		return returnType;
	}
	
	
	public String toString(){
		String result = VISIBILITIES[visibility]+" ";
		if(isStatic) result+="static ";
		if(isFinal) result+="final ";
		result+= returnType+" "+name+"(";
		result+="){\n\t";
		content.replaceAll("\n", "\n\t");
		result += content+"\n"+"}";
		System.out.println(result);
		return result;
	}
}
