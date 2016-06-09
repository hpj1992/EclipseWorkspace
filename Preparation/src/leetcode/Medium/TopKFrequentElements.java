package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<Integer> getTopKElements(int[] arr,int k)
	{
		HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
		for(int i:arr)
		{
			freq.put(i, freq.getOrDefault(i, 0) + 1);
		}
		List<Integer>[] list = new ArrayList[arr.length+1];
		for(int i:freq.keySet())
		{
		    if(list[freq.get(i)] == null)
		        list[freq.get(i)] = new ArrayList<>();
			list[freq.get(i)].add(i);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=list.length-1;i>=0&&ans.size() < k;i--)
		{
		    if(list[i] != null)
			ans.addAll(list[i]);
		}
		return ans;
	}
}

class WrapperClass implements Comparable
{
	int value;
	
	public WrapperClass(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
	WrapperClass w = (WrapperClass)o;
		return this.value > w.value ? 1 : 0;
	}
	
}
