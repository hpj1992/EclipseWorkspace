package sorting;

import java.util.Random;
import java.util.Scanner;


public class GuessTheNumber {

	public static void main(String[] args) {
		int size=(int)(new Random().nextInt(6)+5);
		System.out.println(size);
		int[] sec = new int[size];
		for(int i=0;i<size;i++)
		{
			sec[i]=new Random().nextInt(5)+1;
		
			
		}
/*		int number=(int) ((int)(new Random().nextInt()*Math.pow(10, size))	);
		char[] temp=Integer.toString(number).toChar1Array();
		System.out.println(number+ " "+temp.length);
		//int[] sec=new int[temp.length];
		String temp2 = Integer.toString(number);
		int[] sec = new int[temp2.length()];
		for (int i = 0; i < temp2.length(); i++)
		{
			sec[i] = temp2.charAt(i) - '0';
		}
		for(int i=0; i<sec.length;i++)
		{
			System.out.print(sec[i]);
			
		}*/
		int[] guess=new int[sec.length];
		for(int i=0; i<guess.length;i++)
		{
			guess[i]=0;
			
		}
		System.out.println("You are allowed only 3 incorrect guesses ");
		for(int i=0; i<guess.length;i++)
		{
			System.out.print(guess[i]);
			
		}
		
		
		int errC=0;
		 while(errC < 3 && !compare(sec,guess))
		 {
			 Scanner s= new Scanner(System.in);
			 System.out.println();
			 System.out.println("Next Guess:");
				
			 int input= s.nextInt();
			 
			boolean found=false;
			 for(int i=0; i< sec.length; i++)
			 {
				 if(input == sec[i])
				 {
					 guess[i] = input;
					 found=true;
				 }
				 else
				 {
					// errC++;
				 }
			
			 }
			 if(!found)
				 errC++;
			 for(int j=0; j<guess.length;j++)
				{
					System.out.print(guess[j]);
					
				}
		 }
		 if(errC>=3)
		 {
			 System.out.println();
			 System.out.println("You Lost :(");
			
			System.out.print("The secret number was:");
					
				
			 for(int i=0; i<sec.length;i++)
				{
					System.out.print(sec[i]);
					
				}
		 }
		 else
		 {
			 System.out.println();
	
			 System.out.println("You Win :)");
		 }
		

	}

	public static boolean compare(int[] arr,int[] arr2)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=arr2[i])
				return false;
			
		}
		return true;
	}
}
