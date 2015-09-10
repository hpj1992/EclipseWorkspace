var ejs = require("ejs");
var mysql = require('./mysql');
var dashboard=require('./dashboard');

var express = require('express');

var app = express();
app.use(express.cookieParser());
app.use(express.session({secret: '1234567890QWERTY'}));

function signin(req,res) {


	res.render("index");
}


function afterSignIn(req,res)
{
	
	
	var getUser="select * from users where email='hpj1992@gmail.com' and password='hpj1992'";
	

	mysql.fetchData(function(err,results){
		if(err){
			throw err;
		}
		else 
		{
			if(results.length > 0){
				console.log("valid Login");
				
				
				//req.session.user = req.param("txtEmail");
				dashboard.user(req,res);
				
		
			}
			else {    
				
				console.log("Invalid Login");
				
			}
		}  
	},getUser);
}

function logout(req,res)
{
	
	req.session.user='';
	signin(req,res);
	
	//res.render('index.ejs');
};

function signup(req,res)
{
	console.log(req.param("txtEmail")+req.param("txtFirstName")+req.param("txtLastName")+req.param("txtZipCode")+req.param("txtPassword"));
	var date=new Date();
	
	var time=date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	var addUser="insert into users(email,password,firstname,lastname,zipcode,lastmodified) values('"+req.param("txtEmail")+"','"+req.param("txtPassword")+"','"+req.param("txtFirstName")+"','"+req.param("txtLastName")+"','"+req.param("txtZipCode")+"','"+time+"');";
	
	mysql.fetchData(function(err,results){
		if(err){
			throw err;
		}
		else 
		{
			
			var email=req.param("txtEmail");
			req.session.user=email;
			
			dashboard.user(req,res);
			
			if(results.length > 0){
				
				//data inserted successfully
			}
			else {    
				
				//may be user is already existing in the system
		
			}
		}  
	},addUser);
}
exports.signin=signin;
exports.afterSignIn=afterSignIn;
exports.logout=logout;
exports.signup=signup;