

public class SoldOutState implements State {
    GumballMachine gumballMachine;
 
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
    public void insertQuarter()
    {
    	System.out.println("You can not insert Quarter now ... Gumball Machine is in soldOut state.");
    }
	public void insertDime()
	{
		System.out.println("You can not insert Dime now ... Gumball Machine is in soldOut state.");
	}
	public void insertNickel()
	{
		System.out.println("You can not insert Nikel now ... Gumball Machine is in soldOut state.");
	}
	public void turnCrank()
	{
		System.out.println("You can not turn crank now ... Gumball Machine is in soldOut state.");
	}
	public void dispense()
	{
		System.out.println("Gumball dispensed. Please collect your "+ gumballMachine.totalGumballsInSlot	+" Gumball.");
	}
	public void ejectCoins()
	{
		System.out.println("Coins ejected.Collect Your Change : " + this.gumballMachine.amount);
		this.gumballMachine.amount=0;
		gumballMachine.setState(new NotEnoughAmountState(gumballMachine));
	}
	
	public String toString()
	{
		return "sold out";
	}
}
