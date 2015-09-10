
public class NotEnoughAmountState implements State {
	
	GumballMachine gumballMachine;
	public NotEnoughAmountState(GumballMachine gumballMachine)
	{
		this.gumballMachine=gumballMachine;
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
			
			System.out.println("You can not turn crank now ... Insert more money in machine.");
		}
		public void dispense()
		{
			System.out.println("No gumball to dispense.");
		}
		public void ejectCoins()
		{
			System.out.println("Coins ejected.Collect Your Change : " + this.gumballMachine.amount);
			this.gumballMachine.amount=0;
			//gumballMachine.setState(new NotEnoughAmountState(gumballMachine));
		}
		
		public String toString()
		{
			return "Not Enough Amount.";
		}

}
