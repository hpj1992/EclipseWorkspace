package leetcode.Easy;
public class UglyNumber {

	public static boolean isUglyNumber(int n)
	{
		if(n<0)
			return false;
		if(n==1)
			return true;
		
		while(n%2==0)n=n/2;
		while(n%3==0)n=n/3;
		while(n%5==0)n=n/5;
		return n==1;
	}
}
 