
public class Sauce extends Decorator {

	
	 public Sauce(Component c)
	    {
	       super(c);
	       
	    }

	    
	     public double getCost()
	    {
	    	 double cost=0;
	    	 int count=sauceCount;
	 		if(count>1)
	 		{
	 			//0.75 for each extra sauce
	 			cost=super.getCost()+(0.75*(count-1));
	 		}
	 		else
	 		{
	 			cost=super.getCost();
	 		}
	 		return cost;
	 		
	      
	       
	    }
	     
}
