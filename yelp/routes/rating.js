/**
 * New node file
 */
var mysql=require("./mysql");
var business=require("./business");
var rating=exports.rating=function(req,res)
{
	

var rate=req.param("rating");
var comment=req.param("txtComment");
var email=req.session.user;
var bizid=req.param("bizid");
mysql.fetchData(function(err,results){
	
	if(results.length>0)
		
		{
		var updateReviews="update reviews set ratings="+rate+" , comment='"+comment+"' where bizid="+bizid+" and userid=(select userid from users where email='"+req.session.user+"');"
		mysql.fetchData(function(){},updateReviews);
		}
	else
		{
		
		mysql.fetchData(function(err,results){
			
			if(results.length>0)
				{
				var userid=results[0].userid;
				
				var updateReviews="insert into reviews(bizid,userid,ratings,comment) values("+bizid+","+userid+","+rate+",'"+comment+"');"; //update reviews set ratings="+rate+" , comment='"+comment+"' where bizid="+bizid+" and userid=(select userid from users where email='"+req.session.user+"');"
				mysql.fetchData(function(){},updateReviews);
				}
		},"select userid from users where email='"+req.session.user+"';");
		
		}
	
},"select * from reviews where bizid="+bizid+" and userid=(select userid from users where email='"+req.session.user+"');");








var updateAverageReviews="update business set ratings=(select avg(ratings) from reviews where bizid="+bizid+") where bizid="+bizid+";";
mysql.fetchData(function(){},updateAverageReviews);

mysql.fetchData(function(err,results){
	
	
	business.showBusiness(req,res);
},"select ratings from business where bizid="+bizid);




}
