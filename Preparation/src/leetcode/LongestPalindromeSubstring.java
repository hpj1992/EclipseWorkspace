package leetcode;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String question = "abcba";
		if(question.length()==1)
			System.out.println("Length:1");
		String max = "";
		for(int i=0;i<question.length();i++)
		{
			String s1 = findPalindromeLengthFromThisIndex(i,i, question.length(),question.toCharArray());
			max = s1.length()>max.length()?s1:max;
			String s2 = findPalindromeLengthFromThisIndex(i,i+1, question.length(),question.toCharArray());
			max = s2.length()>max.length()?s2:max;
			
		}
		System.out.println("Longest:"+max);

	}
	
	public static String findPalindromeLengthFromThisIndex(int left,int right,int length,char[] problem)
	{
		
			while(left >=0 && right < length && problem[left] == problem[right] )
			{
				left--;
				right++;
			}
			
			String palindrom = String.valueOf(problem).substring(left+1, right);
			return palindrom;
			
	}
}
