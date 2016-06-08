package Practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//ABCDDDDABCDABCCCCB
//AB*D
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        /*Scanner s = new Scanner(System.in);
        int M = s.nextInt();
        int N = s.nextInt();
        System.out.print(M+ " " + N);*/
        String value = "ABCDDDDABCDABCDCCCB";
        String pattern = "AB*D";
        int j =0;
        int total = 0;
        for(int i=0;i<value.length();i++)
            {
                char ch = value.charAt(i);
                if(j == pattern.length()-1)
                {
                    j = 0;
                    total++;
                }
                char ch2 = pattern.charAt(j);
                if(ch2=='*')
                    {
                	j = j+1;
                    while(value.charAt(i)!=pattern.charAt(j) && i<value.length()-1){
                    	i++;
                    	System.out.println(value.charAt(i));
                    }
                        
                }
                else if(ch2 == ch)
                    {
                    j++;
                }
                
            
        }
        System.out.println("Total : "+total);
        Pattern pattern2 = Pattern.compile("AB([ABCD]*)D");
        String SAMPLE_STRING = "ABCDDDDABCDABCCCCB";
        
        Matcher matcher = pattern2.matcher(SAMPLE_STRING);
        //.find() checks for all occurrances
        int Count = 0;
        //you will see that only 2 are the matchine string
        while (matcher.find()) {
          Count++;
        }
        System.out.println("Number of matching strings : " + Count);
    }
}