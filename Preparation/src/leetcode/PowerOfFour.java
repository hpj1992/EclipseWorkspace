package leetcode;

public class PowerOfFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public boolean isPowerOfFour(int num) {
	        return ((num & (num -1)) == 0 && (num & 0x55555555) != 0);
	        //0x55555555 = 0000 0000 0101 0101 0101 0101 0101 0101 0101 0101
	        // its power of 4 if 1 is at MSB and 1 is at odd index. First condition checks 1 is at MSB and second condition checks 1 is at odd index.
	    }
}
