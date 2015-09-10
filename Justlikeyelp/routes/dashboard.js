/**
 * New node file
 */
var ejs = require("ejs");
var mysql = require('./mysql');

var user=exports.user=function(req,res)
{

	var getFirstname="select * from users where email='"+req.session.user+"'";
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
				
				firstname=results[0].firstname;
				var lastModified=results[0].lastmodified;
				req.session.lastLogin=lastModified;
				mysql.fetchData(function(err,results)
				{
					if(err)
						{
						
						}
					else
						{
						
						
						
						var getCategories="select * from category";
						
						
						
						mysql.fetchData(function(err,results){
							if(err){
								throw err;
							}
							else 
							{
								
								var categoryname="{categoryname: ["
								for(var i=0;i<results.length;i++)
									{
									if(i==(results.length-1))
										categoryname+="'"+results[i].categoryname+"'";
									else
										categoryname+="'"+results[i].categoryname+"',";
									}
								
								/*categoryname.substring(categoryname.lastIndexOf(",", 0), categoryname.lastIndexOf(",", 0)+1);*/
								categoryname+="]}";
								
								
								var getBusinesses="select * from business";
								var category1=[],category2=[],category3=[],category4 = [];
								mysql.fetchData(function(err,businesses){
									if(err){
										throw err;
									}
									else 
									{
										console.log(businesses[0]);
										for(i=0;i<businesses.length;i++)
										{
											if(businesses[i].Categoryid===results[0].categoryid)
											{
											
											category1.push(businesses[i]);
											}
											if(businesses[i].Categoryid===results[1].categoryid)
											{
											
											category2.push(businesses[i]);
											}
											if(businesses[i].Categoryid===results[2].categoryid)
											{
											
											category3.push(businesses[i]);
											}
											if(businesses[i].Categoryid===results[3].categoryid)
											{
											
											category4.push(businesses[i]);
											}
										
										}
										
										req.session.firstname=firstname;
										var ret = res.render('dashboard',{firstname:firstname,lastLogin:lastModified,categoryname:results,arrCategory1:category1,arrCategory2:category2,arrCategory3:category3,arrCategory4:category4});
										/*
										var getUserReviews="select b.name,r.ratings,r.comment,b.bizid from business b,reviews r where b.bizid=r.bizid and r.userid=(select userid from users where email='"+req.session.user+"');";
										mysql.fetchData(function(err,reviews)
												{
													if(reviews.length>0)
														{
															
															console.log("your reviews"+reviews);
														var ret = res.render('dashboard',{firstname:firstname,lastLogin:lastModified,categoryname:results,arrCategory1:category1,arrCategory2:category2,arrCategory3:category3,arrCategory4:category4,reviews:reviews	});
														}
													else
														{
														
														}
														
												},getUserReviews);
										*/
				
									}
								},getBusinesses);
							}

						},getCategories);
						
						}
					
				},updateLastModified);
				
				
				
				
				
				// res.render('dashboard',results[0]);
				 
				 
		
			}
			else {    
				
				
				ejs.renderFile('./views/dashboard.ejs',function(err, result) {
			        // render on success
			        if (!err) {
			            res.end(result);
			        }
			        // render or error
			        else {
			            res.end('An error occurred');
			           
			        }
			    });
			}
		}  
	},getFirstname);

};



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