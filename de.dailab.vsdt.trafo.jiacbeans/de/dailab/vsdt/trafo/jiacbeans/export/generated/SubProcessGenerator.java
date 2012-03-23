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
  protected final String TEXT_1 = NL + "class ";
  protected final String TEXT_2 = " {" + NL;
  protected final String TEXT_3 = NL + "\t/**" + NL + "\t *  <!-- begin-user-doc -->" + NL + "\t *  <!-- end-user-doc -->" + NL + "\t *\tdelete the generated tag after you edited this field" + NL + "\t *  @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + "\t/**" + NL + "\t *  <!-- begin-user-doc -->" + NL + "\t *  <!-- end-user-doc -->" + NL + "\t *\tdelete the generated tag after you edited this method" + NL + "\t *  @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + "\t";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     SubProcess process = (SubProcess) argument; 
   List<Method> methods = process.getMethods();
   List<JavaVariable> attributes = process.getAttributes();
   List<SubProcess> subprocesses = process.getSubprocesses();

    stringBuffer.append(TEXT_1);
    stringBuffer.append( process.getName() );
    stringBuffer.append(TEXT_2);
     for(JavaVariable var: attributes){
    stringBuffer.append(TEXT_3);
    stringBuffer.append( var.toString());
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
     for(Method method : methods){
    stringBuffer.append(TEXT_6);
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
	
    stringBuffer.append(TEXT_7);
    stringBuffer.append( result+"\n");
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
     for(SubProcess sub : subprocesses){
    stringBuffer.append(TEXT_10);
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
	
    stringBuffer.append(TEXT_11);
    stringBuffer.append( result+"\n");
    }
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
