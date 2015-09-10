package string;

// Check whether one given string is permutation of the other or not
// Ask whether the strings are case sensitive or not, i.e. if case are different still can be considered as anagram or not? 
public class anagram{
	
	public static String sortString(String input){
		char[] charArray = input.toCharArray();
		java.util.Arrays.sort(charArray);
		return new String(charArray);
	}
	
	public static boolean isAnagram(String one, String two){
		if(one.length() != two.length())
			return false;
		return sortString(one).equals(sortString(two));
	}
	
	public static boolean isAnagramAlternative(String one, String two){
		if(one.length() != two.length())
			return false;
		
		int[] charCount = new int[256];
		char[] charArray = one.toCharArray();
		for(char c: charArray){
			charCount[c]++;
		}
		
		for(int i = 0; i< two.length(); i++){
			int c = two.charAt(i);
			if(--charCount[c] < 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		String s1 = "DOG";
		String s2 = "GOD";
//		if case matters
		if(isAnagramAlternative(s1, s2)){
			System.out.print("Alternative is anagram");
		}else{
			System.out.print("Alternative is not an anagram");
		}
		
		if(isAnagram(s1.toLowerCase(), s2)){
			System.out.print("Both are anagrams");
		}else{
			System.out.print("Not an anagram");
		}
	}
}