package sorting;

import java.util.Scanner;
//created two classes gold and silver
class Gold
{
	int m;
	int d; 
	
	public Gold(int i,int j)
	{
		m=i;
		d=j;
	}
}

class Silver
{
	int m;
	int d; 
	public Silver(int i,int j)
	{
		m=i;
		d=j;
	}
}

public class Elements {

	public static void main(String[] str)
	{
		//creating objects of Gold & Silver
		int mass1,dens1,mass2,dens2;
		mass1=Integer.valueOf(str[0]);
		dens1=Integer.valueOf(str[1]);
		mass2=Integer.valueOf(str[2]);
		dens2=Integer.valueOf(str[3]);
		Gold gl=new Gold(mass1,dens1);
		Silver sl=new Silver(mass2,dens2);
		
		Scanner s=new Scanner(System.in);
		//taking user inputs
		System.out.println("Enter property<m,d>:");
		String prop=s.nextLine();
		
		System.out.println("Enter Operation<L,G>:");
		String op=s.nextLine();
		
		System.out.println("Enter value<int>:");
		int val=s.nextInt();
		
		String toDisp="";
		
		//for mass m comparing operators and value
		if(prop.equalsIgnoreCase("m"))
		{
			if(op.equalsIgnoreCase("G"))
			{
						
			    if(sl.m>val&&gl.m>val)
			    	toDisp="Gold & Silver";
				else if(sl.m<val&&gl.m<val)
					toDisp="The mass of the element is more than both Gold & Silver";
				else if(sl.m>val)
					toDisp="Silver";
				else if(gl.m>val)
					toDisp="Gold";
						
			}
			else if(op.equalsIgnoreCase("L"))
			{
				if(sl.m<val&&gl.m<val)
					toDisp="Gold & Silver";
				else if(sl.m>val&&gl.m>val)
					toDisp="The mass of the element is less than both Gold & Silver";
				else if(sl.m<val)
					toDisp="Silver";
				else if(gl.m<val)
					toDisp="Gold";
				
			}
			
				
		}
		//for density d comparing operators and value
		else
		{
			if(op.equalsIgnoreCase("G"))
			{
				if(sl.d>val&&gl.d>val)
					toDisp="Gold & Silver";
				else if(sl.d<val&&gl.d<val)
					toDisp="The density of the element is more than both Gold & Silver";
				else if(sl.d>val)
					toDisp="Silver";
				else if(gl.d>val)
					toDisp="Gold";
			}
			else if(op.equalsIgnoreCase("L"))
			{
				if(sl.d<val&&gl.d<val)
					toDisp="Gold & Silver";
				else if(sl.d>val&&gl.d>val)
					toDisp="The density of the element is less than both Gold & Silver";
				else if(sl.d<val)
					toDisp="Silver";
				else if(gl.d<val)
					toDisp="Gold";
			}
	
		}
		
		System.out.println(toDisp);
	}
}
