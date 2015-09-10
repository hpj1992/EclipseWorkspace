package Connection;

import java.sql.SQLException;
import java.util.ArrayList;

import Source.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


public class Service {
	DatabaseConnection db = new DatabaseConnection();

	public ResultSet signin(User u) throws SQLException {
		ResultSet result ;
		
		if (u!=null) {
			System.out.println("Inside login");
			result=db.signin(u.getEmail(), u.getPassword());
		} else {
			result = "error";
		}
		return result;
	}
	
	public ResultSet signup(User u) throws SQLException {
		ResultSet result = "";
		
		if (u!=null) {
			System.out.println("Inside login");
			db.signup(u.getEmail(), u.getPassword(),u.getFirstname(),u.getLastname(),u.getZipcode());
		} else {
			result = "error";
		}
		return result;
	}
	
	public Categories[] getCategories() throws SQLException{
	
		ArrayList<Categories> lstCategories=new ArrayList<Categories>();
		
		
		ArrayList<String> categorynames=new ArrayList<String>();
			ResultSet data = "";
		
		if (u!=null) {
			System.out.println("Inside categories");
			data=db.getCategories();
		} else {
			data = "error";
		}
		
		
		int counter=0;
		try {
			while(data.next()){
				categorynames.add((String) data.getObject("categoryname"));
				   Categories c=new Categories();
				c.setCategoryid(data.getObject("categoryid").toString());
				c.setCategoryname(data.getObject("categoryname").toString());
				//System.out.println(c.getCategoryname());
				lstCategories.add(c);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Categories[] arCategories = new Categories[lstCategories.size()];
		arCategories=lstCategories.toArray(arCategories);
		 
		
		//System.out.println(arCategories[2].getCategoryname());
		return arCategories;
		
	
		//return result;
	
	}
	
	public Business[] getBusinesses() throws SQLException{
	
		ResultSet data = "";
		ArrayList<Business> lstBusinesses=new ArrayList<Business>();
			if (u!=null) {
			System.out.println("Inside businesses");
			data=db.getBusinesses();
		} else {
			data = "error";
		}
		
		
		
		int counter=0;
		try {
			while(data.next()){
				//categorynames.add((String) data.getObject("categoryname"));
				Business b=new Business();
				
				b.setCategoryid(data.getObject("categoryid").toString());
				b.setBizid(data.getObject("bizid").toString());
				b.setContact(data.getObject("contact").toString());
				b.setName(data.getObject("name").toString());
				b.setRating(data.getObject("ratings").toString());
				b.setReviewid("");
				b.setZipcode(data.getObject("zipcode").toString());
				//System.out.println(b.getName());
				lstBusinesses.add(b);
			counter++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Business[] arBusinesses = new Business[lstBusinesses.size()];
		arBusinesses=lstBusinesses.toArray(arBusinesses);
		 
		
		return arBusinesses;
		
		
	
	//	return result;
	
	}
	
	public void addNewBusiness(String strName,String strCategoryid,String zipcode,String contact)
	{
		Business b=new Business();
		b.setBizid("");
		b.setCategoryid(strCategoryid);
		b.setContact(contact);
		b.setName(strName);
		b.setRating("0.0");
		b.setReviewid("");
		b.setZipcode(zipcode);
		
		db.AddNewBusiness(b);
	}

	public void addNewCategory(String strCatName)
	{
		db.AddNewCategory(strCatName, strDesc);
	}
	
	public void editCategory(Categories c)
	{
			db.editCategory(c.getCategoryId(),c.getCategoryname());
	}
	
	public void deleteCategory(Category c)
	{
			db.deleteCategory(c.getCategoryId());
	}
	
	
	
	}
