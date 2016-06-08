package hackerrank;

public class Solution2 {

	public static void main(String[] args)
	{
		System.out.println(isPermutation("abc", "acb"));
	}
	 static boolean isPermutation(String a, String b) {
	        if(a == null || b== null || a.length() == 0 || b.length() == 0)
	            {
	            return false;
	        }
	        a =a.toLowerCase();
	        b = b.toLowerCase();
	        
	        char[] arrayA = a.toCharArray();
	        char[] arrayB = b.toCharArray();
	        int[] count = new int[128];
	        for(int i = 0 ; i< arrayA.length;i++)
	            {
	            char ch = arrayA[i];
	            count[ch]++;
	            
	        }
	        for(int i=0;i < arrayB.length ; i++)
	            {
	            char ch = arrayB[i];
	            count[ch]--;
	            if(count[ch] < 0)
	                {
	                return false;
	            }
	        }
	        return true;
	        

	    }


}


