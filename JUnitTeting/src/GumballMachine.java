

public class GumballMachine implements IGumballMachine {
 
	State soldOutState;
	State notEnoughAmountState;
	State enoughAmountState;
	State soldState;
 
	State state = soldOutState;
	int count = 0;
	public int amount=0;
	public int totalGumballsInSlot=0;
	public GumballMachine(int numberGumballs) {
		notEnoughAmountState = new NotEnoughAmountState(this);
		
		
		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = notEnoughAmountState;
		} 
	}
 
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	public void insertDime()
	{
		state.insertDime();
		
	}
	
	public void insertNickel()
	{
		state.insertNickel();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	public boolean isGumballInSlot()
	{
		if(totalGumballsInSlot>0)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public void EjectCoins()
	{
		state.ejectCoins();
	}
	
	
	public void takeGumballFromSlot()
	{
		System.out.println(totalGumballsInSlot+" Gumballs taken from the Slot");
		totalGumballsInSlot=0;
	
	}

	void setState(State state) {
		this.state = state;
	}
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nGUMBALL MACHINE.");
		result.append("\nHARSHITKUMAR JOSHI 009980698");
		result.append("\nTotal Gumballs in Machine: " + count);
		result.append("Machine is in \"" + state + "\" State.\n");
		return result.toString();
	}
}
