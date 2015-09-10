<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceProxyid" scope="session" class="Connection.ServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleServiceProxyid.getEndpoint();
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
        sampleServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        Connection.Service getService10mtemp = sampleServiceProxyid.getService();
if(getService10mtemp == null){
%>
<%=getService10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 17:
        gotMethod = true;
        String email_1id=  request.getParameter("email20");
            java.lang.String email_1idTemp = null;
        if(!email_1id.equals("")){
         email_1idTemp  = email_1id;
        }
        String password_2id=  request.getParameter("password22");
            java.lang.String password_2idTemp = null;
        if(!password_2id.equals("")){
         password_2idTemp  = password_2id;
        }
        String firstname_3id=  request.getParameter("firstname24");
            java.lang.String firstname_3idTemp = null;
        if(!firstname_3id.equals("")){
         firstname_3idTemp  = firstname_3id;
        }
        String lastname_4id=  request.getParameter("lastname26");
            java.lang.String lastname_4idTemp = null;
        if(!lastname_4id.equals("")){
         lastname_4idTemp  = lastname_4id;
        }
        String zipcode_5id=  request.getParameter("zipcode28");
            java.lang.String zipcode_5idTemp = null;
        if(!zipcode_5id.equals("")){
         zipcode_5idTemp  = zipcode_5id;
        }
        sampleServiceProxyid.signup(email_1idTemp,password_2idTemp,firstname_3idTemp,lastname_4idTemp,zipcode_5idTemp);
break;
case 30:
        gotMethod = true;
        String username_6id=  request.getParameter("username45");
            java.lang.String username_6idTemp = null;
        if(!username_6id.equals("")){
         username_6idTemp  = username_6id;
        }
        String pwd_7id=  request.getParameter("pwd47");
            java.lang.String pwd_7idTemp = null;
        if(!pwd_7id.equals("")){
         pwd_7idTemp  = pwd_7id;
        }
        Source.User signin30mtemp = sampleServiceProxyid.signin(username_6idTemp,pwd_7idTemp);
if(signin30mtemp == null){
%>
<%=signin30mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">userid:</TD>
<TD>
<%
if(signin30mtemp != null){
java.lang.String typeuserid33 = signin30mtemp.getUserid();
        String tempResultuserid33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeuserid33));
        %>
        <%= tempResultuserid33 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(signin30mtemp != null){
java.lang.String typeemail35 = signin30mtemp.getEmail();
        String tempResultemail35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail35));
        %>
        <%= tempResultemail35 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lastmodified:</TD>
<TD>
<%
if(signin30mtemp != null){
java.lang.String typelastmodified37 = signin30mtemp.getLastmodified();
        String tempResultlastmodified37 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelastmodified37));
        %>
        <%= tempResultlastmodified37 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">zipcodel:</TD>
<TD>
<%
if(signin30mtemp != null){
java.lang.String typezipcodel39 = signin30mtemp.getZipcodel();
        String tempResultzipcodel39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typezipcodel39));
        %>
        <%= tempResultzipcodel39 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lastname:</TD>
<TD>
<%
if(signin30mtemp != null){
java.lang.String typelastname41 = signin30mtemp.getLastname();
        String tempResultlastname41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelastname41));
        %>
        <%= tempResultlastname41 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">firstname:</TD>
<TD>
<%
if(signin30mtemp != null){
java.lang.String typefirstname43 = signin30mtemp.getFirstname();
        String tempResultfirstname43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefirstname43));
        %>
        <%= tempResultfirstname43 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 49:
        gotMethod = true;
        Source.Categories[] getCategories49mtemp = sampleServiceProxyid.getCategories();
if(getCategories49mtemp == null){
%>
<%=getCategories49mtemp %>
<%
}else{
        String tempreturnp50 = null;
        if(getCategories49mtemp != null){
        java.util.List listreturnp50= java.util.Arrays.asList(getCategories49mtemp);
        tempreturnp50 = listreturnp50.toString();
        }
        %>
        <%=tempreturnp50%>
        <%
}
break;
case 52:
        gotMethod = true;
        String strName_8id=  request.getParameter("strName55");
            java.lang.String strName_8idTemp = null;
        if(!strName_8id.equals("")){
         strName_8idTemp  = strName_8id;
        }
        String strCategoryid_9id=  request.getParameter("strCategoryid57");
            java.lang.String strCategoryid_9idTemp = null;
        if(!strCategoryid_9id.equals("")){
         strCategoryid_9idTemp  = strCategoryid_9id;
        }
        String zipcode_10id=  request.getParameter("zipcode59");
            java.lang.String zipcode_10idTemp = null;
        if(!zipcode_10id.equals("")){
         zipcode_10idTemp  = zipcode_10id;
        }
        String contact_11id=  request.getParameter("contact61");
            java.lang.String contact_11idTemp = null;
        if(!contact_11id.equals("")){
         contact_11idTemp  = contact_11id;
        }
        sampleServiceProxyid.addNewBusiness(strName_8idTemp,strCategoryid_9idTemp,zipcode_10idTemp,contact_11idTemp);
