
public class PremTopping extends LeafDecorator {
	
	
	int count=0;
	String[] strPremTopping;
	     public PremTopping(String d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

		public double getCost()
	    {
	    	 double cost=0;
	    	 //int count=premToppingsCount;
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
		
		public void AddPremToppings(String[] strPremToppings)
		{
			this.strPremTopping=strPremToppings;
			for(int i=0;i<strPremToppings.length;i++)
			{
				
				count++;
				
			}
		}
		
		public void PrintDesc()
		{
			String str = "";
			for(int i=0;i<strPremTopping.length;i++)
			{
				str=str+strPremTopping[i]+" + ";
			}
			str=str.substring(0, str.length()-2);
			System.out.println("Premium Topping:"+str);
		}

}
