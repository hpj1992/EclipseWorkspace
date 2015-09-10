/**
 * Setup the http server 
 * The variable clientCode is the code above and
 * can be set in this file or you could read it in from 
 * a file. See the node.js documentation for 
 * filesystem interaction
 */
var clientCode="<html><head>"+
"<script src=https://127.0.0.1/jquery/jquery.min.js></script> <script src=http://127.0.0.1:1337/nowjs/now.js></script>"
+"<script>now.receiveMessage = function(message) {$('#messages').append('<p>' + message + '</p>');      } $('#send').click( function() {        now.sendMessage($('#message').val());      });"+
"</script>  </head>  <body>    <div id=messages></div><input type=text id=message/>"
    +"<input type=button id=send value=Send></input>"+
  +"</body></html>";
   
var http = require('http');
httpServer = http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  res.end(clientCode);
});
httpServer.listen(1337, "127.0.0.1");
