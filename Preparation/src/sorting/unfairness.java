package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;
import java.lang.*;
import java.util.Arrays;
import java.util.Collections;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.
/*
 * first line: total input
 * second line : sunstring size
 * all total input 
 * 
 * 6  
 * 3
 * 10
 * 20
 * 30
 * 100
 * 200
 * 300
 * 
 */
public class unfairness {
   static BufferedReader in = new BufferedReader(new InputStreamReader(
         System.in));
   static StringBuilder out = new StringBuilder();
    public static int minUnfairness=0;
   public static void main(String[] args) throws NumberFormatException, IOException {
      int numPackets = Integer.parseInt(in.readLine());
      int numKids = Integer.parseInt(in.readLine());
      int[] packets=new int[numPackets];//{1,2,3,4,5,6};
      
    for(int i = 0; i < numPackets; i ++)
      {
         packets[i] = Integer.parseInt(in.readLine());
      }
     
       int[] temp=packets;
       Arrays.sort(packets);
       minUnfairness=packets[packets.length-1];
       packets=temp;
        combinations2(packets, numKids, 0, new int[numKids]);
       
      int unfairness = minUnfairness;
      
        // Write your code here, to process numPackets N, numKids K, and the packets of candies
      // Compute the ideal value for unfairness over here
      
      System.out.println(unfairness);
   }
    
     static void combinations2(int[] arr, int len, int startPosition, int[] result){
        if (len == 0){
            Arrays.sort(result);
            
           int max=result[result.length-1];
            int min =result[0];
           
            int unfairness=max-min;
            if(unfairness<minUnfairness)
                minUnfairness=unfairness;
            
          
            return;
            
        }       
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }     
}
