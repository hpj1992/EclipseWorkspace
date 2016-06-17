package leetcode.Easy;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
        if(x < 0 || (x!=0 && x%10 == 0))
            return false;
        int rev = 0;
        int temp = x;
        while(x > rev)
        {
            int val = x%10;
            rev = val + rev*10;
            x = x/10;
        }
        return x == (rev/10) || x == rev;
        
    }
}
