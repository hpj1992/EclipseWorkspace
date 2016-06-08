package Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;


public class Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMapTest();
	}

	public static void TreeMapTest()
	{
		TreeMap<Integer,String> map = new TreeMap<Integer,String>();
		map.put(10, "ten");
		map.put(9, "nine");
		map.put(8, "eight");
		map.put(7, "seven");
		map.put(6, "six");
		map.put(5, "five");
		map.put(4, "four");
		Set<Integer> set = map.keySet();
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext())
		{
			System.out.println(map.get(iterator.next()));
		}
	}
}
