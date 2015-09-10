
public class BuildOrder {
	
	
	
	public void PrintOrder()
	{
		String[] strCheeses={"Danish Blue Cheese","Horseradish Cheddar"};
		String[] strToppings={"Bermuda Red Onion","Black Olives","Carrot Strings","Coleslaw"};
		String[] strPremToppings={"Applewood Smoked Bacon"};
		String[] strSauce={"Appricot Sauce"};
		Component order=new Composite("Order");
		order.addChild(new Leaf("For the purist",8.0)); 
		order.addChild(new Leaf(" For crispy onion rings",5.5));
		Composite custom=new Composite("Custom Burger:");
			custom.AddBurgerOptions("Beef");
			custom.AddBurgerSize("1/3lb");
			custom.AddBunOrBowlOption("Bun");
			custom.AddCheeseOptions(strCheeses);
			custom.AddToppingsOptions(strToppings);
			custom.AddPremToppings(strPremToppings);
			custom.AddSauceOptions(strSauce);
			
		order.addChild(custom);
		Component obj = new Sauce(new Topping(new PremTopping(new Cheese(new Burger()))));    
        double result = obj.getCost() ;
        order.addChild(new Leaf("Custom:", result));
		order.PrintDesc();
		
		//return order;
	}

}
