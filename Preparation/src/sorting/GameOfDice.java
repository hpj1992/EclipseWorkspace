package sorting;

import java.util.Random;

public class GameOfDice {

	public static void main(String[] args) {
		int p1count=0;
		int p2count=0;
		int[] p1=new int[9];
		int[] p2=new int[9];
		for(int i=0;i<9;i++)
		{
			p1[i]=new Random().nextInt(5)+1;
			p2[i]=new Random().nextInt(5)+1;
			
		}
		//int[] p1= {3,4,5,3,2,3,4,4,5};
		//int[] p2= {2,4,5,1,3,4,2,4,5};
		
		
		for(int i=0;i<9;i++)
		{
			if(p1count==3 || p2count==3)
			{
				break;
			}
			else
			{
				System.out.println("Player1's Move:"+ p1[i]);
				System.out.println("Player2's Move:"+ p2[i]);
				if(p1[i]> p2[i])
				{
					p1count++;
				}
				else if(p2[i]>p1[i])
				{
					p2count++;
				}
				else if(p2[i]==p1[i])
				{
					//System.out.println("Draw");
				}
				else
				{
					//System.out.println();
				}
			}
		}
		if(p1count!=3 && p2count!=3)
		{
			System.out.println("Draw");
		}
		else
		{
			if(p1count==3)
			{
				System.out.println("Winner is Player 1");
			}
			else
			{
				System.out.println("Winner is Player 2");
			}
		}
			
		}
	}


