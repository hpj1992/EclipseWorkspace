package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Source.User;
import Connection.ServiceProxy;

/**
 * Servlet implementation class UpdateReviewServlet
 */
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strBizid=(String) request.getParameter("bizid");
		String strRating=(String) request.getParameter("star");
		String strComment=(String) request.getParameter("txtComment");
		String srOperation=(String)request.getParameter("btnPostComment");
		User u=(User)request.getSession().getAttribute("user");
		String strUserid=u.getUserid();
		ServiceProxy proxy=new ServiceProxy();
		proxy.updateReviews(strBizid, strUserid, strRating, strComment, srOperation);
		//return;
		RequestDispatcher dis=request.getRequestDispatcher("BusinessServlet?bizid="+strBizid);
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
