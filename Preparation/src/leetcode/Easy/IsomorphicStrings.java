package leetcode.Easy;

import java.util.HashMap;
import java.util.Vector;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String one = "paper";
		String two = "title";
		System.out.println(isIsomorphic2(one, two));

	}
	
	public boolean isIsomorphic(String s, String t) {
        int[] countArray = new int[512];
		for(int i=0;i<s.length();i++)
		{
			if(countArray[s.charAt(i)] != countArray[t.charAt(i)+256]) return false;
			countArray[s.charAt(i)] = countArray[t.charAt(i)+256] = i+1;
		}
		return true;
    }
	
	static StringBuilder one = new StringBuilder();
	static StringBuilder two = new StringBuilder();
	public static boolean isIsomorphic2(String s,String t)
	{
		if(s.length() == t.length()){
			String pattern1 = getPattern(s,one);
			String pattern2 = getPattern(t,two);
			System.out.println(pattern1);
			System.out.println(pattern2);
			System.out.println(one.toString());
			System.out.println(two.toString());
			if(pattern1.equals(pattern2))
			{
				String sOne = one.toString();
				String sTwo = two.toString();
				HashMap<Character,Character> temp = new HashMap<Character,Character>();
				for(int i=0;i<sOne.length();i++)
				{
					if(temp.containsKey(sOne.charAt(i)))
							{
								if(!((Character)sTwo.charAt(i)).equals(temp.get(sOne.charAt(i))))
										return false;
								
							}
					temp.put(sOne.charAt(i), sTwo.charAt(i));
				}
				return true;
			}
			return false;
		}
		return false;
	}
	
	public static String getPattern(String str,StringBuilder sb)
	{
		if(str != null && str.length() > 0)
		{
			StringBuilder pattern = new StringBuilder();
			char prev = str.charAt(0);
			int count=1;
			for(int i=1;i<str.length();i++)
			{
				if(str.charAt(i) == prev)
				{
					count++;
				}
				else
				{
					sb.append(prev);
					prev = str.charAt(i);
					pattern.append(count);
					count=1;
				}
			}
			pattern.append(count);
			sb.append(prev);
			return pattern.toString();
		}
		return "";
	}

}
