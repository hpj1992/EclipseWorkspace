package ctci;

import java.util.LinkedList;

import com.sun.corba.se.impl.orbutil.graph.Node;



public class Sol2_1 {
	
	
	
	public static void main(String[] args)
	{
		LinkedList myList=new LinkedList();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		myList.add(6);
		myList.add(7);
		myList.add(8);
		
		System.out.println(myList.toString());
		System.out.println(myList.contains(7));
		
	}

}