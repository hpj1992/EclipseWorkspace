package sorting;

public class prime {

	public static void main(String[] args)
	{
		
	boolean isPrime=new prime().isPrime(123);
	System.out.println(isPrime);
	}
	
	public boolean isPrime(int n)
	{
		if (n <= 3) {
	        return n > 1;
	    } else if (n % 2 == 0 || n % 3 == 0) {
	        return false;
	    } else {
	        double sqrtN = Math.floor(Math.sqrt(n));
	        for (int i = 5; i <= sqrtN; i += 6) {
	            if (n % i == 0 || n % (i + 2) == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
	
}
