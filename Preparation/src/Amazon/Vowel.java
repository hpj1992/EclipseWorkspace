package Amazon;

public class Vowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Remove all the occurance of vowel from given string.
	
	public static String removeVowels(String str)
	{
		if(str == null || str.length() == 0)
			return "";
		String vowels = "aeiouAEIOU";
		StringBuilder ans = new StringBuilder();
		for(int i=0;i<str.length();i++)
		{
			if(vowels.indexOf(str.charAt(i)) == -1)
				ans.append(str.charAt(i));
		}
		return ans.toString();
	}

}
