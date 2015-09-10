package Connection;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

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
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sjsuschema","root","root");
				stmt = (Statement) con.createStatement();
			
		
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
	

	public void AddNewBusiness(Business objBusiness)
	{
		String sql="insert into business(Name,Categoryid,ratings,Zipcode,Contact) values('"+objBusiness.getName()+"','"+objBusiness.getCategoryid()+"','"+objBusiness.getRating()+"','"+objBusiness.getZipcode()+"','"+objBusiness.getContact()+"')";
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
			stmt=(Statement) con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			if(queryoption.compareToIgnoreCase("execute")==0)
			{
				data=(ResultSet) stmt.executeQuery(sql);
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

	public void editCategory(int id,String name,String description)
	{
		String sql="update category set name='"+name+"' and description='"+description+"' where id="+id;
		System.out.println(sql);
		executeQuery(sql, "update");
	}
	
	public void deleteCategory(int id)
	
	{
	String sql="delete from category where categoryid="+id;
		System.out.println(sql);
		executeQuery(sql, "update");
	}

}
