import java.util.ArrayList;


public class Cheese extends LeafDecorator {
	
	
		int count=0;
	    public String[] strCheeseOptions;
	     public Cheese(String d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

		public double getCost()
	    {
	    	 double cost=0;
	    	 int count=strCheeseOptions.length;
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
		
		public void AddCheeseOptions(String[] strCheeses)
		{
			this.strCheeseOptions=strCheeses;
			
		}
		
		public void PrintDesc()
		{
			String str ="";
			for(int i=0;i<strCheeseOptions.length;i++)
			{
				str=str+strCheeseOptions[i]+" + ";
			}
			str=str.substring(0, str.length()-2);
			System.out.println("Cheese:"+str);
		}
		
		

}
