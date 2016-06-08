package leetcode;

public class PowerOfTwo {

	public static void main(String[] args)
	{
		System.out.println(isPowerOfTwo(5));
	}
	
	public static boolean isPowerOfTwo(int n)
	{
		if(n%2!=0)
			return false;
		else
		{
			double i=1;
			int num = 1;
			while(num<n)
			{
				num = num*2;
			}
			return num==n;

		}
	}
	public boolean isPowerOfTwo2(int n) {
        return (n>0&&((n&(n-1))==0));
   }
}
