package de.dailab.vsdt.trafo.jiacbeans.util;

import java.util.Set;
import java.util.TreeSet;

public class JavaCode {
	
	private String fullName;
	private String superClass;//class name of the superclass 
	private Set<String> imports;
	private Set<String> interfaces;
	private Set<Variable> variables;
	private Set<Method> methods;
	
	public JavaCode(String fullName){
		this.fullName = fullName;
		interfaces = new TreeSet<String>();
		variables = new TreeSet<Variable>();
		imports = new TreeSet<String>();
		variables = new TreeSet<Variable>();
		methods = new TreeSet<Method>();
	}
	
	/**
	 * @param sc full name of the superclass, including package declaration
	 */
	public void setSuperClass(String sc){
		imports.add(sc);
		superClass = sc.substring(sc.lastIndexOf(".")+1,sc.length());
	}
	
	/**
	 * @return the className of the superclass
	 */
	public String getSuperClass(){
		return superClass;
	}
	
	public void addInterface(String interfaceName){
		imports.add(interfaceName);
		interfaces.add(interfaceName.substring(interfaceName.lastIndexOf(".")+1,interfaceName.length()));
	}
	
	public Set<String> getInterfaces(){
		TreeSet<String> copy = new TreeSet<String>();
		copy.addAll(interfaces);
		return copy;
	}
	
	public String getClassName(){
		return fullName.substring(fullName.lastIndexOf(".")+1, fullName.length());
	}
	
	public String getPackageName(){
		int lastPointIndex = fullName.lastIndexOf(".");
		if(lastPointIndex==-1)return "";
		return fullName.substring(0, lastPointIndex);
	}
	
	public Set<String> getImports(){
		TreeSet<String> copy = new TreeSet<String>();
		copy.addAll(imports);
		return copy;
	}
	
	public static void main(String[] args){
		JavaCode jc = new JavaCode("test.TestApplet");
		System.out.println(jc.getPackageName());
		System.out.println(jc.getClassName());
	}
}
