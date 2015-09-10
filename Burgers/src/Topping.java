
public class Topping extends Decorator {
	
	 public Topping(Component c)
	    {
	       super(c);
	       
	    }

	    
	     public double getCost()
	    {
	    	 double cost=0;
	    	 int count=toppingsCount;
	 		if(count>4)
	 		{
	 			//0.75 for each extra topping
	 			cost=super.getCost()+(0.75*(count-4));
	 			
	 		}
	 		else
	 		{
	 			cost=super.getCost();
	 		}
	 		return cost;
	 		
	      
	       
	    }

}
