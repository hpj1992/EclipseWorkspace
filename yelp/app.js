
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path'),
  index=require('./routes/index'),
  ajax=require('./routes/ajax'),
  business=require('./routes/business'),
  rating=require('./routes/rating'),
  profile=require('./routes/profile'),
  dashboard=require('./routes/dashboard');
  ;

var app = express();

// all environments
app.set('port', process.env.PORT || 3002);
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());

app.use(express.static(path.join(__dirname, 'public')));
app.use("/styles",express.static(__dirname + "/views/styles"));
app.use("/images",express.static(__dirname + "/views/images"));
app.use(express.cookieParser());
app.use(express.session({secret: '1234567890QWERTY'}));
app.use(app.router);

// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}


app.get('/', index.signin);
app.post('/signup', index.signup);
app.post('/afterSignIn', index.afterSignIn);
app.get('/logout',index.logout);
app.get('/business',business.showBusiness);
app.get('/rating',rating.rating);
app.get('/profile',profile.showProfile);
app.get('/dashboard',dashboard.user);
app.get('/addNewBusiness',business.addNewBusiness);
app.get('/addBusiness',business.addBusiness);
http.createServer(app).listen(app.get('port'), function(){
	
  console.log('Express server listening on port ' + app.get('port'));
});
