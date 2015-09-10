package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ServiceProxy;

/**
 * Servlet implementation class AddBusinessServlet
 */
public class AddBusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBusinessServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strName=(String)request.getParameter("txtBusinessName");
		String strZipcode=(String)request.getParameter("txtZipcode");
		String strContact=(String)request.getParameter("txtContact");
		String strCategoryId=(String)request.getSession().getAttribute("category");
		try
		{
			if(strName.length()>0 && strZipcode.length()>0 && strContact.length()>0)
			{
			ServiceProxy proxy=new ServiceProxy();
			proxy.addNewBusiness(strName, strCategoryId, strZipcode, strContact);
			request.setAttribute("categoryid", strCategoryId);
			}
		}
		catch(Exception e)
		{
			
		}
		
		RequestDispatcher dis=request.getRequestDispatcher("DashboardServlet");
		
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
