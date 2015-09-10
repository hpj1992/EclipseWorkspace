var htutil = require("./htutil");
exports.get=function(req,res)
{
    res.writeHead(200, { 'Content-Type':'text/html' });
    res.end(htutil.page("Square", htutil.navbar(),
                            [
                            (!isNaN(req.a) ?
                                ("<p class='result'>{a} squared = {sq}</p>"
                                .replace("{a}", req.a)
                                .replace("{sq}", req.a * req.a))
                                : ""
                            ),
                            "<p>Enter number to Square</p>",
                            "<form name='square' action='/square' method='get'>",
                            "A: <input type='text' name='a' /><br/>",
                            "<input type='submit' value='Submit' />",
                            "</form>"
                            ].join('\n')
                        )
            );
}