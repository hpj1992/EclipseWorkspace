/**
 * New node file
 */
var ejs=require('ejs');
var mysql = require('./mysql');
var dashboard=require('./dashboard');

function showBusiness(req,res)
{
	
	
	var bizid=req.param("bizid");
	var getBusinessDetails="select * from business where bizid="+bizid;
	

	
	mysql.fetchData(function(err,businessDetails)
			{
		var firstname,lastLogin;
				if(err)
					{
					//no details found;
					}
				else
					{
					
					var firstname;
					dashboard.getFirstName(function(results){
						
							//console.log("callback"+results[0].firstname);
							firstname=results[0].firstname;
							dashboard.getLastLoginTime(function(results){

								lastLogin=results[0].lastmodified;
								console.log(lastLogin);
								/*var dateFormat = require('dateformat');
								var day=dateFormat(lastLogin, "yyyy-mm-dd h:MM:ss");*/
								var getReviews="select r.*,u.firstname from reviews r,users u where r.bizid="+bizid+" and r.userid=u.userid"
								/*var getReviews="select * from reviews where bizid="+bizid;*/
								mysql.fetchData(function(err,reviews)
										
								{
									if(err)
										{
										
										}
									else
										{
										
										var tot=0,average=0;
										
										if(reviews.length>0)
											{
											for(i=0;i<reviews.length;i++)
											{
											tot=tot+reviews[i].ratings;
																					
											}
											average=tot/reviews.length;
											}
										else
											{
											average=0;
											}
										
										
										var getRatingAndComment="select ratings,comment from reviews where bizid="+bizid+" and  userid=(select userid from users where email='"+req.session.user+"');"
										
										mysql.fetchData(function(err,results)
												{
											var comment;
											var rating;
													if(results.length>0)
														{
													
														comment=results[0].comment;
														rating="star"+results[0].ratings;
														}
													else
														{
														comment="";
														rating="";
														}
													
													res.render('business',{star:rating,comment:comment,firstname:firstname,lastLogin:new Date(Date.parse(lastLogin)),businessName:businessDetails[0].Name,averageRating:average,areaZipcode:businessDetails[0].Zipcode,contact:businessDetails[0].Contact,reviews:reviews,bizid:businessDetails[0].bizid});
												},getRatingAndComment);
										}
								},getReviews);
								
								
								
								
								
								
								
								
							},req.session.user);
							
							
						},req.session.user);
				
				}
				
		
			}, getBusinessDetails);
	
		
	
	
	
};

function addNewBusiness(req,res)
{
	var categoryid=req.param("categoryid");
	
	req.session.categoryid=categoryid;
	dashboard.getLastLoginTime(function(results){
		
		lastLogin=results[0].lastmodified;
		
		res.render("newBusiness",{firstname:req.session.firstname,lastLogin:lastLogin});
	},req.session.user);
	
};

function addBusiness(req,res)
{
	var businessname=req.param("txtBusinessName");
	var zipcode=req.param("txtZipcode");
	var contact=req.param("txtContact");
	var categoryid=req.session.categoryid;
	var insertBusiness="insert into business(Name,Categoryid,Reviewid,ratings,Zipcode,Contact) values('"+businessname+"','"+categoryid+"',1,0,"+zipcode+","+contact+");";
	
	
	mysql.fetchData(function(err,results){
		
		req.session.categoryid='';
		
		dashboard.user(req,res);
		
	},insertBusiness);
	
	
	
};


exports.showBusiness=showBusiness;
exports.addNewBusiness=addNewBusiness;
exports.addBusiness=addBusiness;
