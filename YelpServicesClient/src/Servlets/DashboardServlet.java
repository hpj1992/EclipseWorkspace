package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ServiceProxy;
import Source.Business;
import Source.Categories;

/**
 * Servlet implementation class DashboardServlet
 */
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServiceProxy proxy=new ServiceProxy();
		Categories[] arCategories=proxy.getCategories();
		Business[] arBusinesses = proxy.getBusinesses();
		
	String strCategoryid=(String) request.getAttribute("categoryid");
		
	/*	if(request.getSession().getAttribute("categories")==null)
		{
			arCategories=proxy.getCategories();
			request.getSession().setAttribute("categories", arCategories);
		}
		else
		{
			arCategories=(Categories[]) request.getSession().getAttribute("categories");
		}
		if(request.getSession().getAttribute("businesses")==null)
		{
			arBusinesses=proxy.getBusinesses();
			request.getSession().setAttribute("businesses", arBusinesses);			
		}
		else
		{
			arBusinesses=(Business[]) request.getSession().getAttribute("businesses");
		}
		*/
	
		request.getSession().setAttribute("businesses", arBusinesses);
		request.getSession().setAttribute("categories", arCategories);
		try
		{
			if(strCategoryid!=null && strCategoryid.length()>0)
			{
				String value="";
				for(int i=0;i<arCategories.length;i++)
				{
					if(arCategories[i].getCategoryid().equals(strCategoryid))
					{
						value=arCategories[i].getCategoryname();
						break;
					}
				}
				System.out.println("category"+value);
				request.setAttribute("categoryofnewbusiness", value);
			}
		}
		catch(Exception e)
		{
			
		}
		
		System.out.println(arBusinesses.length+" "+arCategories.length);
		//return;
		RequestDispatcher reqdis=request.getRequestDispatcher("dashboard.jsp");
		
		reqdis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
