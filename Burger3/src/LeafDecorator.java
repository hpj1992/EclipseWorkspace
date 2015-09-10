
public abstract class LeafDecorator extends Leaf implements Component2 {

	
	Component2 component=null;
	
	public LeafDecorator(String d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	public LeafDecorator(String d,double price) {
		super(d,price);
		// TODO Auto-generated constructor stub
	}

	
    public double getCost()
     {
         return component.getCost();
     }
    
    public void attachComponenet(Component2 c)
    {
    	this.component=c;
    }
  
    

	
}
