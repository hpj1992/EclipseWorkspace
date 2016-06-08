package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WindowSum {

	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(14);
		list.add(9);
		list.add(33);
		new WindowSum().getWindowSum(list, 3);
	}
	public List<Integer> getWindowSum(ArrayList<Integer> list,int window)
	{
		
		int prev = 0;
		int sum = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(window > list.size())
			window = list.size();
		
		for(int i=0;i<window;i++)
			sum+=list.get(i);
		
		ans.add(sum);
		prev = list.get(0);
		for(int i=1;i<list.size() - window;i++)
		{
			sum = sum - prev + list.get(i+window-1);
			ans.add(sum);
			prev = list.get(i);
		}
		System.out.println(ans.toString());
		return ans;
	}
}
