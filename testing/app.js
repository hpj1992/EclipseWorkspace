
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path'),
  index=require('./routes/index'),
  kanban=require('./routes/kanban'),
  waterfall=require('./routes/waterfall'),
  showProject=require('./routes/showProject');

var app = express();

// all environments
app.set('port', process.env.PORT || 3005);
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));
app.use(function (req, res, next) {

    // Website you wish to allow to connect
    res.setHeader('Access-Control-Allow-Origin', 'http://10.189.177.48:8080');

    // Request methods you wish to allow
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');

    // Request headers you wish to allow
    res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');

    // Set to true if you need the website to include cookies in the requests sent
    // to the API (e.g. in case you use sessions)
    res.setHeader('Access-Control-Allow-Credentials', true);

    // Pass to next layer of middleware
    next();
});
// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

app.get('/scrum', index.getSprintDetails);
app.get('/users', user.list);
app.get('/sprint',routes.getSprintData);
app.get('/kanban',kanban.getCardDara);
app.get('/waterfall',waterfall.getTaskData);

app.post('/scrum/newSprint',routes.newSprint);
app.post('/scrum/updateSprint',routes.updateSprint);

app.post('/kanban/newKanban',kanban.newKanban);
app.post('/kanban/updateKanban',kanban.updateKanban);

app.post('/waterfall/newTask',waterfall.newTask);
app.post('/waterfall/updateTask',waterfall.updateTask);

app.post('/project',showProject.showProject);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
