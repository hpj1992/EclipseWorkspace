package Connection;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import Source.Business;
import Source.Review;


public class DatabaseConnection {
	
	Connection con = null;
	static ResultSet rs;
    Statement stmt = null;
    //public static DBPoolManager dbConnectionManager = new DBPoolManager();
	DatabaseConnection() {		
		try {			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sjsuschema","root","root");
				stmt = con.createStatement();
			
		
	}
		catch(InstantiationException e)
		{
			e.printStackTrace();
		}
		catch(IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	}
		
	
	
	public ResultSet signin(String email,String password)
	{
		
		String query = "select * from users where email='"+email+"' and password='"+password+"';";
		ResultSet data=(ResultSet)executeQuery(query, "execute");
		return data;
	
	
	}
	
	public void signup(String email,String password,String firstname,String lastname,String zipcode)
	{
		
		String result = "";
		int rowcount;
		System.out.println("hahaha");
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		String query = "Insert into users (email,password,firstname,lastname,zipcode,lastmodified) values ('" + email + "', '" + password + "','"+firstname+"','"+lastname+"','"+zipcode+"','"+sqlDate.toString()+"')";
		int count=(int)executeQuery(query, "update");
		if(count>0)
		{
			System.out.println("inserted");
		}
		
	}

	public ResultSet getCategories()
	{
		String result = "";
		String query = "select * from category";
		ResultSet data=(ResultSet)executeQuery(query, "execute");
		return data;		
	}

	public ResultSet getBusinesses()
	{
		
		String result = "";
		String query = "select * from business";
		ResultSet data=(ResultSet)executeQuery(query, "execute");
		return data;
		
		
		
	}
	
	public ResultSet getReviewsOfUser(int userid)
	{
		String sql="select *  from reviews where userid="+userid;
		ResultSet data=(ResultSet)executeQuery(sql, "execute");
		return data;
	}
	
	public ResultSet getReviewsOfBusiness(String bizid)
	{
		String query="select * from reviews where bizid="+bizid+"";
		System.out.println(query);
		ResultSet data=(ResultSet)executeQuery(query, "execute");
		return data;
		
		
	}
	
	public ResultSet getUsersOfBusiness(String bizid)
	{
		String sql="select * from users where userid in (select userid from reviews where bizid="+bizid+");";
		System.out.println(sql);
		ResultSet data=(ResultSet)executeQuery(sql, "execute");
		return data;
	}
	
	public ResultSet getBusinessOfUsers(String userid)
	{
		String sql="select name from business where bizid in (select bizid from reviews where userid="+userid+");";
		System.out.println(sql);
		ResultSet data=(ResultSet)executeQuery(sql, "execute");
		return data;
	}
	public void updateLastLoginTime(String strUserid)
	{
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		String sql="update users set lastmodified='"+currentTime+"' where userid='"+strUserid+"'";
		System.out.println(sql);
		executeQuery(sql, "update");
		
	}

	public void AddNewBusiness(Business objBusiness)
	{
		String sql="insert into business(Name,Categoryid,ratings,Zipcode,Contact) values('"+objBusiness.getName()+"','"+objBusiness.getCategoryid()+"','"+objBusiness.getRating()+"','"+objBusiness.getZipcode()+"','"+objBusiness.getContact()+"')";
		System.out.println(sql);
		int data=(int)executeQuery(sql, "update");
	}
	
	public void UpdateReviews(Review r,String strOperation)
	{
		String sql;
		System.out.println("in db");
		if(strOperation.equalsIgnoreCase("Add"))
		{
			sql="insert into reviews(bizid,userid,ratings,comment) values('"+r.getBizid()+"','"+r.getUserid()+"','"+r.getRating()+"','"+r.getComment()+"');";
		}
		else
		{
			sql="update reviews set  ratings='"+r.getRating()+"', comment='"+r.getComment()+"' where userid='"+r.getUserid()+"' and bizid='"+r.getBizid()+"';";	
		}
		
		System.out.println(sql);
		int data=(int)executeQuery(sql, "update");
	}
	
	public void AddNewCategory(String strName,String strDesc)
	{
		String sql="insert into category(categoryname) values('"+strName+"')";
		System.out.println(sql);
		executeQuery(sql, "update");
	}

	public Object executeQuery(String sql,String queryoption)
	{
		
		String result = "";
		ResultSet data = null;
		Object o;
		int rowCount=0;
		
		
		//Connection con=dbConnectionManager.getConnectionFromPool();
		try {
			stmt=con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			if(queryoption.compareToIgnoreCase("execute")==0)
			{
				data=stmt.executeQuery(sql);
			}
			else if(queryoption.compareToIgnoreCase("update")==0)
			{
				rowCount=stmt.executeUpdate(sql);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//dbConnectionManager.returnConnectionToPool(con);
		}
		if(data!=null)
			o=data;
		else
			o=rowCount;
		return o;
		
	}



}
