package sorting;

import java.util.Scanner;

public class square {
	
	
	public static void main(String arg[])
	{
		Scanner N = new Scanner(System.in);
		int N1,N2;
		//System.out.print("Enter the number range between which you want to find the squares:");
		Scanner c = new Scanner(System.in);
		int count = c.nextInt();
		double square;
		int temp=count,k=0;
		
		int[] first=new int[count];
		int[] second=new int[count];
		while(count>0)
		{
		//System.out.print("Enter the number range between which you want to find the squares:");
		first[k]=N.nextInt();
        second[k]=N.nextInt();
        k++;count--;
		}
//double root = Math.sqrt(N2);
		int finalC=0;
for(int i=0;i<temp;i++)
{
	int j=0;
	double temp1=Math.sqrt(first[i]);
	for(j=(int) Math.ceil(temp1);j*j<=(second[i]);j++)
	{
		
		//square=Math.pow(j,2);
		//System.out.println("Square"+ j+"="+square);
		finalC++;
	}
	
	System.out.println("final"+finalC);
	finalC=0;
}


		//count--;
	}
		
	}
