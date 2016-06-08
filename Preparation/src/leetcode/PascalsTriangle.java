package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		generate2(5);
	}

	public static List<List<Integer>> generate(int nums) {
		if (nums == 0 )
			return new ArrayList<List<Integer>>();
		else {
			List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
			List<Integer> intermediate = new ArrayList<Integer>();
			for (int i = 0; i < nums; i++) {
				intermediate = new ArrayList<Integer>();
				intermediate.add(0, 1);
				int temp = 1;
				List<Integer> previous = null;
				if(i>0)
				{
					previous = finalAns.get(i-1);
				}
				
				while(temp<i)
				{
					intermediate.add(temp, previous.get(temp-1) + previous.get(temp));
					temp++;
				}
				if(i>0)
					intermediate.add(i, 1);
				finalAns.add(intermediate);
			}
			System.out.println(finalAns);
			return finalAns;
		}
	}
	
	public static List<List<Integer>> generate2(int numRows)
	{
		//Better approach
	    List<List<Integer>> allrows = new ArrayList<List<Integer>>();
	    ArrayList<Integer> row = new ArrayList<Integer>();
	    for(int i=0;i<numRows;i++)
	    {
	        row.add(0, 1);
	        for(int j=1;j<row.size()-1;j++)
	            row.set(j, row.get(j)+row.get(j+1));
	        allrows.add(new ArrayList<Integer>(row));
	    }
	    return allrows;

	}
}
