package ctci;

import java.util.Stack;

public class sol3_5_tower_of_hanoi {
	public static void main(String[] args)
	{
	int n=3;
	Tower[] towers=new Tower[3];
	
	for(int i=0;i<3;i++)
	{
		towers[i]=new Tower(i);
	}
	for(int i=n-1;i>=0;i--)
	{
		towers[0].add(i);
	}
	towers[0].Display();
	towers[0].moveDisks(n, towers[2], towers[1]);
	towers[2].Display();
	}
}

class Tower
{
	
	Stack<Integer> disks;
	int index;
	public Tower(int i)
	{
		disks=new Stack<Integer>();
		index=i;
		
		
	}
	
	public void add(int value)
	{
		if(!disks.isEmpty() && disks.peek()<=value)
		{
			System.out.println("Can not insert.Bottom must be greater than top.");
		}
		else
		{
			disks.push(value);
		}
	}
	
	public void moveTopTo(Tower destination)
	{
		int top=disks.pop();
		destination.add(top);
		System.out.println(top+" moved from "+this.index+" to "+destination.index);
		
	}
	
	public void moveDisks(int size,Tower destination,Tower buffer)
	{
		if(size>0)
		{
		moveDisks(size-1, buffer, destination);
		moveTopTo(destination);
		buffer.moveDisks(size-1, destination, this);
		}
		
	}
	
	public void Display()
	{
		System.out.println("Tower "+index);
		System.out.println(disks.toString());
		
	}
	
}
