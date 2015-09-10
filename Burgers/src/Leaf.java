
public class Leaf extends Component {
	
	
	
	 private String description ;
	    private Double price ;

	    public Leaf ( String d, Double p )
	    {
	        description = d ;
	        price = p ;
	    }
	    
	    public Leaf (String d)
	    {
	        description = d ;
	        price = null;
	    }
	    
	    public void PrintDesc()
		{
	    	 if(price!=null)
		        {
		        System.out.println( description + " " + price ) ;
		        }
		         else
		         {
		              System.out.println(description) ;
		         }
		}
	    
	   /* public void printDescription() {
	        DecimalFormat fmt = new DecimalFormat("0.00");
	        if(price!=null)
	        {
	        System.out.println( description + " " + fmt.format(price) ) ;
	        }
	         else
	         {
	              System.out.println(description) ;
	         }
	    }*/

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
	    
	    public double getCost(){return 0.0;}
}
