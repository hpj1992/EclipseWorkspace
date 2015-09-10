
public class EnoughAmountState implements State {
	
	GumballMachine gumballMachine;
	
	public EnoughAmountState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	 public void insertQuarter()
	    {
		 gumballMachine.amount+=25;
		 System.out.println("You inserted Quarter. Total amount"+gumballMachine.amount);
	    	//System.out.println("You can not insert Quarter now ... Gumball Machine is in soldOut state.");
	    }
		public void insertDime()
		{
			gumballMachine.amount+=10;
			System.out.println("You inserted Dime. Total Amount: "+gumballMachine.amount);
			//System.out.println("You can not insert Dime now ... Gumball Machine is in soldOut state.");
		}
		public void insertNickel()
		{
			gumballMachine.amount+=5;
			System.out.println("You inserted Nickel. Total Amount: "+gumballMachine.amount);
			//System.out.println("You can not insert Nikel now ... Gumball Machine is in soldOut state.");
		}
		public void turnCrank()
		{
			System.out.println("Crank Turned....!!!");
			
				while(gumballMachine.amount>=50)
				{
					if(gumballMachine.count>0)
					{
						 gumballMachine.amount -= 50;
						 gumballMachine.count--;
						 gumballMachine.totalGumballsInSlot++;
						
					}
					else
					{
						gumballMachine.setState(new SoldOutState(gumballMachine));
						break;
					}
				
				}
				if(gumballMachine.count>0)
				{
					 gumballMachine.setState(new SoldState(gumballMachine));
					 
				}
			
		}
		public void dispense()
		{
			System.out.println("No gumball to dispense.");
		}
		public void ejectCoins()
		{
			System.out.println("Coins ejected.Collect Your Change : " + this.gumballMachine.amount);
			this.gumballMachine.amount=0;
			gumballMachine.setState(new NotEnoughAmountState(gumballMachine));
			//gumballMachine.totalGumballsInSlot-=1;
			
		}
		
		public String toString()
		{
			return "Enough Amount State.";
		}
  
	/*public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}
 
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}
*/

}
