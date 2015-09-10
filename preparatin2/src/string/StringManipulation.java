package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;


public class StringManipulation {
	
	//-------------------------------------------------------------------------------------------------------------
	// Find all possible permutation or anagrams of the given string. 
	// Time O(n!) as there are n! permutations, we can't do better than this.
	
	static ArrayList<String> findAllPermutation(String string) {
		
		if (string == null)
			return null;
		ArrayList<String> array = new ArrayList<String>();
		if (string.length() == 0) {
			array.add("");
		}else{
			char c = string.charAt(0);
			
			ArrayList<String> words = findAllPermutation(string.substring(1));
			for (String word : words) {
				for (int j = 0; j <= word.length(); j++) {
					array.add(word.substring(0, j)+c+word.substring(j));
				}
			}
		} 
		return array;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	// Find longest common string in given string arrays
	
	static String findCommomnSubStr(String[] str){
		String common = "";
		String smallest = str[0];
		
		for(String s: str){
			if(s.length() < smallest.length())
				smallest = s;
		}
		
		System.out.println("Smallest String is :"+smallest);
		
		String temp = "";
		for(char c: smallest.toCharArray()){
			temp += c;
			
			boolean containInAll = true;
			
			for(String s: str){
				if(! s.contains(temp)){ 
					temp = "";
					containInAll = false;
					break;
				}
			}
			
			if(containInAll && temp.length() > common.length())
				common = temp;
			
			//If continued string is not there in all list then assign the current character for new sequence
			if(!containInAll)
				temp = String.valueOf(c);
			
		}
		
		return common;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	// Longest palindrome in the given string
	
	static String longestPalindrome(String s) {
	        if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
	 
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			
			//For odd length 
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// For even length
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
		
	}
 
	// Given a center, either one letter or two letter, 
	// Find longest palingdrome
	static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	//-------------------------------------------------------------------------------------------------------------
	// Fibonacci series up to the limit
	
	static String fibonacciSeries(int limit){
		int[] fibo = new int[limit];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2; i<limit; i++){
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		
		String result = "";
		for(int no: fibo){
			result += no+" ";
		}
		return result;
	}
	
	//----------------------------------------------------------------------------------------
	// All possible substrings of a given string iterative approach
	
	static ArrayList<String> allSubStrings(String s){
		int len = s.length();
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i< len; i++){
			for(int j = i+1; j<=len; j++){
				list.add(s.substring(i, j));
			}
		}
		return list;
	}
	
	// Recursive approach
	static String input = "abcd";
	static void generateSubStrings(int start, int end){
		if(start == input.length() && end == input.length()){
			return;
		}else{
			if(end == input.length()+1){
				generateSubStrings(start+1, start+1);
			}else{
				System.out.print(input.substring(start, end)+" ");
				generateSubStrings(start, end+1);
			}
			
		}
	}

	//----------------------------------------------------------------------------------------
	// Word reversal in the string.
	
	static String reverseString(String s1){
		String result = "";
		
		char[] charArray = s1.toCharArray();
		String word = "";
		for(int i = 0; i<=charArray.length -1; i++){
			word += charArray[i];
			if(charArray[i] == ' ' ){
				result = word+" "+result;
				word = "";
			}
		}
		return word+" "+result;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	//Given multiple list form urls. -paypal
	static List<String> find(List<List<String>> li)
	{
		if(li==null)
			return null;
		if(li.size()==1)
			return li.get(0);
		List<String> temp=li.get(0);
		li.remove(0);
		List<String> ans=find(li);
		List<String> t=new ArrayList<String>();
		for(String s:temp)
		{
		     for(String s1:ans)
		     {
		    	 String fin=s+"."+s1;
		    	 t.add(fin);
		     }
		}
		return t;
	}
	//-------------------------------------------------------------------------------------------------------------
	// Random number generator without inbuilt method
	
	static	long randNumber(long seed) {
		  seed ^= (seed << 21);
		  seed ^= (seed >>> 35); // 3 > symbols!
		  seed ^= (seed << 4);
		  return seed;
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	//given a string, return the word that occurs the most in the string
	//input : test this string contains test
	//output: test



	static String getMaxCount(String input){
	    
	    if(input.isEmpty())
	        return "";

	    HashMap<String, Integer> stringList = new HashMap<String, Integer>();
	    
	    StringTokenizer st = new StringTokenizer(input, " ");
	    
	    while(st.hasMoreElements()){
	        String word = st.nextToken();
	        if(stringList.containsKey(word)){
	            int count = stringList.get(word);
	            count++;
	            stringList.put(word, count);
	        }else{
	           int count = 1;
	           stringList.put(word, count);
	        }
	    }
	    
	    int maxCount = 0;
	    String result = "";
	       
	       for(String word : stringList.keySet()){
	           int count = stringList.get(word);
	           if(count > maxCount){
	               maxCount = count;
	               result = word;
	           }
	       }
	    
	    return result;
	    
	}
	
	
	public static void main(String[] args){
		String[] str = {"abcde", "abecdeffffa", "abtjkcdef", "abdefbcde"};
		System.out.println("Common String : "+findCommomnSubStr(str));
		System.out.println(""+findAllPermutation("abcd").toString());
		System.out.println("Longest palindrom: "+longestPalindrome("abahkjjbffchadamokaloveevolkkkkkkkkkabcba"));
		/*System.out.println(new String("abcdef").substring(1,1));*/
//		System.out.println("Fibo Series: "+fibonacciSeries(15));
//		System.out.println("Sub strings : "+allSubStrings("abc").toString());
//		System.out.println("Result:"+reverseString("I hate yahoo"));
		
		generateSubStrings(0, 1);
		
//System.out.println(getMaxCount(null));
	}
}
