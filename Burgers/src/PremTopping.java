
public class PremTopping extends Decorator {
	
	 public PremTopping(Component c)
	    {
	       super(c);
	       
	    }

	    
	     public double getCost()
	    {
	    	 double cost=0;
	    	 int count=premToppingsCount;
	 		if(count>0)
	 		{
	 			//1.00 for each extra cheese
	 			cost=super.getCost()+(1.50*(count));
	 		}
	 		else
	 		{
	 			cost=super.getCost();
	 		}
	 		return cost;
	 		
	      
	       
	    }

}
