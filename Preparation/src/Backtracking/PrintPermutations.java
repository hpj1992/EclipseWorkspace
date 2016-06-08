package Backtracking;

public class PrintPermutations {

	public static void main(String[] args)
	{
		printPermutationOfString("abc", 0, 2);
	}
	
	public static void printPermutationOfString(String value,int left,int right)
	{
		if(left==right)
			System.out.println(value);
		else
		{
			for(int i=left;i<=right;i++)
			{
				value = swap(i,left,value);
				printPermutationOfString(value,left+1,right);
				value = swap(i,left,value);
			}
		}
	}
	
	public static String swap(int i,int j,String value)
	{
		char[] c = value.toCharArray();

		// Replace with a "swap" function, if desired:
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;

		String swappedString = new String(c);
		return swappedString;
	}
	
	
	
}

