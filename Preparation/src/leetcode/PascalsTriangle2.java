package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

	public static void main(String[] args)
	{
		
	}
	
	public static List<Integer> getLastRowOfPascalsTriangle(int num)
	{
		List<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<num;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
			{
				row.set(j, row.get(j)+row.get(i+1));
			}
			
		}
		return row;
	}
}
