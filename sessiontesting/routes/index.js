
exports.index = function(req, res){
	req.session.name='harshit';
	console.log(req.session.name);
  res.render('index', { title: 'Express' });
};