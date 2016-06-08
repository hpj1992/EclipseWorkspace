package Amazon;

public class LongestArithmeticSequence {
//Explaination https://gist.github.com/Linyes/10219849
	
	public static void main(String[] args)
	{
		int[] A = {-1, 1, 3, 3, 3, 2, 1, 0};
		System.out.println(getLAS(A));
	}
	public static int getLAS(int[] array){
	    // Time: O(n)
	    // Space: O(1)
		 if (array == null || array.length < 3)  return 0;
	        int rvalue = 0, gap = array[1] - array[0], length = 2;
	        for (int i = 1; i < array.length - 1; i++) {
	            if (array[i+1] - array[i] == gap)   length++;
	            else {
	                gap = array[i+1] - array[i];
	                if (length >= 3)
	                    rvalue += (length - 1) * (length - 2) / 2;
	                if (rvalue > 1000000000)    return -1;
	                length = 2;
	            }
	        }
	        if (length >= 3)
	            rvalue += (length - 1) * (length - 2) / 2;
	        return rvalue > 1000000000 ? -1 : rvalue;
	}
	
	
}
