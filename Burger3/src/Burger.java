
public class Burger extends LeafDecorator {
	
	public Burger(String d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	private String strBurgerType,strBurgerSize,strBunOrBowl;
	String[] strBurgerOptions;
	
	
	public double getCost()
	{
		
		double cost=0.0;
		if(strBurgerSize.equalsIgnoreCase("1/3lb"))
        {
            cost=9.50;
        }
        else if(strBurgerSize.equalsIgnoreCase("2/3lb"))
            {
                cost=11.50;
            }
        
        else if(strBurgerSize.equalsIgnoreCase("1lb"))
            {
                cost=15.50;
            }
      if(strBunOrBowl.equalsIgnoreCase("Bowl"))
        {
            cost+=1;
        }
        return cost;

	}
	
	public void PrintDesc()
	{
		System.out.println(strBurgerType+" + "+strBurgerSize+" + "+strBunOrBowl);
	}
	
	public void setBurgerOptions(String[] strBurgerOptions)
	{
		if(strBurgerOptions.length==3)
		{
			this.strBurgerOptions=strBurgerOptions;
		this.strBurgerType=strBurgerOptions[0];
		this.strBurgerSize=strBurgerOptions[1];
		this.strBunOrBowl=strBurgerOptions[2];
		}
		else
		{
			System.out.println("Burger options incorrect.Some options missing");
			System.exit(0);
		}
	}

}
