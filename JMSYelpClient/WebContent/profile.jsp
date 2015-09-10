<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Source.*" %>
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
   <style type="text/css">
    .bs-example{
    	margin: 0px;
    	width:500px;
    }
</style>
    
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
            <% User u=(User)request.getSession().getAttribute("user"); %>
             <p class="navbar-brand" href="#">Hello,<%= u.getFirstname() %></p>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li ><a href="DashboardServlet">Dashboard</a></li>
              <li class="active"><a href="#">Profile</a></li>
       
           
            </ul>
            <ul class="nav navbar-nav navbar-right">
            
           
                <li><p class="navbar-brand">Last Login:<%=u.getLastmodified() %><p></li>
              <li><a href="LogoutServlet">Logout</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>



<br/>



<div class="bs-example">
    <table class="table">
        <thead>
            <tr>
                <th>Profile Summary:</th>
                
            </tr>
        </thead>
        <tbody>
        <% User user=(User)request.getSession().getAttribute("user"); %>
            <tr class="success">
                <td>First Name</td>
                <td><%=user.getFirstname().toString()%></td>
                
            </tr>
            <tr class="info">
                <td>Last Name:</td>
                <td><%=user.getLastname()%></td>
                
            </tr>
            <tr class="warning">
                <td>Email:</td>
                <td><%=user.getEmail()%></td>
                
            </tr>
            <tr class="danger">
                <td>Zip:</td>
                <td><%=user.getZipcodel()%></td>
                
            </tr>
        </tbody>
    </table>
</div>

<div >
<h2> Your Reviews:</h2>
<%
Review[] arReviews=(Review[])request.getSession().getAttribute("reviews");
String[] arBusinessNames=(String[])request.getSession().getAttribute("businessnames");
if(arReviews!=null && arReviews.length>0)
{
for(int i=0;i<arReviews.length;i++)
{
%>

<div class="row" style="background-color: #eee;margin-left:0px;">
  <div class="col-md-3">
<h3><%=arBusinessNames[i] %></h3>
  
  </div>
  <div class="col-md-3">
<h3><%=arReviews[i].getRating()%><img src="./images/star2.png" alt="..." class="img-thumbnail" style="width: 7%;padding: 0px;border: none;border-radius: 0px;"></h3>
  </div>
  <div class="col-md-3">
<h3><%=arReviews[i].getComment()%></h3>
  </div>
  <div class="col-md-3">
<a href="BusinessServlet?bizid=<%=arReviews[i].getBizid()%>">Edit</a>
  </div>
</div>
<br/>
<%
}
}
else
{

%>
<h2>You have no reviews yet.Share your experience and rate businesses.</h2>
<%}%>
</div>
</div>
  </body>
</html>