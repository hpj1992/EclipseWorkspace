package leetcode;

import java.util.ArrayList;

public class ReverseVowelsOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseVowels2("aA"));
	}
	
	public static String reverseVowels(String s)
	{
		//36 ms solution
		if(s!=null && s.length()!=0)
		{
			char[] arr =s.toCharArray();
			ArrayList<Character> vowels = new ArrayList<Character>();
			vowels.add('a');
			vowels.add('e');
			vowels.add('i');
			vowels.add('o');
			vowels.add('u');
			vowels.add('A');
			vowels.add('E');
			vowels.add('I');
			vowels.add('O');
			vowels.add('U');
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			for(int i=0;i<arr.length;i++)
			{
				if(vowels.contains(arr[i]))
				{
					indexes.add(i);
				}
			}
			StringBuilder ans = new StringBuilder();
			int j = indexes.size()-1;
			for(int i=0;i<arr.length;i++)
			{
				if(vowels.contains(arr[i]))
				{
					ans.append(arr[indexes.get(j)]);j--;
				}
				else
				{
					ans.append(arr[i]);
				}
			}
			System.out.println(ans.toString());
			return ans.toString();
		}
		return "";
	}
	
	public static String reverseVowels2(String s)
	{
		// 6 ms
		if(s!=null && s.length() != 0)
		{
			char[] arr = s.toCharArray();
			int first = 0;
			int last = arr.length - 1;
			String vowels = "aeiouAEIOU";
			while(first < last )
			{
				while(first < last && vowels.indexOf(arr[first]) == -1)
					first++;
				
				while(first < last && vowels.indexOf(arr[last]) == -1)
					last--;
				
				char temp = arr[last];
				arr[last] = arr[first];
				arr[first] = temp;
				first++;
				last--;
				
			}
			String temp = new String(arr);
			System.out.println(temp);
			return temp;
		}
		return "";
	}

}
