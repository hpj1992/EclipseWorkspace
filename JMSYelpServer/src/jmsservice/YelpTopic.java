package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale.Category;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;






import Source.*;
import Connection.Service;

public class YelpTopic implements MessageListener{
	
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;
	Service service=new Service();
	public YelpTopic(){
		try{
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
			properties.put(Context.PROVIDER_URL, "localhost");

			InitialContext jndiContext = new InitialContext(properties);

			ConnectionFactory confactory = (ConnectionFactory)jndiContext.lookup("XAConnectionFactory");
			Topic marketTopic = (Topic)jndiContext.lookup("topic/yelpTopic");

			connection = confactory.createConnection();

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			consumer = session.createConsumer(marketTopic);
			consumer.setMessageListener(this);
			connection.start();

			System.out.println("Waiting for requests..");
		}
		catch(NamingException NE)
		{
			System.out.println("Naming Exception: "+NE);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
			JMSE.printStackTrace();
		}
		
	}

	@Override
	public void onMessage(Message message) {
	
	if (message instanceof ObjectMessage) 
		{
			
			ObjectMessage msg = (ObjectMessage) message;
			Categories[] result;
			try {

				System.out.println("TextMessage rcvd"+msg);
				
				// SignIn
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("getcategories"))
				{
					
					try {
						result = service.getCategories();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendReply(msg,result);
				}
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("getbusinesses"))
				{
					
					try {
						result = service.getBusinesses();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendReply(msg,result);
				}
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("addBusiness"))
				{
					Business b=(Business)msg.getObject();
					try {
						service.addNewBusiness(b.getBizid(),b.getCategoryid(),b.getZipcode(),b.getContact());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendReply(msg,result);
				}
				//addNewCategory
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("addCategories"))
				{
					Category  c=(Category)msg.getObject();
					try {
						service.addNewCategory(c.getCategoryName(),c.getDescription());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendReply(msg,result);
				}
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("editCategory"))
				{
					Category  c=(Category)msg.getObject();
					try {
						result = service.editCategory(c.getCategoryName(),c.getDescription());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendReply(msg,result);
				}
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("deletecategory"))
				{
					Category  c=(Category)msg.getObject();
					try {
						result = service.editCategory(c.getCategoryName(),c.getDescription());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendReply(msg,result);
				}
				
				
			
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		if (message instanceof TextMessage) 
		{
			
						TextMessage TM = (TextMessage)message;
					
					try
					{
						// Get all the ad details
						
					}
					catch(JMSException JMSE)
					{
						System.out.println("JMS Exception: "+JMSE);
					}
		}
		
		
	}

	private void sendReply(Message message,Advertisement listAds[]) throws JMSException {
		MessageProducer MP = session.createProducer(null);
		Destination reply = message.getJMSReplyTo();
		ObjectMessage objMsg = session.createObjectMessage();
		objMsg.setObject(listAds);
		MP.send(reply, objMsg);
		
	}
	
	public static void main(String args[]){
		new YelpTopic();
	}
	

}
