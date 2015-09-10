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
    console.log("created");
    this.last = 0;
}

connectionPool.prototype.get = function() {
    var conn = this.freeConnections[this.last];
    //this.freeConnections.splice(this.last,1);
    this.last++;
    console.log(this.last+"length"+this.freeConnections.length);
    if(this.last == this.freeConnections.length) {
        //this.last = 0;
        console.log("in here"+this.last);
    }
    return conn;
};

connectionPool.prototype.release = function(conn) {
	if(this.last!=0)
	{
this.last--;
	}

//this.freeConnections.push(conn);
	

};



function fetchData(callback, sqlQuery) {
    if(sqlQuery.length == 0) {
        console.log("No query specified.");
    } else {
    	var conn=databasePool.get();
    	//console.log(conn);
    	if(typeof conn === "undefined")
    	{
    		console.log("ddddd");
    	databasePool.get();
    	}
    	
    	while(conn==null)
    		{
    		conn=databasePool.get();
    		}
    	conn.query(sqlQuery, function(err, rows, fields){
            if(rows.length!==0){
                //console.log("DATA : "+ rows);
            	 databasePool.release(conn);
                callback(err, rows);
            } else {
                rows = {rows: 0};
                databasePool.release(conn);
                callback(err, rows);
                
            }
        });        
    }
}

var databasePool = new connectionPool(20);
module.exports.fetchData = fetchData;
module.exports.databasePool = databasePool;