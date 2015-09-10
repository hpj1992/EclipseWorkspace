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
 * Servlet implementation class NewCategoryServlet
 */
public class NewCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
	
    public NewCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MessageProducer MP;
				
			MP = session.createProducer(topic);
				ObjectMessage objectMessage = session.createObjectMessage();
					objectMessage.setObject(user);
					replyqueue = session.createTemporaryQueue();
					consumer = session.createConsumer(replyqueue);
					objectMessage.setJMSReplyTo(replyqueue);
					objectMessage.setJMSCorrelationID("addCategories");
					
					MP.send(objectMessage);

					ObjectMessage reply = (ObjectMessage) consumer.receive();
					//String loginStatus = reply.getStringProperty("login");
					
					
		String strName=(String)request.getParameter("categoryName");
		
		String strDesc=(String)request.getParameter("categoryDescription");

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
