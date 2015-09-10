
public class SignatureBurgers extends LeafDecorator {

	public double price;
	public SignatureBurgers(String name,double price) {
		super(name,price);
		this.price=price;
		// TODO Auto-generated constructor stub
	}
	
	public double getCost()
	{
		return price;
	}

}
