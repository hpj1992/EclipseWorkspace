
/*
 * GET users listing.
 */
var mysql=require('./mysql');
exports.list = function(req, res){
	res.send("respond with a resource");
};

exports.getUserInfo = function(req,res){	


	var userId = req.userId;

	userId = 1;

	getReviews(function(error,reviews){
		if(error){
			console.log("error occured while posting seller review");
			throw error;
			res.send({result : "false"});
		}
		else {	
			console.log("from my results");
			console.log(reviews.reviews);

			var reviewCount = reviews.reviews.length;

			var latestFive = [] ;
			var i = 0;
			while (i < 5 && i < reviews.reviews.length)
			{

				
				latestFive[i] = (reviews.reviews[i]);
				i++;


			}		

			res.render("userdetails", {reviews : reviews.reviews , sellerId : userId , reviewCount : reviewCount , latestReviews : latestFive});
		}
	},userId);	
}


exports.refreshReviews = function(req,res)
{

	var userId = req.userId;

	userId = 1;

	console.log("user id from the request" + userId);

	getReviews(function(error,reviews){
		if(error){
			console.log("error occured while posting seller review");
			throw error;
			res.send({result : "false"});
		}
		else {	
			console.log(reviews.reviews);
			var latestFive = [] ;
			var i = 0;
			console.log(reviews.reviews.length);
			while (i < 5 && i < reviews.reviews.length)
			{				
				
				latestFive[i] = (reviews.reviews[i]);
				i++;
			}	
			console.log(latestFive);
			res.send({results : "true" , reviews : reviews.reviews , latestReviews : latestFive});
		}
	},userId);	


}


function getReviews (callback,sellerId)
{

	var getReviews = "SELECT s.text,s.rating,s.modifiedDate,s.reviewedBy,p.firstName as userName FROM ebay.sellerreview s " +
	"INNER JOIN ebay.customer c   ON s.reviewedBy = c.customerId INNER JOIN" +
	" ebay.person p ON c.personId = p.userId where s.reviewedFor = '"+sellerId+"' ORDER BY Date(s.modifiedDate) desc,Time(s.modifiedDate) desc";

	mysql.fetchData(function(err2,reviews){
		if(err2){
			console.log("error occured while posting seller review");
			throw err2;
			callback(err2); 
		}
		else {	

			callback( err2 , {reviews : reviews});
		}
	},getReviews);
}



exports.postSellerReview = function(req,res){

	var sellerId = req.body.sellerId;
	var review = req.body.review;
	var rating  = req.body.rating;
	//var user = req.session.loggedInUser;

	Number.prototype.padLeft = function(base,chr)
	{
		var  len = (String(base || 10).length - String(this).length)+1;
		return len > 0? new Array(len).join(chr || '0')+this : this;
	}
	var d = new Date();

	var dformat = [d.getFullYear(),(d.getMonth()+1).padLeft(),
	               d.getDate().padLeft()
	               ].join('/') +' ' +
	               [d.getHours().padLeft(),
	                d.getMinutes().padLeft(),
	                d.getSeconds().padLeft()].join(':');


	var reviewedDate = dformat;
	var modifiedDate = dformat;

	var userId = 2;


	//Order by user
	// take those order ids and check that user took any thing from seller?


	var ifReviewed = "SELECT * FROM `sellerreview` WHERE reviewedBy= '"+userId+"' and reviewedFor =  '"+sellerId+"'";



	mysql.fetchData(function(error,results){

		if(error)
		{
			console.log("error occured while posting seller review");
			throw error;
			res.send({result : "false"});
		}
		else
		{				

			if(results.length == 0)
			{

				var checkPurchase = "SELECT o.orderId,o.soldBy,p.datePlaced,p.orderedBy" +
				" FROM ebay.orderitem o  INNER JOIN ebay.order p " +
				" ON o.orderId = p.orderId where p.orderedBy = '"+userId+"' and o.soldBy='"+sellerId+"'";


				mysql.fetchData(function(error,results){

					if(error)
					{
						console.log("error occured while posting seller review");
						throw error;
						res.send({result : "false"});
					}
					else
					{				

						if(results.length > 0)
						{

							var postReviewQuery = "INSERT INTO sellerreview (text,rating,reviewedBy,reviewedFor,reviewedDate, modifiedDate) VALUES ('"+review+"','"+ rating+"','"+userId+"','"+ sellerId+"', '"+reviewedDate +"','"+modifiedDate +"')";


							mysql.fetchData(function(err2,result1){
								if(err2){
									console.log("error occured while posting seller review");
									throw error;
									res.send({result : "false"});
								}
								else {	

									res.send({result : "true"})

								}
							},postReviewQuery);	

						}
						else
						{
							res.send({result : "false" , message : "You did not purchase anything from this seller!!"});
						}
					}
				},checkPurchase);	
			}
			else
			{
				res.send({result : "false" , message : "You have already posted review for this seller!!"});
			}
		}
	},ifReviewed);
}