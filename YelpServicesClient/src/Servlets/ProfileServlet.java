package Servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ServiceProxy;
import Source.Business;
import Source.Review;
import Source.User;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServiceProxy proxy=new ServiceProxy();
		User user=((User)request.getSession().getAttribute("user"));
		
		Review[] arReviews=(Review[])proxy.getReviewsOfUser(user.getUserid());
		//Review[] arReviews=(Review[])proxy.getReviewsOfUser("2");
		//Business[] arBiz=(Business[])request.getSession().getAttribute("businesses");
		String[] strBizNames=proxy.getBusinessOfUsers(user.getUserid());
		//String[] strBizNames=proxy.getBusinessOfUsers("2");
		request.getSession().setAttribute("businessnames", strBizNames);
		request.getSession().setAttribute("reviews", arReviews);
		//return;
		RequestDispatcher dis=request.getRequestDispatcher("profile.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
