package de.dailab.vsdt.trafo.jiacbeans.export.generated;

import de.dailab.vsdt.trafo.jiacbeans.export.*;
import jiacbeans.*;
import java.util.*;
import java.io.*;

public class SubProcessGenerator
{
  protected static String nl;
  public static synchronized SubProcessGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SubProcessGenerator result = new SubProcessGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/**" + NL + " *  <!-- begin-user-doc -->" + NL + " *  <!-- end-user-doc -->" + NL + " *\tdelete the generated tag after you edited this method" + NL + " *  @generated" + NL + " */";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "{" + NL;
  protected final String TEXT_4 = NL + "\t/**" + NL + "\t *  <!-- begin-user-doc -->" + NL + "\t *  <!-- end-user-doc -->" + NL + "\t *\tdelete the generated tag after you edited this method" + NL + "\t *  @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "\t/**" + NL + " \t *  delete the generated tag after you edited this method" + NL + "\t *  @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     SubProcess process = (SubProcess)argument; 
   String classDeclaration = "class "+process.getName();
   List<Method> methods = process.getMethods();
   List<JavaVariable> attributes = process.getAttributes();
   List<SubProcess> subprocesses = process.getSubprocesses();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(classDeclaration);
    stringBuffer.append(TEXT_3);
     for(JavaVariable var: attributes){
    stringBuffer.append(TEXT_4);
    stringBuffer.append( var.toString());
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
     for(Method method : methods){
    stringBuffer.append(TEXT_7);
    String cS = method.toString();
	  String result = "";
	  BufferedReader reader = new BufferedReader(new StringReader(cS));
	  try{
	  	String line = reader.readLine();
		while(line!=null){
		  if(!line.equals(""))result+="\t"+line+"\n";
		  line = reader.readLine();
		}
	  }catch(IOException e){}
	
    stringBuffer.append(TEXT_8);
    stringBuffer.append( result+"\n");
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
     for(SubProcess sub : subprocesses){
    stringBuffer.append(TEXT_11);
    String cS = generate(sub);
	  String result = "";
	  BufferedReader reader = new BufferedReader(new StringReader(cS));
	  try{
	  	String line = reader.readLine();
		while(line!=null){
		  if(!line.equals(""))result+="\t"+line+"\n";
		  line = reader.readLine();
		}
	  }catch(IOException e){}
	
    stringBuffer.append(TEXT_12);
    stringBuffer.append( result+"\n");
    }
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
