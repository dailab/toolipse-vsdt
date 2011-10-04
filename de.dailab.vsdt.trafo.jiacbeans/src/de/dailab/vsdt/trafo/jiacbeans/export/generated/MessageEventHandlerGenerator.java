package de.dailab.vsdt.trafo.jiacbeans.export.generated;

public class MessageEventHandlerGenerator
{
  protected static String nl;
  public static synchronized MessageEventHandlerGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    MessageEventHandlerGenerator result = new MessageEventHandlerGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tclass MessageEventHandler extends Thread{" + NL + "\t\tThread toStop;" + NL + "\t\tboolean triggered = false;" + NL + "\t\tString address;" + NL + "\t\tClass payloadClass;" + NL + "\t\tSpaceObserver<IFact> observer;" + NL + "\t\tAction joinAction;" + NL + "\t\tAction leaveAction;" + NL + "\t\tIGroupAddress groupAddress;" + NL + "\t\t" + NL + "\t\tpublic MessageEventHandler(String channel, String payloadType, Thread toStop){" + NL + "\t\t\taddress = channel;" + NL + "\t\t\tthis.toStop = toStop;" + NL + "\t\t\tjoinAction = retrieveAction(ICommunicationBean.ACTION_JOIN_GROUP);" + NL + "\t\t\tleaveAction = retrieveAction(ICommunicationBean.ACTION_LEAVE_GROUP);" + NL + "\t\t\tgroupAddress = CommunicationAddressFactory.createGroupAddress(address);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tpayloadClass = ClassLoader.getSystemClassLoader().loadClass(payloadType);" + NL + "\t\t\t} catch (ClassNotFoundException e) {" + NL + "\t\t\t\tlog.error(\"Class \"+payloadType+\" not Found!\");" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t} " + NL + "\t\t\tobserver = new SpaceObserver<IFact>(){" + NL + "\t\t\t\tpublic void notify(SpaceEvent<? extends IFact> event) {" + NL + "\t\t\t\t\tWriteCallEvent<IJiacMessage> wce = (WriteCallEvent<IJiacMessage>) event;" + NL + "\t\t\t\t\tIJiacMessage msg = wce.getObject();" + NL + "\t\t\t\t\tif(msg.getHeader(IJiacMessage.Header.SEND_TO).equals(address) &&" + NL + "\t\t\t\t\t   payloadClass.isInstance(wce.getObject().getPayload())){" + NL + "\t\t\t\t\t\tmemory.remove(wce.getObject());" + NL + "\t\t\t\t\t\tcompensate();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void run(){" + NL + "\t\t\tinvoke(joinAction, new Serializable[]{groupAddress});" + NL + "\t\t\tmemory.attach(observer);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void compensate(){" + NL + "\t\t\ttriggered = true;" + NL + "\t\t\tdetach();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void detach(){" + NL + "\t\t\tmemory.detach(observer);" + NL + "\t\t\tinvoke(leaveAction, new Serializable[]{groupAddress});" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic boolean hasBeenTriggered(){" + NL + "\t\t\treturn triggered;" + NL + "\t\t}" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
