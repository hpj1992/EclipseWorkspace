package leetcode.Medium;

import java.util.regex.Pattern;

public class atoi_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("123"));
	}

	public static int myAtoi(String str) {
        
		 //Check number regex
	       boolean negative = false;
			if(str==null || str.length() == 0 || java.util.regex.Pattern.matches("\\D*",str))
			{
				return 0;
			}
	        if(java.util.regex.Pattern.matches("\\w+\\d+", str))
	        {
	        	return 0;
	        }
	        if(java.util.regex.Pattern.matches("\\d*\\D+\\d*", str) && !java.util.regex.Pattern.matches("[-]{1}\\d+", str))
	        {
	        	str = str.replaceAll("\\D+", "");
	        }
	        if(java.util.regex.Pattern.matches("[-]{1}\\d+", str))
	        {
	            negative = true;
	            str = str.substring(1);
	        }
	        if(str.length() == 0)
	        	return 0;
	        
	        long value = 0;
	        int power = str.length();
	        for(int i=0;i<str.length();i++)
	        {
	            long temp =  (long)Character.getNumericValue(str.charAt(i));
	            value = Math.addExact(value, temp*(long)(Math.pow(10, power-1)));
	            if(value > Integer.MAX_VALUE)
	            {
	                return 0;
	            }
	            else if(value < Integer.MIN_VALUE)
	            {
	                return 0;
	            }
	            power--;
	        }
	        
	        
	        return negative?(0-(int)value):(int)value;
	        
	        
	        
    }
}
