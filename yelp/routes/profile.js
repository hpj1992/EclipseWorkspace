/**
 * New node file
 */
var ejs = require("ejs");
var mysql = require('./mysql');
var dashboard=require('./dashboard');

var showProfile=exports.showProfile=function(req,res)
{

	var email=req.session.user;
	var lastLogin=req.session.lastLogin;
	
	
	
	
	var getFirstname="select * from users where email='"+email+"'";
	var firstname;
	var date=new Date();
	var time=date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	var updateLastModified="update users set lastmodified='"+time+"' where email='"+req.param("txtEmail")+"';";
	
	
	mysql.fetchData(function(err,results){
		if(err){
			throw err;
		}
		else 
		{
			if(results.length > 0){
				
				var firstname=results[0].firstname;
				var lastname=results[0].lastname;
				var email=results[0].email;
				var zipcode=results[0].zipcode;
				
				var getUserReviews="select b.name,r.ratings,r.comment,b.bizid from business b,reviews r where b.bizid=r.bizid and r.userid=(select userid from users where email='"+email+"');";
				mysql.fetchData(function(err,reviews)
						{
								
									
									dashboard.getLastLoginTime(function(results){
										
										lastLogin=results[0].lastmodified;
										
										var ret = res.render('profile',{email:email,firstname:firstname,lastname:lastname,lastLogin:lastLogin,zipcode:zipcode,reviews:reviews	});
									},req.session.user);
									
									
								
								
								
								
						},getUserReviews);
				
				
				
			}	
		}
				
				
	},getFirstname);

}


var getFirstName=exports.getFirstName=function(callback,emailid)
{
	
var getFirstname="select firstname from users where email='"+emailid+"';";
mysql.fetchData(function(err,results){
	if(err)
		{
		
		}
	else
		{
	
		callback(results);
		}
	
},getFirstname);


}

var getLastLoginTime=exports.getLastLoginTime=function(callback,emailid)
{
	
var getFirstname="select lastmodified from users where email='"+emailid+"';";
mysql.fetchData(function(err,results){
	if(err)
		{
		
		}
	else
		{
	
		callback(results);
		}
	
},getFirstname);


}