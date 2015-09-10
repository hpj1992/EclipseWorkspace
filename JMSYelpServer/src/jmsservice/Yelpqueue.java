package jmsservice;

import Connection.Service;

import 	javax.jms.*;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import Connection.Service;
import Source.User;
public class Yelpqueue implements MessageListener{
	
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;
	private Service service = new Service();
	
	
	public Yelpqueue(){
		
		try{
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
			properties.put(Context.PROVIDER_URL, "localhost");

			InitialContext jndiContext = new InitialContext(properties);

			ConnectionFactory confactory = (ConnectionFactory)jndiContext.lookup("XAConnectionFactory");
			Queue queue = (Queue)jndiContext.lookup("queue/B");

			connection = confactory.createConnection();

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			consumer = session.createConsumer(queue);
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
		if (message instanceof TextMessage) 
		{
			
			TextMessage msg = (TextMessage) message;
			
			try {

				System.out.println("TextMessage rcvd"+msg);
				
				// SignIn
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("signin"))
				{
					String [] data = msg.getText().split(";;");
					String result = null;
					try {
						result = service.signin(data[0], data[1]);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendreply(message,result);
				}
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("signup"))
				{
					String [] data = msg.getText().split(";;");
					String result = null;
					try {
						result = service.signin(data[0], data[1]);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendreply(message,result);
				}
			
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		if (message instanceof ObjectMessage) 
		{
			
			ObjectMessage msg = (ObjectMessage) message;
			ResultSet result;
			try {

				System.out.println("TextMessage rcvd"+msg);
				
				// SignIn
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("signin"))
				{
					User u=(User)msg.getObject();
					try {
						result = service.signin(u);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendreply(msg,result);
				}
				if((msg.getJMSCorrelationID()).equalsIgnoreCase("signup"))
				{
					User u=(User)msg.getObject();
					try {
						result = service.signup(u);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sendreply(msg,result);
				}
			
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	private void sendreply(Message message, Object data) throws JMSException {
		if(message instanceof TextMessage)
		{
			try 
			{
				MessageProducer MP = session.createProducer(null);
				Destination reply = message.getJMSReplyTo();
					ObjectMessage objectMessage   = (ObjectMessage) session.createTextMessage();
				objectMessage.setObject((Serializable) data);
				((MessageProducer) objectMessage).send(reply, objectMessage);
			}
			catch (JMSException e) 
			{
				e.printStackTrace();
			}
		}
		
			else
			{
				System.out.println("Not Found");
			}
		}
		
	public static void main(String args[]){
		new Yelpqueue();
	}

}
