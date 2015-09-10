/**
 * New node file
 */
home=require('./home');

exports.logout=function(req,res)
{
	
req.session.email='';
req.session.firstname='';
home.home(req,res);


}