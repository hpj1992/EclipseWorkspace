import java.util.ArrayList;
import java.util.Collections;


public class Solution {
	
	public static void main(String[] args)
	{
		int[] problem = {1,3,6,9,-3};
		int[] ans = wiggleArrangeArray(problem);
		for(int i:ans)
			System.out.println(" "+i);
	}

	static int[] wiggleArrangeArray(int[] intArr) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i:intArr)
		{
			list.add(i);
		}
		Collections.sort(list);
		int[] ans = new int[list.size()];
		int length = list.size();
		int j=0;
		for(int i=0;i<list.size();)
		{
			ans[i] = list.get(length - 1-j);
			if(i+1<list.size())
			{
				ans[i+1] = list.get(j);
				j++;
			}
			i +=2;
			
		}
		return ans;

    }
}
