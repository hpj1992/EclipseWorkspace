package ctci;

import java.util.LinkedList;

public class sol3_7 {

	public static void main(String[] args)
	{
		LinkedList<Node> animals=new LinkedList<Node>();
		animals.add(new Node("dog"));
		//animals.poll();
	}
}

class Node
{
	String type; // dog or cat
	
	public Node(String type)
	{
		this.type=type;
	}
}