
public class Sauce extends LeafDecorator {

	
	
		
	int count=0;
	String[] strSauce;
	     public Sauce(String d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

		public double getCost()
	    {
	    	 double cost=0;
	    	// int count=sauceCount;
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
		
		public void AddSauceOptions(String[] strSauces)
		{
			this.strSauce=strSauces;
			for(int i=0;i<strSauces.length;i++)
			{
				
				count++;
				
			}
		}
		
		public void PrintDesc()
		{
			String str ="";
			for(int i=0;i<strSauce.length;i++)
			{
				str=str+strSauce[i]+" + ";
			}
			str=str.substring(0, str.length()-2);
			System.out.println("Sauce:"+str);
		}
	     
}
