import java.util.ArrayList;


public class Composite implements Component {

	
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
    private Component2 decorator;
    
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
	
	
	
	public void setDecorator(Component2 decorator)
	{
		this.decorator=decorator;
	}
	
	
	

	public double getCost(){
		
		return decorator.getCost();
		
	}
}
