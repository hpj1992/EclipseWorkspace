package Amazon;

/*
 * Given a matrix, find all the min values in the path from the top left to bottom right point, output the max value.
http://yuancrackcode.com/2015/12/12/maximum-minimum-path/
 

 */
public class MaximumMinimumPath {
	public static void main(String[] args)
	{
		int[][] problem = {
						{8, 4, 7},
						{6, 5, 9}
		};
		System.out.println(getMaximumMinimumPathDFS(problem));
		System.out.println(getMaximumMinimumPathDP(problem));
	}

	public static int getMaximumMinumumPath(int[][] matrix) {
		if (matrix == null)
			return 0;
		else {
			int[][] dp = new int[matrix.length][matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					dp[i][j] = matrix[i][j];
					if(isSafe(i, j-1, matrix))
					{
						dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
					}
					if(isSafe(i-1, j, matrix))
					{
						dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
					}
					
				}
			}
			return dp[dp.length-1][dp[0].length-1];
		}
	}

	public static boolean isSafe(int x, int y, int[][] matrix) {
		if ((x >= 0 && x < matrix.length) && (y >= 0 && y < matrix[0].length)) {
			return true;
		}
		return false;
	}
	public static int max = Integer.MIN_VALUE;
	public static int getMaximumMinimumPathDFS(int[][] matrix)
	{
		DFS(matrix,Integer.MAX_VALUE,0,0);
		return max;
	}
	
	public static void DFS(int[][] matrix, int min,int i,int j)
	{
		if(i >= matrix.length || j >= matrix[0].length)
		{
			return;
		}
		int local_min = Math.min(min, matrix[i][j]);
		if( i == (matrix.length -1) && j == (matrix[0].length - 1))
		{
			max = Math.max(max, local_min);
		}
		DFS(matrix,local_min,i+1,j);
		DFS(matrix,local_min,i,j+1);
	}
	
	public static int getMaximumMinimumPathDP(int[][] matrix)
	{
		int[] result = new int[matrix[0].length];
		result[0] = matrix[0][0];
		for(int i=1;i<matrix[0].length;i++)
		{
			result[i] = Math.min(result[i-1], matrix[0][i]);
		}
		for(int i=1;i<matrix.length;i++)
		{
			result[0] = Math.min(result[0], matrix[i][0]);
			for(int j=1;j<matrix[0].length;j++)
			{
				result[j] = (result[j-1] < matrix[i][j] && result[j] < matrix[i][j]) ? Math.max(result[j], result[j-1]) : matrix[i][j];
			}
		}
		return result[result.length - 1];
	}
}
