package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Source.Business;
import Source.Categories;
import Source.User;
import Connection.ServiceProxy;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		ServiceProxy proxy=new ServiceProxy();
		User u=(User)proxy.signin(email, password);
		request.getSession().setAttribute("user", u);
	/*	request.setAttribute("firstname", u.getFirstname());
		request.setAttribute("lastmodified", u.getLastmodified());*/
		//System.out.println(isVerified);
		if(u!=null)
		{
			//return;
			RequestDispatcher reqdis=request.getRequestDispatcher("DashboardServlet");
			request.setAttribute("categoryid", "");
			reqdis.forward(request, response);
		}		
		else
		{
			System.out.println(email+password+"hh");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
