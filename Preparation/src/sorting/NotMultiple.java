package sorting;

import java.util.Scanner;
import java.*;

 class NotMultiple {
	public static void main(String arg[])
	{
Scanner N = new Scanner(System.in);
System.out.println("Enter N");
int leaves=N.nextInt();
int N1= N.nextInt();

int[] arr=new int[N1];
int i=0;
while(N1>0)
{
	int c1=N.nextInt();
	arr[i]=c1;
	i++;
	//System.out.println(c1);
	N1--;
}
for(int j=0;j<arr.length;j++)
System.out.println(arr[j]);
System.out.println("The numbers that are not multiples of 2,3 & 5 are:"+leaves);
int count=0;
for (int j=0;j<leaves;j++)
{
	int temp=0;
	int successCount=0;
	System.out.println("entering"+j);
	while(temp<arr.length)
	{
		if(j%arr[temp]==0)
			break;
		else
			successCount++;
		
		temp++;
	}
	if(successCount==arr.length)
		{
		System.out.println(" success"+j);
		count++;
		}
	
	
	}
	}
}