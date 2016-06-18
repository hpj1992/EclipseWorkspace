package leetcode.Easy;

import java.util.Arrays;

public class ValidAnagram
{
  public boolean isAnagram(String s, String t) {
        int[] count1 = new int[128];
        int[] count2 = new int[128];
        for(char ch:s.toCharArray())
            count1[ch]++;
        for(char ch:t.toCharArray())
            count2[ch]++;
            
        return Arrays.equals(count1,count2);
        
    }

}