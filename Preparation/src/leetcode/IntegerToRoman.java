package leetcode;

public class IntegerToRoman {

	 public String intToRoman(int num) {
	        if(num == 0)
	            return "";
	        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	        String data[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	        StringBuilder ans = new StringBuilder();
	        for(int i=0;i<value.length;i++)
	        {
	            int devisor = value[i];
	            int base = num/devisor;
	            if(base != 0)
	            {
	                while(base--!=0)ans.append(data[i]);
	                num = num % devisor;
	            }
	        }
	        return ans.toString();
	    
	    
	    }
}
