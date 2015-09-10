package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Source.Business;
import Source.Categories;
import Source.User;

/**
 * Servlet implementation class AddBusinessServlet
 */
public class AddBusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	  private Session session;
	private javax.jms.Queue queue;
	private javax.jms.Queue replyqueue;
	private MessageConsumer consumer;
	
	public void init() {
		System.out.println("Log in Servlet Initialized..");
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
		properties.put(Context.PROVIDER_URL, "localhost");

		try {
			InitialContext jndiContext = new InitialContext(properties);
			ConnectionFactory confactory = (ConnectionFactory) jndiContext
					.lookup("XAConnectionFactory");
			queue = (Queue) jndiContext.lookup("queue/yelptopic");
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
	
		Business b=new Business();
		b.setName(strName);
		b.setZipcode(strZipcode);
		b.setCategoryId(strCategoryId);
		try
		{
			if(strName.length()>0 && strZipcode.length()>0 && strContact.length()>0)
			{
				
		MessageProducer MP;
				
			MP = session.createProducer(topic);
				ObjectMessage objectMessage = session.createObjectMessage();
					objectMessage.setObject(b);
					replyqueue = session.createTemporaryQueue();
					consumer = session.createConsumer(replyqueue);
					objectMessage.setJMSReplyTo(replyqueue);
					objectMessage.setJMSCorrelationID("addBusiness");
					
					MP.send(objectMessage);

					ObjectMessage reply = (ObjectMessage) consumer.receive();
						RequestDispatcher dis=request.getRequestDispatcher("DashboardServlet");
		
		dis.forward(request, response);
					//String loginStatus = reply.getStringProperty("login");
					
					
		
			//request.setAttribute("categoryid", strCategoryId);
			}
		}
		catch(Exception e)
		{
			
		}
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
