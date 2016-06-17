package leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumbers {
	
	public static void main(String[] args)
	{
		List<String> ans = getAllPossibleLetters("23");
		for(int i=0;i<ans.size();i++)
		{
			System.out.println(ans.get(i));
		}
	}
	
	public static List<String> getAllPossibleLetters(String digits)
	{
		String[] setup = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
		ArrayList<String> ans = new ArrayList<String>();
		ans.add("");
		
		
		for( int i = 0; i < digits.length() ; i++)
		{
			int letter = Character.getNumericValue(digits.charAt(i));
			String letters = setup[letter];
			int curLength = ans.size();
					
			while(curLength > 0)
			{
				String value = ans.get(curLength-1);
				for(int j=0;j<letters.length();j++)
				{
					ans.add(value+letters.charAt(j));
				}
				ans.remove(curLength-1);
				curLength--;
			}
		}
		return ans;
	}
	
}
