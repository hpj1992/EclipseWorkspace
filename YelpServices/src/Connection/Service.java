package Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebService;

import com.sun.org.apache.bcel.internal.generic.LSTORE;
import com.sun.rmi.rmid.ExecOptionPermission;

import Source.Business;
import Source.Categories;
import Source.Review;
import Source.User;

@WebService
public class Service {	
	public static DatabaseConnection db=new DatabaseConnection();
	
	public User signin(String username, String pwd)
	{
		System.out.println("Inside Signin");
		boolean result=false;
		
		/**This space is left for validation and manipulation of 
		input values entered by the user as a part of the server side validation*/
		
		//result = db.signUp(username,pwd);
		ResultSet data = db.signin(username, pwd);
		User u=new User();
		if(data!=null)
		{
			try {
				if(data.next())
				{
				result=true;

				System.out.println(data.getObject("userid").toString());
				u.setEmail(data.getObject("email").toString());
				u.setFirstname(data.getObject("firstname").toString());
				u.setLastname(data.getObject("lastname").toString());
				u.setLastmodified(data.getObject("lastmodified").toString());
				u.setZipcodel(data.getObject("zipcode").toString());
				u.setUserid(data.getObject("userid").toString());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		updateLastLoginTime(u.getUserid());
		return u;//this value is returned to the calling servlet
	}	
	
	public void signup(String email, String password,String firstname,String lastname,String zipcode)
	{
		System.out.println("Inside Signup");
		boolean result;
		
	db.signup(email, password, firstname, lastname, zipcode);
		
	}	
	
	public Categories[] getCategories()
	{
		
		ArrayList<Categories> lstCategories=new ArrayList<Categories>();
		
		
		ArrayList<String> categorynames=new ArrayList<String>();
		ResultSet data=db.getCategories();
		
		
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
	}

	public Business[] getBusinesses()
	{
		
		ArrayList<Business> lstBusinesses=new ArrayList<Business>();
		ResultSet data=db.getBusinesses();
		
		
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
		
	
	}

	public Review[] getReviewsOfUser(String userid)
	{
		String sql="select * from reviews where userid="+Integer.parseInt(userid);
		ResultSet data=db.getReviewsOfUser(new Integer(userid));
		ArrayList<Review> lst=new ArrayList<Review>();
		
		try {
			while(data.next())
			{
				Review r=new Review();
				r.setBizid(data.getObject("bizid").toString());
				r.setComment(data.getObject("comment").toString());
				r.setRating(data.getObject("ratings").toString());
				r.setReviewid(data.getObject("reviewid").toString());
				r.setUserid(data.getObject("userid").toString());
				
				lst.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Review[] arReviews = new Review[lst.size()];
		arReviews=lst.toArray(arReviews);
		System.out.println(arReviews[0].getBizid());
		
		return arReviews;
		
		
	}
	
	public Review[] getReviewsOfBusiness(String bizid)
	{
		ResultSet data=db.getReviewsOfBusiness(bizid);
		ArrayList<Review> lstUsers=new ArrayList<Review>();
		try {
			while(data.next())
			{
				Review r=new Review();
				r.setBizid(data.getObject("bizid").toString());
				r.setComment(data.getObject("comment").toString());
				r.setRating((data.getObject("ratings").toString()));
				r.setReviewid((data.getObject("reviewid").toString()));
				r.setUserid((data.getObject("userid").toString()));
				
				lstUsers.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Review[] arReviews = new Review[lstUsers.size()];
		arReviews=lstUsers.toArray(arReviews);
		
		return arReviews;
	}
	
	public void updateLastLoginTime(String userid)
	{
		db.updateLastLoginTime(userid);
	}
	
	public void updateReviews(String bizid,String userid,String rating,String comment,String strOperation)
	{
		Review r=new Review();
		System.out.println("in service");
		r.setReviewid("0");
		r.setBizid(bizid);
		r.setComment(comment);
		System.out.println("in service3");
		r.setUserid(userid);
		r.setRating(rating);
		System.out.println("in service2"+r.getBizid()+r.getComment());
		db.UpdateReviews(r, strOperation);
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
	public String[] getUSersOfBusiness(String strBizid)
	{
		ResultSet data=(ResultSet)db.getUsersOfBusiness(strBizid);
		ArrayList<String> strUsers=new ArrayList<String>();
		try {
			while(data.next())
			{
				
				//System.out.println("y here");
					strUsers.add((String)data.getObject("firstname").toString());
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object o=null;
		if(strUsers.size()!=0)
		{
		String[] arUsers = new String[strUsers.size()];
		
		arUsers= strUsers.toArray(arUsers);
		o=(String[])arUsers;
		}
		
		//System.out.println(arUsers[0].toString());
		//System.out.println("list size:"+strUsers.size());
		return (String[])o;
	}
	
	public String[] getBusinessOfUsers(String userid)
	{
		ResultSet data=(ResultSet)db.getBusinessOfUsers(userid);
		ArrayList<String> strBusiness=new ArrayList<String>();
		try {
			while(data.next())
			{
				
				
				strBusiness.add((String)data.getObject("name").toString());
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] arBusiness = new String[strBusiness.size()];
		
		arBusiness= strBusiness.toArray(arBusiness);
		System.out.println(arBusiness[0].toString());
		return arBusiness;
	}

	public void addNewCategory(String strCatName,String strDesc)
	{
		db.AddNewCategory(strCatName, strDesc);
	}
	
	public void editCategory(Categories c)
	
	{
		
	//db.editCategory(c.getCategoryId(),c.getCategoryName(),c.getCategoryDescription());
	}
}
