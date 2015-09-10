/**
My implementation . MySQL Connection pool.
 */

function createConnection() {
    var connection;
    var mysql = require('mysql'),
        connection = mysql.createConnection({
        host    : 'localhost',
        user    : 'root',
        password: 'root',
        port    : '3306',
        database: 'sjsuschema'
    });
    connection.connect();
    return connection;
}

function connectionPool(number) {
    var connection;
    this.allConnections = [];
    this.freeConnections = [];
    this.connectionQueue = [];
    for(var i=0; i<number; i++) {
        connection = createConnection();
        this.freeConnections.push(connection);
        this.allConnections.push(connection);
    }
    this.last = 0;
}

connectionPool.prototype.get = function() {
    var conn = this.freeConnections[this.last];
    this.last++;
    if(this.last == this.freeConnections.length) {
        this.last = 0;
    }
    return conn;
};

function fetchData(callback,sqlQuery){
	
	console.log("\nSQL Query::"+sqlQuery);
	
	//var connection=getConnection();
	
	 pool.getConnection(function(err, connection){
		  connection.query(sqlQuery,  function(err, rows){
		  	if(err)	{
		  		throw err;
		  	}else{
		  		console.log( rows );
		  		callback(err, rows);
		  	}
		  });
		  
		  connection.release();
		});
}	


function fetchData(callback, sqlQuery) {
    if(sqlQuery.length == 0) {
        console.log("No query specified.");
    } else {
    	databasePool.get().query(sqlQuery, function(err, rows, fields){
            if(rows.length!==0){
                //console.log("DATA : "+ rows);
                callback(err, rows);
            } else {
                rows = {rows: 0};
                callback(err, rows);
                
            }
        });        
    }
}

var databasePool = new connectionPool(10);
module.exports.fetchData = fetchData;
module.exports.databasePool = databasePool;