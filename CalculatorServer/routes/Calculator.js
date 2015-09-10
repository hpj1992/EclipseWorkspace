var url = require("url");

exports.test=function(req,res)
{
	
var querystring=new String(req.url);
var number1=req.param("a");
var number2=req.param("b");
var number3=req.param("action");
var result=getResult(number3,number1, number2);
res.send(result);

};
exports.add = function(req, res)
{
 
  var queryString = new String(req.url);
  
 var number1=req.param("a");
 var number2=req.param("b");
 res.send("ADDITION: "+number1+"+ "+number2+"= "+(parseInt(number1, 10)+parseInt(number2, 10)));

};
exports.sub = function(req, res)
{
 
  var queryString = new String(req.url);
  
 var number1=req.param("a")+req.param("b");
 var number2=req.param("b");
 res.send("SUBSTRACTION: "+number1+" - "+number2+"= "+(parseInt(number1, 10)-parseInt(number2, 10)));

};
exports.mul = function(req, res)
{
 
  var queryString = new String(req.url);
  
 var number1=req.param("a")+req.param("b");
 var number2=req.param("b");
 res.send("MULTIPLICATION: "+number1+"* "+number2+"= "+(parseInt(number1, 10)*parseInt(number2, 10)));

};
exports.div = function(req, res)
{
 
  var queryString = new String(req.url);
  
 var number1=req.param("a")+req.param("b");
 var number2=req.param("b");
 res.send("DIVISION: "+number1+"/ "+number2+"= "+(parseInt(number1, 10)/parseInt(number2, 10)));

};
function getResult(operation, number1, number2)
{
 var result = 0;

 if(operation == "add")
  result ="Addidion:"+ number1 +"+"+ number2+"= "+(parseInt(number1, 10)+parseInt(number2, 10));

 else if(operation == "sub")
	 result ="Substraction:"+ number1 +"-"+ number2+"= "+(parseInt(number1, 10)-parseInt(number2, 10));

 else if(operation == "mul")
	 result ="Multiplication:"+ number1 +"*"+ number2+"= "+parseInt(number1, 10)*parseInt(number2, 10);

 else if(operation == "div")
	 {
	 if(number2==0)
		 {
		 result="Number can not be devided by 0";
		 }
	 else
		 {
	 result ="Division:"+ number1 +"/"+ number2+"= "+parseInt(number1, 10)/parseInt(number2, 10);
		 }
	 }
	 
 else
	 result ="Math Exception";

 return result;
};