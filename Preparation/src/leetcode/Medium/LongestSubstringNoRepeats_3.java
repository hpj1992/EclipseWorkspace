package leetcode;

import java.util.HashMap;

class LongestSubstringNoRepeats_3 {
	public static void main(String[] args) {
		System.out
				.println("Length of Longest substring without repeating characters: "
						+ lengthOfLongestSubstring("abcdefghiapoewrd "));
		System.out.println(lengthOfLongestSubstring2("abcdefghiapoewrd "));
	}

	public static int lengthOfLongestSubstring(String s) {
		HashMap<String, Integer> subStrings = new HashMap<String, Integer>();
		String substring = "";
		for (char c : s.toCharArray()) {
			if (substring.contains(String.valueOf(c))) {
				if (!subStrings.containsKey(substring)) 
					subStrings.put(substring, 1);

				substring = substring.substring(substring.lastIndexOf(c)+1,substring.length())+c;
			} else {
				substring += c;
			}
		}
		int length = 0;
		if(substring.length()>0 && !subStrings.containsKey(substring))
		{
			subStrings.put(substring, 1);
		}
		if (subStrings.size() > 0) {
			for (String keys : subStrings.keySet()) {
				if (keys.length() > length)
					length = keys.length();
			}
		}
		else
		{
			length = substring.length();
		}
		return length;
	}

	public static int lengthOfLongestSubstring2(String s)
	{
		if(s==null || s.length() == 0)
			return 0;
		else
		{
			int maxLength = 0;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<s.length();i++)
			{
				char character = s.charAt(i);
				if(sb.indexOf(String.valueOf(character)) >= 0)
				{
					maxLength = (maxLength > sb.length()) ? maxLength : sb.length();
					sb = new StringBuilder(sb.substring(sb.indexOf(String.valueOf(character))+1));
					sb.append(character);
				}
				else
				{
					sb.append(String.valueOf(character));
				}
			}
			maxLength = (maxLength > sb.length()) ? maxLength : sb.length();
			return maxLength;
		}
		
	}
}
