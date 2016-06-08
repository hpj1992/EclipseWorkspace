package Practice;

import java.util.Date;
import java.util.HashMap;

//Design Vending 
public class AmazonRutvik_2 {

}



class VendingMachine
{
	HashMap<String,Product> products = new HashMap<String,Product>();
	private int amountLoaded;
	private String paymentMethod;
	Payment p = null;
	public void dispatch(String itemCode)
	{
		if(products.containsKey(itemCode))
		{
			Product p = products.get(itemCode);
			
			if(amountLoaded < p.price)
			{
				System.out.println("Add more money to dispatch " + p.name);
			}
			else
			{
				
			}
		}
		else
		{
			System.out.println("Error. No such item code exists. Enter again");
		}
	}
}

class Product
{
	String name;
	int price;
	int availableQuantity;
	
	public boolean isEmpty()
	{
		return false;
	}
	
	public void dispatchOneItem()
	{
		
	}
}

abstract class Payment
{
	
	abstract public void processPayment(Product p);
	public void printReceipt()
	  {
		System.out.println("Payment is received at "+(new Date()).toString());
	  }
	
}

class CashPayment extends Payment
{
	
	int moneyLoaded;

	@Override
	public void processPayment(Product p) {
		// TODO Auto-generated method stub
		if(getLoadedMoneyInMachine() < p.price)
			System.out.println("Add enough money");
		else
		{
			//Compute change
			//REturn change amount
		}
		
	}

	
	public int getLoadedMoneyInMachine()
	{
		return 0;
	}
	
	
	
}


class cardPayment extends Payment
{

	@Override
	public void processPayment(Product p) {
		// TODO Auto-generated method stub
		authenticateCardDetails();
		
	}
	
	public void authenticateCardDetails()
	{
		
	}

	
}

