package leetcode;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] jumps = {2,3,1,1,4};
		System.out.println(getMinJumpCount(jumps));
	} 
	/*
	 * The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. 
	 * Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, as the following:
	 * 
	 * Take the first element and identify the next index it will jump. Dont increment the jump count unless we reach that next index. But update the max reach from any of the in between element.
	 * Once we reach the next index update the next index with max reach. 
	 */
	public static int getMinJumpCount(int[] A)
	{
		int jumps = 0, curEnd = 0, curFarthest = 0;
	    for (int i = 0; i < A.length - 1; i++) {
	        curFarthest = Math.max(curFarthest, i + A[i]);
	        if (i == curEnd) {
	            jumps++;
	            curEnd = curFarthest;
	        }
	    }
	    return jumps;	}

}
