package de.dailab.vsdt.trafo.jiacbeans.export.generated;

public class TimeEventHandlerGenerator
{
  protected static String nl;
  public static synchronized TimeEventHandlerGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TimeEventHandlerGenerator result = new TimeEventHandlerGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t/**" + NL + "\t *  Inner class that handles time events" + NL + "\t *  @generated" + NL + "\t */" + NL + "\tclass TimeEventHandler extends Thread{" + NL + "\t\tDate whenToStop;" + NL + "\t\tThread toStop;" + NL + "\t\tboolean triggered = false;" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t *  <!-- begin-user-doc -->" + NL + "\t\t *  <!-- end-user-doc -->" + NL + "\t\t *\tdelete the generated tag after you edited this method" + NL + "\t\t *  @generated" + NL + "\t\t */" + NL + "\t\tpublic TimeEventHandler(String timeExpression, Thread toStop){" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhenToStop = new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss.SSSZ\").parse(timeExpression);" + NL + "\t\t\t} catch (ParseException e) {" + NL + "\t\t\t\tSystem.out.println(\"ParseException: Time Expression has to be in yyyy-MM-dd'T'HH:mm:ss.SSSZ format!\");" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t} " + NL + "\t\t\tthis.toStop = toStop;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t *  <!-- begin-user-doc -->" + NL + "\t\t *  <!-- end-user-doc -->" + NL + "\t\t *\tdelete the generated tag after you edited this method" + NL + "\t\t *  @generated" + NL + "\t\t */" + NL + "\t\tpublic void run(){" + NL + "\t\t\tlong time = whenToStop.getTime();" + NL + "\t\t\twhile(time>System.currentTimeMillis()){" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tThread.sleep(100);" + NL + "\t\t\t\t}catch(InterruptedException e ) { }" + NL + "\t\t\t}" + NL + "\t\t\ttoStop.stop();" + NL + "\t\t\ttriggered = true;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t *  <!-- begin-user-doc -->" + NL + "\t\t *  <!-- end-user-doc -->" + NL + "\t\t *\tdelete the generated tag after you edited this method" + NL + "\t\t *  @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean hasBeenTriggered(){" + NL + "\t\t\treturn triggered;" + NL + "\t\t}" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
