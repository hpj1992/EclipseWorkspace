package leetcode;

public class MaximumProductOfWordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProduct(String[] words) {
		int[] ors = new int[words.length];
		for(int i=0;i<words.length;i++)
		{
			for(char ch:words[i].toCharArray())
			{
				ors[i] |= ch - 'a'; // all characters are in lower case
			}
		}
		int max = 0;
		for(int i=0;i<words.length-1;i++)
		{
			for(int j=i+1;j<words.length;j++)
			{
				if((ors[i] & ors[j]) == 0)
				{
					// If and is ZERO , means no common characters in those 2 strings.
					int product = words[i].length() & words[j].length();
					max = product > max ? product : max;
				}
			}
		}
		return max;
	}
}
