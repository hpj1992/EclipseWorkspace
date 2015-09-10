<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Login</title>

    <link rel='stylesheet' href='styles/tab.css'/>
     <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/rating.css">

<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
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
        var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
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

<div class="bs-example">
    <form class="form-inline" role="form" action="LoginServlet" method="get">
        <div class="form-group">
            <label class="sr-only" for="inputEmail">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
        </div>
        <div class="form-group">
            <label class="sr-only" for="inputPassword">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <div class="checkbox">
            <label><input type="checkbox" style="display:none"></label>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <br>

</div>
<h4><dfn>Do not have JustLikeYelp account. Create one.</dfn></h4>
<br/>
<div class="bs-example">
    <form class="form-inline" role="form" action="SignupServlet" method="get" >
        <div class="form-group">
            <label class="sr-only" for="inputEmail">Email</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="Email">
        </div>
        <br/><br/>
         <div class="form-group">
            <label class="sr-only" for="inputEmail">First Name</label>
            <input type="text" class="form-control" name="firstname" id="firstname" placeholder="First Name">
        </div>
        <br/><br/>
         <div class="form-group">
            <label class="sr-only" for="inputEmail">Email</label>
            <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Last Name">
        </div>
        <br/><br/>
         <div class="form-group">
            <label class="sr-only" for="inputEmail">Email</label>
            <input type="text" class="form-control" name="zipcode" id="zipcode" placeholder="Zipcode">
        </div>
        <br/><br/>
        <div class="form-group">
            <label class="sr-only" for="inputPassword">Password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Password">
        </div>
        <br/><br/>

        <button type="submit" class="btn btn-success">Create Account</button>
    </form>
    <br>

</div>

</div>


 </form>


 </body>

</html>
