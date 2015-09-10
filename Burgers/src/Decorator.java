
public class Decorator extends Component {
	
	Component component=null;
	    Decorator(Component c)
	    {
	       this.component = c;
	    }
	    
	    public double getCost()
	     {
	         return component.getCost();
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
