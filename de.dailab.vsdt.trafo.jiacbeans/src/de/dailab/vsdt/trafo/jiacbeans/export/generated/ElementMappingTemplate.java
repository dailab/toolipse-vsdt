package de.dailab.vsdt.trafo.jiacbeans.export.generated;

import de.dailab.vsdt.*;

public class ElementMappingTemplate
{
  protected static String nl;
  public static synchronized ElementMappingTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ElementMappingTemplate result = new ElementMappingTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     BusinessProcessSystem bps = (BusinessProcessSystem) argument; 
     
	for(BusinessProcessDiagram bpd : bps.getBusinessProcesses()){
		bpd.toString();
	}

    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
