<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Source.*" %>
      <%@page import="java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
  <head>
   
   <title>JustLikeYelp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/rating.css">
    
    <link rel='stylesheet' href='styles/tab.css'/>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="http://code.jquery.com/jquery-1.6.2.min.js"></script>	
  <script type="text/javascript">

$(document).ready(function() {
 
    //Default Action
    $(".tab_content").hide(); //Hide all content
    $("ul.tabs li:first").addClass("active").show(); //Activate first tab
    $(".tab_content:first").show(); //Show first tab content
     
    //On Click Event
    $("ul.tabs li").click(function() {
        $("ul.tabs li").removeClass("active"); //Remove any "active" class
        $(this).addClass("active"); //Add "active" class to selected tab
        $(".tab_content").hide(); //Hide all tab content
        var activeTab = $(this).find("a").attr("href"); 
        $(activeTab).fadeIn(); //Fade in the active content
        return false;
    });
 
});
</script>     
    
  </head>
  
  <body>
  <div class="container">
      <div class="jumbotron" style="height:200px;margin-bottom: 5px;width: 1155px;">
	  <div class="col-md-6">
        <h1>JustLikeYelp.com</h1>      
          </div>
	  <div> 
	   <div class="col-md-4">
		<input type="text" class="form-control" id="usr" style="width:100%" placeholder="Search places">
		</div>
		 <div class="col-md-2">
        <a href="#" class="btn btn-info btn-lg">Search</a>
		</div>
		
      </div>
	  <br/>
	 
	

</div>

      <div class="navbar navbar-default" role="navigation" style="margin-left:0px;">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <% User user=(User)request.getSession().getAttribute("user"); %>
            <p class="navbar-brand" href="#">Hello,<%=user.getFirstname() %></p>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Dashboard</a></li>
              <li><a href="ProfileServlet">Profile</a></li>    
            </ul>
            <ul class="nav navbar-nav navbar-right">
            
             <%--  <% var strLastLogin=String(lastLogin);
              var res=strLastLogin.substring(4,24);
              console.log(res);
              %> --%>
              <li><p class="navbar-brand">Last Login:<%= user.getLastmodified()%><p></li>
              <li><a href="LogoutServlet">Logout</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>



<br/>
  

    

<h3>
<%
String category=(String)request.getAttribute("categoryofnewbusiness");
if(category!=null)
{
	%>
	<h3>New Business was added to '<%=category %>' category successfully.</h3>
	<%
}
%>
</h3>
<div class="tabs">
  
<%
int intBizCount=0;
Categories[] arCategories=(Categories[])request.getSession().getAttribute("categories");
Business[] arBusinesses=(Business[])request.getSession().getAttribute("businesses");
System.out.println(arCategories.length);
System.out.println(arBusinesses.length);


System.out.println("in jsp"+arCategories.toString());
if(arCategories.length>0)
{

%>
<ul class="tabs">
  
    <%
    for(int i=1;i<=arCategories.length;i++)
    { 
    System.out.println("in here"+arCategories[i-1].getCategoryname());
    %>
    <li><a href="#tab<%=i%>"><%=arCategories[i-1].getCategoryname() %></a></li>
     
    <% }
    
 }
    %>
    <li><a href="#tabNewCat">Add Category</a></li>
  </ul>
  <%
  for(int i=1;i<=arCategories.length;i++)
  {
	 
  %>
    <div id="tab<%=i %>" class="tab_content">
   
 <table>
  <%
 
 for(int j=0;j<arBusinesses.length;j++)
	  {
		  int cat1=Integer.parseInt(arCategories[i-1].getCategoryid());
		  int cat2=Integer.parseInt(arBusinesses[j].getCategoryid());
		  
		  if(cat1==cat2)
		  {
			  intBizCount++;
			  if(intBizCount==1 || (intBizCount-1)%6==0)
			  {
		  %>
		  <tr>
		  <%} %>
  <td style="padding-right: 15px;"><h2 style="width: 150px;"><%=arBusinesses[j].getName()%></h2>
  <p>Zipcode:<%=arBusinesses[j].getZipcode().toString()%></p>
  <p>Contact:<%=arBusinesses[j].getContact().toString()%></p>
  <a href="BusinessServlet?bizid=<%=arBusinesses[j].getBizid()%>">more</a>
  </td>
  <% }//end of if
  %>
 
  <% if(intBizCount==0 || (intBizCount)%6==0)
			  {
		  %>
		  </tr>
		  <%} %>
  <%
		  }
  intBizCount=0;
  // end of inner for loop
		  %>
		 
  </table>
  <h3><a href="NewBusinessServlet?catid=<%=arCategories[i-1].getCategoryid() %>">Add New Business</a></h3>
  
  
		  </div>
		  <%
  } 
   %>
  <div id="tabNewCat" class="tab_content">
  <br/><br/>
  <div class="bs-example">
    <form class="form-inline" role="form" action="NewCategoryServlet" method="get" >
        <div class="form-group">
            <label class="sr-only" for="inputEmail">Category</label>
            <input type="text" class="form-control" name="categoryName" id="categoryName" placeholder="Category Name">
        </div>
        <br/><br/>
         <div class="form-group">
            <label class="sr-only" for="inputEmail">First Name</label>
            <input type="text" class="form-control" name="categoryDescription" id="categoryDescription" placeholder="Category Description">
        </div>
       
        <br/><br/>
        

        <button type="submit" class="btn btn-success">Create Category</button>
    </form>
    <br>

</div>
  </div>

<br/>

</div>
  </body>
</html>