

public class SoldState implements State {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
     
    public void insertQuarter()
    {
	 gumballMachine.amount+=25;
	 if(gumballMachine.amount>=50)
	 {
		 gumballMachine.setState(new EnoughAmountState(gumballMachine));
	 }
	 System.out.println("You inserted Quarter. Total amount"+gumballMachine.amount);
	 
    }
	public void insertDime()
	{
		
		 gumballMachine.amount+=10;
		 if(gumballMachine.amount>=50)
		 {
			 gumballMachine.setState(new EnoughAmountState(gumballMachine));
		 }
		
		System.out.println("You inserted Dime. Total Amount: "+gumballMachine.amount);
	}
	public void insertNickel()
	{
		 gumballMachine.amount+=5;
		 if(gumballMachine.amount>=50)
		 {
			 gumballMachine.setState(new EnoughAmountState(gumballMachine));
		 }
	
		 System.out.println("You inserted Nickel. Total Amount: "+gumballMachine.amount);
	}
	public void turnCrank()
	{
		System.out.println("Crank already turned ...");
	}
	public void dispense()
	{
		System.out.println("Gumball dispensed2. Please collect your "+ gumballMachine.totalGumballsInSlot	+" Gumball.");
		
		if(gumballMachine.count>0)
		{
		//System.out.println("Gumball dispensed.Please collect your gumball");
		 
			if(gumballMachine.amount<50)
			{
			gumballMachine.setState(new NotEnoughAmountState(gumballMachine));
			}
		}
		
		
		
	}
	public void ejectCoins()
	{
		
		System.out.println("Coins ejected.Collect Your Change : " + this.gumballMachine.amount);
		this.gumballMachine.amount=0;
		gumballMachine.setState(new NotEnoughAmountState(gumballMachine));
		//System.out.println("You can not eject coin now ... Gumball release is in progress.");
	}
	
	public String ToString()
	{
		return "Sold State";
	}

}


