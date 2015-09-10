package Connection;

import javax.jws.WebService;

@WebService
public class Service {	
	DatabaseConnection db=new DatabaseConnection();
	
	public String signUp(String username, String pwd)
	{
		System.out.println("Inside Signup");
		String result;
		
		result = db.signUp(username,pwd);
		
		return result;//this value is returned to the calling servlet
	}	
}
