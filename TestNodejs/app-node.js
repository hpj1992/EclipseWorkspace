var http_port = 8124;
var http = require("http");
var htutil =require("./htutil");
var url = require("url");
var server = http.createServer(function(req,res)
                {
                    htutil.loadParams(req,res,undefined);
                    if (req.params.pathname==="/")
                    {
                        require("./home-node").get(req,res);
                    }
                    else if (req.params.pathname==="/square")
                    {
                        require("./square-node").get(req,res);
                    }
                    else if (req.params.pathname === "/factorial")
                    {
                        require("./factorial-node").get(req,res);
                    }
                    else if (req.params.pathname === "/fibonacci")
                    {
                        require("./fibo-node").get(req,res);
                    }
                    else if (req.params.pathname === "/mult")
                    {
                        require("./mult-node").get(req,res);
                    }
                    else
                    {
                        res.writeHead(404,{"Content-Type":"text/plain"});
                        res.end("bad URL " + req.url);
                    }
                });
server.listen(http_port);
console.log("listening to http://localhost:8124");