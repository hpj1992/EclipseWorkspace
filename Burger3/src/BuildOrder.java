
public class BuildOrder {
	
	
	
	public void PrintOrder()
	{
		String[] strBurgerOptions={"Beef","1/3lb","Bun"};
		String[] strCheeses={"Danish Blue Cheese","Horseradish Cheddar"};
		String[] strToppings={"Bermuda Red Onion","Black Olives","Carrot Strings","Coleslaw"};
		String[] strPremToppings={"Applewood Smoked Bacon"};
		String[] strSauce={"Appricot Sauce"};
		
		Composite finalOrder=new Composite("Final Order:");
		
		finalOrder.addChild(new Leaf("The purist",8.0)); 
		finalOrder.addChild(new Leaf("Crispy onion srings",5.5));
		Composite custom=new Composite("Custom Burger:");
		
		Burger b=new Burger("Burger");
		b.setBurgerOptions(strBurgerOptions);
		
		Cheese c=new Cheese("Cheese");
		c.AddCheeseOptions(strCheeses);
		c.attachComponenet(b);
		
		Topping t=new Topping("Topping");
		t.AddToppingsOptions(strToppings);
		t.attachComponenet(c);

		PremTopping pt=new PremTopping("Premium Topping");
		pt.AddPremToppings(strPremToppings);
		pt.attachComponenet(t);
		
		Sauce s=new Sauce("Sauce");
		s.AddSauceOptions(strSauce);
		s.attachComponenet(pt);
	
		custom.setDecorator(s);
		custom.addChild(b);
		custom.addChild(c);
		custom.addChild(t);
		custom.addChild(pt);
		custom.addChild(s);
		finalOrder.addChild(custom);
		
		finalOrder.PrintDesc();
		System.out.println("\nCustom Burger Cost:"+custom.getCost());
			
	}

}