break;
case 63:
        gotMethod = true;
        String bizid_12id=  request.getParameter("bizid66");
            java.lang.String bizid_12idTemp = null;
        if(!bizid_12id.equals("")){
         bizid_12idTemp  = bizid_12id;
        }
        String userid_13id=  request.getParameter("userid68");
            java.lang.String userid_13idTemp = null;
        if(!userid_13id.equals("")){
         userid_13idTemp  = userid_13id;
        }
        String rating_14id=  request.getParameter("rating70");
            java.lang.String rating_14idTemp = null;
        if(!rating_14id.equals("")){
         rating_14idTemp  = rating_14id;
        }
        String comment_15id=  request.getParameter("comment72");
            java.lang.String comment_15idTemp = null;
        if(!comment_15id.equals("")){
         comment_15idTemp  = comment_15id;
        }
        String strOperation_16id=  request.getParameter("strOperation74");
            java.lang.String strOperation_16idTemp = null;
        if(!strOperation_16id.equals("")){
         strOperation_16idTemp  = strOperation_16id;
        }
        sampleServiceProxyid.updateReviews(bizid_12idTemp,userid_13idTemp,rating_14idTemp,comment_15idTemp,strOperation_16idTemp);
break;
case 76:
        gotMethod = true;
        String strCatName_17id=  request.getParameter("strCatName79");
            java.lang.String strCatName_17idTemp = null;
        if(!strCatName_17id.equals("")){
         strCatName_17idTemp  = strCatName_17id;
        }
        String strDesc_18id=  request.getParameter("strDesc81");
            java.lang.String strDesc_18idTemp = null;
        if(!strDesc_18id.equals("")){
         strDesc_18idTemp  = strDesc_18id;
        }
        sampleServiceProxyid.addNewCategory(strCatName_17idTemp,strDesc_18idTemp);
break;
case 83:
        gotMethod = true;
        String userid_19id=  request.getParameter("userid86");
            java.lang.String userid_19idTemp = null;
        if(!userid_19id.equals("")){
         userid_19idTemp  = userid_19id;
        }
        java.lang.String[] getBusinessOfUsers83mtemp = sampleServiceProxyid.getBusinessOfUsers(userid_19idTemp);
if(getBusinessOfUsers83mtemp == null){
%>
<%=getBusinessOfUsers83mtemp %>
<%
}else{
        String tempreturnp84 = null;
        if(getBusinessOfUsers83mtemp != null){
        java.util.List listreturnp84= java.util.Arrays.asList(getBusinessOfUsers83mtemp);
        tempreturnp84 = listreturnp84.toString();
        }
        %>
        <%=tempreturnp84%>
        <%
}
break;
case 88:
        gotMethod = true;
        String strBizid_20id=  request.getParameter("strBizid91");
            java.lang.String strBizid_20idTemp = null;
        if(!strBizid_20id.equals("")){
         strBizid_20idTemp  = strBizid_20id;
        }
        java.lang.String[] getUSersOfBusiness88mtemp = sampleServiceProxyid.getUSersOfBusiness(strBizid_20idTemp);
if(getUSersOfBusiness88mtemp == null){
%>
<%=getUSersOfBusiness88mtemp %>
<%
}else{
        String tempreturnp89 = null;
        if(getUSersOfBusiness88mtemp != null){
        java.util.List listreturnp89= java.util.Arrays.asList(getUSersOfBusiness88mtemp);
        tempreturnp89 = listreturnp89.toString();
        }
        %>
        <%=tempreturnp89%>
        <%
}
break;
case 93:
        gotMethod = true;
        String bizid_21id=  request.getParameter("bizid96");
            java.lang.String bizid_21idTemp = null;
        if(!bizid_21id.equals("")){
         bizid_21idTemp  = bizid_21id;
        }
        Source.Review[] getReviewsOfBusiness93mtemp = sampleServiceProxyid.getReviewsOfBusiness(bizid_21idTemp);
if(getReviewsOfBusiness93mtemp == null){
%>
<%=getReviewsOfBusiness93mtemp %>
<%
}else{
        String tempreturnp94 = null;
        if(getReviewsOfBusiness93mtemp != null){
        java.util.List listreturnp94= java.util.Arrays.asList(getReviewsOfBusiness93mtemp);
        tempreturnp94 = listreturnp94.toString();
        }
        %>
        <%=tempreturnp94%>
        <%
}
break;
case 98:
        gotMethod = true;
        String userid_22id=  request.getParameter("userid101");
            java.lang.String userid_22idTemp = null;
        if(!userid_22id.equals("")){
         userid_22idTemp  = userid_22id;
        }
        sampleServiceProxyid.updateLastLoginTime(userid_22idTemp);
break;
case 103:
        gotMethod = true;
        Source.Business[] getBusinesses103mtemp = sampleServiceProxyid.getBusinesses();
if(getBusinesses103mtemp == null){
%>
<%=getBusinesses103mtemp %>
<%
}else{
        String tempreturnp104 = null;
        if(getBusinesses103mtemp != null){
        java.util.List listreturnp104= java.util.Arrays.asList(getBusinesses103mtemp);
        tempreturnp104 = listreturnp104.toString();
        }
        %>
        <%=tempreturnp104%>
        <%
}
break;
case 106:
        gotMethod = true;
        String userid_23id=  request.getParameter("userid109");
            java.lang.String userid_23idTemp = null;
        if(!userid_23id.equals("")){
         userid_23idTemp  = userid_23id;
        }
        Source.Review[] getReviewsOfUser106mtemp = sampleServiceProxyid.getReviewsOfUser(userid_23idTemp);
if(getReviewsOfUser106mtemp == null){
%>
<%=getReviewsOfUser106mtemp %>
<%
}else{
        String tempreturnp107 = null;
        if(getReviewsOfUser106mtemp != null){
        java.util.List listreturnp107= java.util.Arrays.asList(getReviewsOfUser106mtemp);
        tempreturnp107 = listreturnp107.toString();
        }
        %>
        <%=tempreturnp107%>
        <%
}
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