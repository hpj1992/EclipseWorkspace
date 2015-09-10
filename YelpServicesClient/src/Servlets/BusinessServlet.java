package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Source.Business;
import Source.Review;
import Connection.ServiceProxy;

/**
 * Servlet implementation class BusinessServlet
 */
public class BusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServiceProxy proxy=new ServiceProxy();
		String bizid=(String)request.getParameter("bizid");
		Business[] arBusinesses=(Business[])request.getSession().getAttribute("businesses");
		Review[] arReviews=(Review[])proxy.getReviewsOfBusiness(bizid);
		String[] userNames=proxy.getUSersOfBusiness(bizid);
		ArrayList<Business> lst=new ArrayList<Business>();
		Business biz=new Business();
		for(int i=0;i<arBusinesses.length;i++)
		{
			if(arBusinesses[i].getBizid().equals(bizid))
			{
				biz=arBusinesses[i];
			}
		}
		//System.out.println(arBusinesses.length);
		/*if(biz!=null && userNames!=null)
		{
		System.out.println(biz.getName());
		System.out.println(userNames.length);
		}*/
		request.getSession().setAttribute("businessinfor", biz);
		request.getSession().setAttribute("reviewsofbusiness", arReviews);
		request.getSession().setAttribute("usernames", userNames);
		request.setCharacterEncoding("UTF-8");
		//System.out.println("hahahahah ");
		//return;
		RequestDispatcher dis=request.getRequestDispatcher("business.jsp");
		dis.forward(request, response);
		/*biz -> {
			return arBusinesses[0];
			
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
