import java.util.ArrayList;


public class Cheese extends Decorator {
	
	 public Cheese(Component c)
	    {
	       super(c);
	       
	    }

	    
	     public double getCost()
	    {
	    	 double cost=0;
	    	 int count=cheeseCount;
	 		if(count>1)
	 		{
	 			//1.00 for each extra cheese
	 			cost=super.getCost()+(1.00*(count-1));
	 		}
	 		else
	 		{
	 			cost=super.getCost();
	 		}
	 		return cost;
	 		
	      
	       
	    }

}
