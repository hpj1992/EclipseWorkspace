package SourceCodes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DefaultNamespace.CalculatorServiceProxy;
/**
 * Servlet implementation class CalculatorServlet
 */
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String strFirstNumber=request.getParameter("a");
		String strSecondNumber=request.getParameter("b");
		String strOperation=request.getParameter("action");
		//System.out.println(strFirstNumber+strSecondNumber+strOperation);
		CalculatorServiceProxy proxy=new CalculatorServiceProxy();
		float result=proxy.getResult(Integer.parseInt(strFirstNumber), Integer.parseInt(strSecondNumber), strOperation);
		request.setAttribute("result", result);
		//System.out.println(" in servlet"+result);
		
		
		response.setContentType("text/plain");
		response.getWriter().write(Float.toString(result));
		
		//response.sendRedirect(strOperation);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
/*

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
  
   public CalculateServlet() {
       super();
       // TODO Auto-generated constructor stub
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(" in servlet");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
*/