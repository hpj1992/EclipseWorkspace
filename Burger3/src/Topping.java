
public class Topping extends LeafDecorator {
	
	    int count=0;
	    String[] strToppings;
	     public Topping(String d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

		public double getCost()
	    {
	    	 double cost=0;
	    	 //int count=toppingsCount;
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
		public void AddToppingsOptions(String[] strToppings)
		{
			this.strToppings=strToppings;
			for(int i=0;i<strToppings.length;i++)
			{
				
				count++;
				
			}
		}
		
		public void PrintDesc()
		{
			String str = "";
			for(int i=0;i<strToppings.length;i++)
			{
				str=str+strToppings[i]+" + ";
			}
			str=str.substring(0, str.length()-2);
			System.out.println("Toppings:"+str);
		}

}
