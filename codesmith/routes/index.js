/*
 * GET home page.
 */

var wrench = require("wrench");
exports.index = function(req, res) {
	res.render('index', {
		title : 'Express'
	});
};

exports.pickcards = function(req, res) {
	var imgpath = process.cwd() + "\\public\\img\\cards\\";
	var files = wrench.readdirSyncRecursive(imgpath);
	var shuffledCards = shuffleArray(files);
	var topfive=[];
	for(var i=0;i<5;i++){
		topfive.push(shuffledCards[i]);
	}
	res.render('index',{shuffledCards:topfive,title:"Shuffled Cards"});

};

function shuffleArray(array) {
	for (var i = array.length - 1; i > 0; i--) {
		var j = Math.floor(Math.random() * (i + 1));
		var temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	return array;
}