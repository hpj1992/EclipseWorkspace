    <%@ page language="java" pageEncoding="utf8" contentType="text/html;charset=UTF-8" %>
    <%@page import="Source.*;" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>
    <title>JustLikeYelp</title>
    <meta charset="utf-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/rating.css">
     <link rel="stylesheet" href="styles/rating2.css">
   
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
              <li><a href="DashboardServlet">Dashboard</a></li>
              <li><a href="ProfileServlet">Profile</a></li>  
       
           
            </ul>
            <ul class="nav navbar-nav navbar-right">
            
              <li><p class="navbar-brand">Last Login:<%= user.getLastmodified()%><p></li>
              <li><a href="LogoutServlet">Logout</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>




<br/>
 <div class="row">
  <div class="col-xs-6 col-sm-3">
  <img src="./images/business.jpg" alt="..." class="img-thumbnail">
  </div>
  <div class="col-xs-6 col-sm-3">
  <%
  Business biz=(Business)request.getSession().getAttribute("businessinfor");
Review[] arReview=(Review[])request.getSession().getAttribute("reviewsofbusiness");
String[] usernames=(String[])request.getSession().getAttribute("usernames");
String strREview="0";
String strComment=" ";
double strAverage=0.0;
int total=0;
if(arReview!=null)
{
	Review userReview=null;
	String userid=user.getUserid().toString();
	
	//System.out.println("hi"+arReview[0].getUserid()+"hi"+userid);
	for(int j=0;j<arReview.length;j++)
	{
		total=total+Integer.parseInt(arReview[j].getRating());
		System.out.println("ewview"+arReview[j].getRating());
		if(arReview[j].getUserid().equals(userid))
		{
			userReview=(Review)arReview[j];
			//break;
		}
	}


	if(userReview==null)
	{
		
	}
	else
	{
		System.out.println(userReview.getBizid());
		strREview=userReview.getRating().toString();
		strComment=userReview.getComment();
	}
	System.out.println("total"+total);
	strAverage=(double)((double)total/arReview.length);
	System.out.println("in here jsp"+usernames.length);
	System.out.println(arReview.length);
}

  %>
  <h2><strong> <%=biz.getName()%></strong></h2>
	<h3>Average Ratings:<%=strAverage %></h3>
  <h3>Zipcode:<%=biz.getZipcode()%></h3>
  <h3>Contact:<%=biz.getContact()%></h3>
  
  </div>

  <div class="clearfix visible-xs-block"></div>

  <div class="col-xs-6 col-sm-3">
  <h2>Your Reviews</h2>
  <form action="UpdateReviewServlet?bizid=<%=biz.getBizid() %>"  method="get">
  <input type="text" name="bizid" value=<%=biz.getBizid()%> style="display:none"></input>
 <!--  <form id="ratingsForm" > -->
	<div class="stars" style="margin-left: -0px;margin-bottom: 20px;">
		<input type="radio" name="star" class="star-1" id="star-1" value="1" />
		<label class="star-1" for="star-1">1</label>
		<input type="radio" name="star" class="star-2" id="star-2" value="2" />
		<label class="star-2" for="star-2">2</label>
		<input type="radio" name="star" class="star-3" id="star-3" value="3" />
		<label class="star-3" for="star-3">3</label>
		<input type="radio" name="star" class="star-4" id="star-4" value="4" />
		<label class="star-4" for="star-4">4</label>
		<input type="radio" name="star" class="star-5" id="star-5" value="5" />
		<label class="star-5" for="star-5">5</label>
		<span></span>
	</div>
  
<!-- </form> -->
<!--   <fieldset class="rating">
    
    <input type="radio" id="star5" name="rating" value="5"  /><label for="star5" title="Rocks!">5 stars</label>
    <input type="radio" id="star4" name="rating" value="4"  /><label for="star4" title="Pretty good">4 stars</label>
    <input type="radio" id="star3" name="rating" value="3"  /><label for="star3" title="Meh">3 stars</label>
    <input type="radio" id="star2" name="rating" value="2"  /><label for="star2" title="Kinda bad">2 stars</label>
    <input type="radio" id="star1" name="rating" value="1"  /><label for="star1" title="Sucks big time">1 star</label>
</fieldset> --> 
 <input type="textbox" name="txtComment" id="txtComment"></input>
  
  <br/>
  <br/>

  <input type="submit" name="btnPostComment" value=<%=!strREview.equals("0")?"Update":"Add" %> ></input>
  </form>
  
  
  </div>
  <div class="col-xs-6 col-sm-3">
  <img src="./images/map-icon.png" alt="..." class="img-thumbnail">
  </div>
</div>

<h2> User Reviews:</h2>
<%

System.out.println("in here jsp2");
if(arReview!=null)
{
	//int total=0;
for(int i=0;i<arReview.length;i++)
{
	
%>
<div class="row">
<div class="col-md-4">
<%-- <h4><%=reviews[i].firstname%></h4> --%>
<h4><%=usernames[i] %></h4>
<h4>Rating:<strong><%=arReview[i].getRating()%></strong> <img src="./images/star.png" alt="..." class="img-thumbnail" style="width: 5%;padding: 0px;border: none;border-radius: 0px;"></h4>
<h4 style="font-family: monospace;">Comment:" <%=arReview[i].getComment()%> "</h4>
</div>
</div>
<% }
strAverage=(float)total/arReview.length;
Review userReview=null;
String userid=user.getUserid().toString();
//System.out.println("hi"+arReview[0].getUserid()+"hi"+userid);
for(int j=0;j<arReview.length;j++)
{
	
	if(arReview[j].getUserid().equals(userid))
	{
		userReview=(Review)arReview[j];
		break;
	}
}


if(userReview==null)
{
	
}
else
{
	System.out.println(userReview.getBizid());
	strREview=userReview.getRating().toString();
	strComment=userReview.getComment();
}



}%>
</div>

<%

%>
<%-- <input type="hidden" name="hdn1" id="hdn1" value="<%=strREview%>">
<input type="hidden" name="hdn2" id="hdn2" value="<%=strComment%>"> --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
     <script>
var shirtColor ='star-'+<%=strREview%>;
var comment='<%=strComment%>';
var textboxid='txtComment';
document.getElementById(shirtColor).checked = true;

document.getElementById(textboxid).value =comment;
</script>


  </body>
</html>
