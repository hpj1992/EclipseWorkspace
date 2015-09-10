
public class Burger extends Component {
	
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
      if(strBowlOrBun.equalsIgnoreCase("Bowl"))
        {
            cost+=1;
        }
        return cost;
	}
	
	   public void addChild(Component c) {
	        // no implementation
	    }

	    public void removeChild(Component c) {
	        // no implementation
	    }

	    public Component getChild(int i) {
	        // no implementation
	        return null ;
	    }
	    
	    public void PrintDesc()
	    {
	    	
	    }

}
