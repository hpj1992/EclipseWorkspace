package sorting;

import java.util.ArrayList;

public class StringPermutation {
	
	public static void main(String[] args)
	{
		ArrayList<String> result=getAll("abcd");
		System.out.println(result.toArray());
		for(int i=0;i<result.size();i++)
		{
			System.out.print(result.get(i)+" ");
		}
	}
	
	public static ArrayList<String> getAll(String str)
	{
		ArrayList<String> result=new ArrayList<String>();
		if(str==null)
			return null;
		else if(str.length()==0)
			result.add("");
		else
		{
			char temp=str.charAt(0);
			ArrayList<String> all=getAll(str.substring(1));
			for (String one : all) {
				
				for(int i=0;i<one.length();i++)
				{
					StringBuilder sb=new StringBuilder(one);
					sb.append(temp);
					result.add(sb.toString());
				}
			}
		}
		return result;
	}

}
