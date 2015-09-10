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
 * Servlet implementation class DashboardServlet
 */
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	   private Session session;
	private javax.jms.Queue queue;
	private javax.jms.Topic topic;
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
			 topic  = (Topic) jndiContext.lookup("topic/yelptopic");
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
	
    public DashboardServlet() {
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
					objectMessage.setJMSCorrelationID("getbusinesses");
					objectMessage.setJMSCorrelationID("getcategories");
					MP.send(objectMessage);

					ObjectMessage reply = (ObjectMessage) consumer.receive();
					//String loginStatus = reply.getStringProperty("login");
					
					if(reply!=null)
					{
					// sign up  successful
					Categories[] u=(Categories[])reply;
					request.getSession().setAttribute("categories", u);
					RequestDispatcher reqdis=request.getRequestDispatcher("DashboardServlet");
					request.setAttribute("categoryid", "");
					reqdis.forward(request, response);
					}
					else{
					RequestDispatcher reqdis=request.getRequestDispatcher("home.jsp");
		
					reqdis.forward(request, response);
					}
					
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
