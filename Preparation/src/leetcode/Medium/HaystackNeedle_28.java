package leetcode.Medium;

public class HaystackNeedle_28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int strStr(String haystack, String needle) {
	        for(int i=0;i<(haystack.length()-needle.length() + 1);i++)
	        {
	            if(haystack.substring(i,i+needle.length()).equals(needle))
	            {
	                return i;
	            }
	        }
	        return -1;
	        
	    }
}
