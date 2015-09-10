var htutil = require('./htutil');
exports.get = function(req,res)
{
    res.writeHead(200, { 'Content-Type':'text/html'});
    res.end(htutil.page("Math App", htutil.navbar(), "<p>Math App</p>"));
}