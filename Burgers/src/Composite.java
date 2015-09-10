import java.util.ArrayList;


public class Composite extends Component {

	/*public static int cheeseCount=0,toppingsCount=0,premToppingsCount=0,sauceCount=0;
	public static String strBurgerSize="",strBowlOrBun="";*/
	public void PrintDesc()
	
	{
		 System.out.println( description );
	        for (Component obj  : components)
	        {
	            obj.PrintDesc();
	        }
	}
	
	private ArrayList<Component> components = new ArrayList<Component>()  ;
    private String description ;
    
    public Composite ( String d )
    {
        description = d ;
        
    }


	public void addChild(Component c) {
        components.add( c ) ;
	}
	 
	public void removeChild(Component c) {
        components.remove(c) ;
	}
	 
	public Component getChild(int i) {
	    return components.get( i ) ;
	}
	
	public void AddCheeseOptions(String[] strCheeses)
	{
		for(int i=0;i<strCheeses.length;i++)
		{
			components.add(new Leaf(strCheeses[i]));
			cheeseCount++;
			
			//intCheeseCount++;
		}
	}
	
	public void AddToppingsOptions(String[] strToppings)
	{
		for(int i=0;i<strToppings.length;i++)
		{
			components.add(new Leaf(strToppings[i]));
			toppingsCount++;
			//intCheeseCount++;
		}
	}
	public void AddPremToppings(String[] strPremToppings)
	{
		for(int i=0;i<strPremToppings.length;i++)
		{
			components.add(new Leaf(strPremToppings[i]));
			premToppingsCount++;
			//intCheeseCount++;
		}
	}
	
	public void AddSauceOptions(String[] strSauces)
	{
		for(int i=0;i<strSauces.length;i++)
		{
			components.add(new Leaf(strSauces[i]));
			sauceCount++;
			//intCheeseCount++;
		}
	}
	
	public void AddBurgerOptions(String strBurger)
	{
		components.add(new Leaf(strBurger));
		
	}
	
	public void AddBurgerSize(String strBurgerSize)
	{
		components.add(new Leaf(strBurgerSize));
		this.strBurgerSize=strBurgerSize;
	}
	
	public void AddBunOrBowlOption(String strBunOrBowl)
	{
		components.add(new Leaf(strBunOrBowl));
		this.strBowlOrBun=strBunOrBowl;
	}
	
	public double getCost(){return 0.0;}
}
