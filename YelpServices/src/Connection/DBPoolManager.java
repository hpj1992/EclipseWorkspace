package Connection;

import java.util.*;
import java.sql.*;

class DBPoolManager
{

  
    Vector connectionPool = new Vector();

   

    public DBPoolManager()
    {
       
        initialize();
    }

    private void initialize()
    {
       
        initializeConnectionPool();
    }

    private void initializeConnectionPool()
    {
        while(!checkIfConnectionPoolIsFull())
        {
            System.out.println("NOT FULL.");
            //Adding new connection instance until the pool is full
            connectionPool.addElement(createNewConnectionForPool());
        }
        System.out.println("NO MORE SPACE IN POOL.");
    }

    private synchronized boolean checkIfConnectionPoolIsFull()
    {
        final int MAX_POOL_SIZE = 10;

        //Check if the pool size
        if(connectionPool.size() < 10)
        {
            return false;
        }

        return true;
    }

    //Creating a connection
    private Connection createNewConnectionForPool()
    {
        Connection connection = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
           // connection = DriverManager.getConnection(databaseUrl, userName, password);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sjsuschema","root","root");
            System.out.println("Connection: "+connection);
        }
        catch(SQLException sqle)
        {
            System.err.println("SQLException: "+sqle);
            return null;
        }
        catch(ClassNotFoundException cnfe)
        {
            System.err.println("ClassNotFoundException: "+cnfe);
            return null;
        }

        return connection;
    }

    public synchronized Connection getConnectionFromPool()
    {
        Connection connection = null;

    
        if(connectionPool.size() > 0)
        {
            connection = (Connection) connectionPool.firstElement();
            connectionPool.removeElementAt(0);
        }
     
        return connection;
    }

    public synchronized void returnConnectionToPool(Connection connection)
    {
       
        connectionPool.addElement(connection);
    }

   
}
