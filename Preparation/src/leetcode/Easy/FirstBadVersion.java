package leetcode.Easy;
/*
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


 */
public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBadVersion(int n)
	{
		return false;
	}
	public int firstBadVersion(int n) {
	       return getVersion(1,n);
	    }
	    
	    public  int getVersion(int start,int end)
	    {
	       
	        int mid = start + (end-start)/2;
			boolean cur = isBadVersion(mid);
			if(cur)
			{
				//go left
				if(!isBadVersion(mid-1))
				    return mid;
				return getVersion(start,mid);
			}
			else
			{
				boolean nextStatus = isBadVersion(mid+1);
				if(nextStatus)
					return mid+1;
			    return getVersion(mid+1,end);
			}
			
	    }

}
