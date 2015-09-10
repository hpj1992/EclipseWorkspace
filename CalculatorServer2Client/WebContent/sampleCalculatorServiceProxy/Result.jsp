<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCalculatorServiceProxyid" scope="session" class="DefaultNamespace.CalculatorServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCalculatorServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleCalculatorServiceProxyid.getEndpoint();
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
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCalculatorServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        DefaultNamespace.CalculatorService getCalculatorService10mtemp = sampleCalculatorServiceProxyid.getCalculatorService();
if(getCalculatorService10mtemp == null){
%>
<%=getCalculatorService10mtemp %>
<%
}else{
        if(getCalculatorService10mtemp!= null){
        String tempreturnp11 = getCalculatorService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String firstNumber_1id=  request.getParameter("firstNumber16");
        int firstNumber_1idTemp  = Integer.parseInt(firstNumber_1id);
        String secondNumber_2id=  request.getParameter("secondNumber18");
        int secondNumber_2idTemp  = Integer.parseInt(secondNumber_2id);
        String operation_3id=  request.getParameter("operation20");
            java.lang.String operation_3idTemp = null;
        if(!operation_3id.equals("")){
         operation_3idTemp  = operation_3id;
        }
        float getResult13mtemp = sampleCalculatorServiceProxyid.getResult(firstNumber_1idTemp,secondNumber_2idTemp,operation_3idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getResult13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
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