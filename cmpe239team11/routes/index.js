
/*
 * GET home page.
 */

exports.index = function(req, res){
  res.render('index', { title: 'CMPE 239 Team 11', teaminfo:'Team #11' });
};