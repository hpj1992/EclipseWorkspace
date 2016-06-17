package leetcode.Easy;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int countPrimes(int n)
	{
		int i = 1;
		boolean[] arr = new boolean[n];
		int count = 0;
		for(i=2;i<Math.sqrt(n);i++)
		{
			if(!arr[i])
			{
			count++;
			for(int k = 2;k*i < n;k++)
			{
				arr[k*i] = true;
			}
			}
		}
		return count;
	}

}
