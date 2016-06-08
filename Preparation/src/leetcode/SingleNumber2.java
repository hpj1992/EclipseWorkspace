package leetcode;
/*
 * Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 */
public class SingleNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,2,1,2,1,2,5};
		System.out.println(singleNumber(numbers));
	}

	public static int singleNumber(int[] A) {
		int one = 0, two = 0, removeBit = 0;
		//We will SET one when particular digit is found only once. Once found second time, REST one and SET two for that digit.
		//And when found third time , one and two both will be set. So removeBit is used to remove(RESET) that bit from both one and two.
	    for(int i = 0; i < A.length; i++){
	    	
	    	//When one bit is already set ( means digit is found second time) one & A[i] will yeild SET and  with | OPERATOR two will yield SET in two. 
	    	// When one bit is not set ( means digit is found first time ) one & A[i] will yield RESET and | OPERATOR two will yield RESET.
	    	//When one bit is not set(means digit is found third time) one & A[i] will yield REST but two is SET so with | OPERATOR two will yield SET. 
	    	two = two | ( one & A[i]); 
	    	
	    	//When one bit is already set ( means digit is found second time) one ^ A[i] will reset. 
	    	//When one bit is not set ( means digit is found first time) one ^ A[i] will SET one.
	    	//When one bit is not set ( means digit is found third time) one ^ A[i] will SET one.
	    	one = one ^ A[i];
	    	
	    	//If  digit was found third time, one and two will be SET. So, removeBit will be RESET.So next two steps will RESET the corresponsding bits ine one and two.
	    	//If  digit was foind first time, one will be SET and two will be REST .So removeBut will be SET. So next two steps will SET one and RESET two. Means it will not affect state of one and two before these 3 lines and after 3 lines.
	    	//If digit was foind second time, one will be RESET and two will be SET.So removeBit will be SET.So next two steps will RESET one and SET two.Means it will not affect state of one and two before these 3 lines and after 3 lines.
	    	removeBit = ~(one & two);
	    	one = one & removeBit;
	    	two = two & removeBit;
	    }
	    return one;
	}

}
