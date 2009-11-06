<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@page import="org.eclipse.jst.ws.util.JspUtils"%>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleMailAndSMSPTProxyid" scope="session" class="org.sercho.MailAndSMS.MailAndSMSPTProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleMailAndSMSPTProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleMailAndSMSPTProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
        java.lang.String endpoint_0idTemp  = endpoint_0id;
        sampleMailAndSMSPTProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        org.sercho.MailAndSMS.MailAndSMSPT getMailAndSMSPT10mtemp = sampleMailAndSMSPTProxyid.getMailAndSMSPT();
if(getMailAndSMSPT10mtemp == null){
%>
<%=getMailAndSMSPT10mtemp %>
<%
}else{
        if(getMailAndSMSPT10mtemp!= null){
        String tempreturnp11 = getMailAndSMSPT10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String to_1id=  request.getParameter("to16");
        java.lang.String to_1idTemp  = to_1id;
        String text_2id=  request.getParameter("text18");
        java.lang.String text_2idTemp  = text_2id;
        boolean sendMail13mtemp = sampleMailAndSMSPTProxyid.sendMail(to_1idTemp,text_2idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sendMail13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 20:
        gotMethod = true;
        String to_3id=  request.getParameter("to23");
        java.lang.String to_3idTemp  = to_3id;
        String text_4id=  request.getParameter("text25");
        java.lang.String text_4idTemp  = text_4id;
        boolean sendSMS20mtemp = sampleMailAndSMSPTProxyid.sendSMS(to_3idTemp,text_4idTemp);
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sendSMS20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>