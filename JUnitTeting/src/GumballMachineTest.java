import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GumballMachineTest {
	
	GumballMachine gumballMachine;


	@Before
	public void setUp() throws Exception {
		gumballMachine=new GumballMachine(5);
	
	}
	
	
	@Test
	public void Test1()
	{
		
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertDime();
		gumballMachine.turnCrank();
		assertEquals("Proper coins are inserted.",true,gumballMachine.isGumballInSlot());
		gumballMachine.takeGumballFromSlot();
		gumballMachine.EjectCoins();
	}
	
	@Test
	public void Test2()
	{
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertDime();
		gumballMachine.turnCrank();
		gumballMachine.takeGumballFromSlot();
		gumballMachine.EjectCoins();
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertDime();
		gumballMachine.turnCrank();
		assertEquals("Proper coins are inserted.",true,gumballMachine.isGumballInSlot());
		
		gumballMachine.EjectCoins();
		
		
	}
	@Test
	public void Test3()
	{
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.EjectCoins();
		gumballMachine.turnCrank();
		assertEquals("Proper coins are inserted.",false,gumballMachine.isGumballInSlot());
		gumballMachine.takeGumballFromSlot();
		
		
	}
	
	@Test
	public void Test4()
	{
		
		gumballMachine.insertDime();
		gumballMachine.turnCrank();
		gumballMachine.insertDime();
		gumballMachine.turnCrank();
		assertEquals("Proper coins are not inserted.",false,gumballMachine.isGumballInSlot());
		gumballMachine.takeGumballFromSlot();
		gumballMachine.EjectCoins();
	}
	
	@Test
	public void Test5()
	{
		gumballMachine.insertDime();
		gumballMachine.insertDime();
		gumballMachine.turnCrank();
		assertEquals("Not enough amount yet.",false,gumballMachine.isGumballInSlot());
		gumballMachine.insertNickel();
		gumballMachine.insertQuarter();
		gumballMachine.insertDime();
		gumballMachine.turnCrank();
		assertEquals("Enough amount now.",true,gumballMachine.isGumballInSlot());
		gumballMachine.takeGumballFromSlot();
		gumballMachine.EjectCoins();
	}
	
	@Test
	public void Test6()
	{
		gumballMachine=new GumballMachine(1);
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();	
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		//gumballMachine.turnCrank();
		assertEquals("Not enough gumballs.",true,gumballMachine.isGumballInSlot());
		gumballMachine.takeGumballFromSlot();
		gumballMachine.EjectCoins();
		
		
	}
	@Test
	public void Test7()
	{
		
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		//gumballMachine.turnCrank();
		assertEquals("All gumballs in one turn crank.",true,gumballMachine.isGumballInSlot());
		gumballMachine.takeGumballFromSlot();
		gumballMachine.EjectCoins();
		
		
	}
	
	

}
