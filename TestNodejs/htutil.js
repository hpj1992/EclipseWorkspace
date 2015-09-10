var url = require("url");
exports.loadParams = function(req,res,next)
{
    req.params = url.parse(req.url,true);
    req.a = (req.params.query.a && !isNaN(req.params.query.a)) ? new Number (req.params.query.a) : NaN ;
    req.b = (req.params.query.b && !isNaN(req.params.query.b)) ? new Number (req.params.query.b) : NaN ;
    if (next) next();
}
exports.navbar = function()
{
    return ["<div class='navbar'>",
            "<p><a href='/'>home</a></p>",
            "<p><a href='/mult'>Multiplication</a></p>",
            "<p><a href='/square'>Square</a></p>",
            "<p><a href='/factorial'>Factorial</a></p>",
            "<p><a href='/fibonacci'>Fibonacci</a></p>",
            "</div>"].join("\n");
}
exports.page= function (title, navbar, content)
{
    return ["<html><head><title>{title}</title></head>",
            "<body><h1>{title}</h1>",
            "<table><tr>",
            "<td>{navbar}</td><td>{content}</td>",
            "</tr></table></body></html>"
            ].join("\n2")
            .replace(/{title}/g,title)
            .replace(/{navbar}/g,navbar)
            .replace(/{content}/g,content);
}