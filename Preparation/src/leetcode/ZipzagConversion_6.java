package leetcode;

public class ZipzagConversion_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Converted:"+convert("ABC", 2));
	}

	public static String convert(String question, int numRows)
	{
		char[] letters = question.toCharArray();
		String ans = "";
		for(int i=0;i<numRows;i++)
		{
			if(i == numRows/2)
			{
				int temp = i;
				int next = temp;
				int gap = numRows/2;
				while(next<question.length())
				{
					ans += question.charAt(next);
					next = next + gap + 1;
				}
			}
			else
			{
				int temp = i;
				int next = temp;
				while(next<question.length())
				{
					ans += question.charAt(next);
					next = next + numRows + 1;
				}
			}
		}
		return ans;
	}
}
