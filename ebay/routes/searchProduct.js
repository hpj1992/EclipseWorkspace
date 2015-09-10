var mysql = require('mysql');
var register = require('./mysql');


exports.searchProducts = function(req,res)
{
	var parameter=req.param('searchParam');
	var searchIn = req.param('searchIn');
	parameter = "%"+parameter+"%";
	
	var query;
	
	if(searchIn==0)
		{
	query='Select name,productId,description,price from product where description Like "'+parameter+'" and quantity > 0;';
			
		}
	else
		{
		query='Select seller.sellerId, person.firstName,seller.avgReview from person inner join seller on person.userId=seller.sellerId where person.firstName Like "'+parameter+'" or person.lastName Like "'+parameter+'";';
		}
			register.fetchData(function(err,result)
		{
		if(err)
			{
				console.log(err);
				}
		else
			{
				res.send(result);
			
				}
			},query);
};