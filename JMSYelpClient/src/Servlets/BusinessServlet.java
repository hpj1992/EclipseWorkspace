package Servlets;

import java.io.IOException;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import Source.Business;
import Source.Categories;
import Source.User;
/**
 * Servlet implementation class BusinessServlet
 */
public class BusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   	   private Session session;
	private javax.jms.Queue queue;
	private javax.jms.Queue replyqueue;
	private MessageConsumer consumer;
	
		public void init() {
		System.out.println("Sign Up Servlet");
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
		properties.put(Context.PROVIDER_URL, "localhost");

		try {
			InitialContext jndiContext = new InitialContext(properties);
			ConnectionFactory confactory = (ConnectionFactory) jndiContext
					.lookup("XAConnectionFactory");
			Topic topic  = (Topic) jndiContext.lookup("topic/yelptopic");
			connection = confactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();
			System.out.println("Connection started");

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	
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
		
		
		String bizid=(String)request.getParameter("bizid");
		Business[] arBusinesses=(Business[])request.getSession().getAttribute("businesses");
		Review[] arReviews=(Business[])request.getSession().getAttribute("reviews");
		String[] userNames=(Business[])request.getSession().getAttribute("usernames");
	
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
