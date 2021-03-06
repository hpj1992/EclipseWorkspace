package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

      private static HashMap<Integer,Integer> totalWays = new HashMap<Integer,Integer>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] elements = line.split(" ");
        int total = Integer.valueOf(elements[0]);
        int coinCount = Integer.valueOf(elements[1]);
        line = scanner.nextLine();
        elements = line.split(" ");
        ArrayList<BigInteger> coins = new ArrayList<BigInteger>();
        
        for(int i = 0; i < elements.length; i++)
            {
        		
                coins.add(new BigInteger(elements[i]));
                totalWays.put(coins.get(i).intValue(),0);
        }
        
       int totalWays = count(coins, coins.size(), total);// computeWays(total,coins);
        System.out.println(totalWays);
    }
    
    private static int computeWays(int amount, ArrayList<Integer> coins)
        {
        if(coins.size() == 0)
            return 0;
        else if(coins.size() == 1 && (amount % coins.get(coins.size() - 1)) == 0)
            return 1;
         int curCoin = coins.get(coins.size() - 1);
        
        if(curCoin == 1)
        	return 1;
         
         
        if(totalWays.get(curCoin) !=0)
            return totalWays.get(curCoin);
        
        int ways = 0;
       
        coins.remove(coins.size() - 1);
        for(int i = 0 ; i*curCoin <= amount; i++)
            {
            ways += computeWays((amount - i*curCoin),coins);
        }
        return ways;
    }
    private static Integer count( ArrayList<BigInteger> coins, int coinIndex, int sum )
    {
    	BigInteger[][] table = new BigInteger[sum+1][coinIndex];
    	
    	for(int i=0;i < coinIndex; i++)
    		table[0][i] = BigInteger.ONE;
    	
    	for ( int i=1 ; i < sum + 1 ; i++)
    	{
    		for (int j=0; j < coinIndex ; j++)
    		{
    			BigInteger x = (BigInteger) (( i - coins.get(j).intValue()) >= 0 ? table[i - coins.get(j).intValue()][j] : BigInteger.ZERO) ; // Including current index coin
    			BigInteger y = (BigInteger) ((j >= 1 ) ? table[i][j - 1] : BigInteger.ZERO); // Excluding current index coin
    			table[i][j] = x.add(y);
    		}
    	}
    	
    	return table[sum][coinIndex-1].intValue();
       /* // If n is 0 then there is 1 solution (do not include any coin)
    	System.out.println(coins.toString() + "Index:" + coinIndex + " Sum:" + sum);
        if (sum == 0)
            return 1;
         
        // If n is less than 0 then no solution exists
        if (sum < 0)
            return 0;
     
        // If there are no coins and n is greater than 0, then no solution exist
        if (coinIndex <=0 && sum >= 1)
            return 0;
     
        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count( coins, coinIndex - 1, sum ) + count( coins, coinIndex, sum-coins.get((coinIndex-1)) );*/
    }
}