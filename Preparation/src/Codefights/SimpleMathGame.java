package Codefights;

public class SimpleMathGame {

	public static void main(String[] args)
	{
		
	}
	
	public int[] simpleMathGame(int[] values)
	{
		return null;
	}
	
	public static int getGCD(int a,int b)
	{
		while(a!= 0 && b!=0)
		{
			int c = b;
			b = a/b;
			a = b; 
		}
		return a+b;
	}
}
