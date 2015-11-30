import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Temp {

	 static int[] sortIntersect(int[] f, int[] m) {
	        
	        TreeMap<Integer,Integer> males = new TreeMap<Integer, Integer>();
	        TreeMap<Integer,Integer> females = new TreeMap<Integer, Integer>();
	        
	        for(int i=0; i < f.length; i++)
	            {
	            if(females.containsKey(f[i]))
	                {
	                int count = females.get(f[i]);
	                count++;
	                females.put(f[i],count);
	            }
	            else
	                {
	                 females.put(f[i],1);
	            }
	        }
	         for(int i=0; i < m.length; i++)
	            {
	            if(males.containsKey(m[i]))
	                {
	                int count = males.get(m[i]);
	                count++;
	                males.put(m[i],count);
	            }
	            else
	                {
	                 males.put(m[i],1);
	            }
	        }
	        ArrayList<Integer> answer = new ArrayList<Integer>();
	         for(Map.Entry<Integer,Integer> entry : males.entrySet()) {
	        	 Integer age = entry.getKey();
	        	 Integer count = entry.getValue();
	        	 if(females.containsKey(age))
	        	 {
	        		 if(females.get(age) == count)
	        		 {
	        			 for(int i=0; i < count; i++)
	        			 {
	        				 answer.add(age);
	        			 }
	        		 }
	        		 else
	        		 {
	        			 answer.add(age);
	        		 }
	        	 }
	        	 
	        	}
	         int[] ret = new int[answer.size()];
	         int i = 0;
	         for (Integer e : answer)  
	             ret[i++] = e.intValue();
	         for(i = 0; i < ret.length / 2; i++)
	         {
	             int temp = ret[i];
	             ret[i] = ret[ret.length - i - 1];
	             ret[ret.length - i - 1] = temp;
	         }
	         return ret;

	    }
}
