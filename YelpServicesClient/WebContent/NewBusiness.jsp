<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Source.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>
    <title>JustLikeYelp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/rating.css">
   
       
<style type="text/css">
    .bs-example{
    	margin: 20px;
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
            <% User user=(User)request.getSession().getAttribute("user"); %>
            <p class="navbar-brand" href="#">Hello,<%=user.getFirstname() %></p>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="DashboardServlet">Dashboard</a></li>
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
<h4><dfn>Let your business grow with JustLikeYelp.</dfn></h4>
<br>
<div class="bs-example">
    <form class="form-inline" role="form" action="AddBusinessServlet" method="get" >
        <div class="form-group">
            <label class="sr-only" for="inputEmail">Email</label>
            <input type="text" class="form-control" name="txtBusinessName" id="txtBusinessName" placeholder="Business Name">
        </div>
        <br/><br/>
         <div class="form-group">
            <label class="sr-only" for="inputEmail">First Name</label>
            <input type="text" class="form-control" name="txtZipcode" id="txtZipcode" placeholder="Zipcode">
        </div>
        <br/><br/>
         <div class="form-group">
            <label class="sr-only" for="inputEmail">Email</label>
            <input type="text" class="form-control" name="txtContact" id="txtContact" placeholder="Contact">
        </div>
        <br/><br/>
        
        
        <button type="submit" class="btn btn-success">Add Business</button>
    </form>
    <br>
   
</div>
</div>
 
  </body>


  </html>
