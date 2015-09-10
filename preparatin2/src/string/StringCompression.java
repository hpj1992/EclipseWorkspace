package string;

public class StringCompression{
	static String doCompression(String s){
		if(getNewSize(s) > s.length())
			return s;
		String newStr = "";
		char last = s.charAt(0);
		int count = 1;
		for(int i = 1; i< s.length(); i++ )	{
			if(s.charAt(i) == last){
				count++;
			}else{
				newStr = newStr+last+count;
				count = 1;
				last = s.charAt(i);
			}
		}
		newStr = newStr+last+count;
	 return newStr;
	}
	
	static String doCompressionUsingBuffer(String s){
		if(getNewSize(s) > s.length()) return s;
		
		StringBuffer sb = new StringBuffer();
		int count = 1;
		char last = s.charAt(0);
		
		for(int i=1; i<s.length(); i++){
			if(s.charAt(i) == last) count++;
			else{
				sb.append(last);
				sb.append(count);
				count = 1;
				last = s.charAt(i);
			}
		}
		sb.append(last);
		sb.append(count);
		return sb.toString();
	}
	
	static String doCompressionUsingArray(String s){
		int newSize = getNewSize(s);
		if(newSize > s.length()) return s;
		
		char[] charArray = new char[newSize];
		int count = 1, index = 0;
		char last = s.charAt(0);
		
		for(int i =1; i< s.length(); i++){
			if(s.charAt(i) == last) count++;
			else{
				charArray[index] = last;
				index++;
				for(char c: String.valueOf(count).toCharArray()){
					charArray[index] = c;
					index++;
				}
				last = s.charAt(i);
				count = 1;
			}
		}
		charArray[index] = last;
		index++;
		for(char c: String.valueOf(count).toCharArray()){
			charArray[index] = c;
			index++;
		}
		return String.valueOf(charArray);
	}
	
	static int getNewSize(String str){
		if(str.isEmpty()) return 0;
		char last = str.charAt(0);
		int count = 1, size = 0;
		for(int i=1; i< str.length(); i++){
			if(str.charAt(i) == last) count++;
			else{
				size += 1 + String.valueOf(count).length();
				count = 1;
				last = str.charAt(i);
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	static String optimalCompression(String s1){
		String s2 = "";
		int count = 1;
		char last = s1.charAt(0);
		
		for(int i = 1; i<s1.length(); i++){
			if(s1.charAt(i) == last) count++;
			else{
				s2 = s2+last+count;
				last = s1.charAt(i);
				count = 1;
			}
		}
		
		s2 = s2+last+count;
		
		if(s2.length() > s1.length())
			return s1;
		
		return s2; 
	}
	
	public static void main(String[] args){
		String s1 = "aaaaaaaaaaabbbbbbccccdddddddddeeeeeeeefgughghjffdddddddaaaaaaaaaaaaaa";
		System.out.println(s1+":Length:"+s1.length());
		
	/*	String compressedString = doCompression(s1);
		System.out.println(compressedString+":Length:"+compressedString.length());
		
		String compressedStringUsingBuffer = doCompressionUsingBuffer(s1);
		System.out.println(compressedStringUsingBuffer+":Length:"+compressedStringUsingBuffer.length());
		
		String compressedStringUsingArray = doCompressionUsingArray(s1);
		System.out.println(compressedStringUsingArray+":Length:"+compressedStringUsingArray.length());
		*/
		
		String optimal = optimalCompression("abcdcccccccdddddddaaaaaaaaaccccccc");
		System.out.println(optimal+":Length:"+optimal.length());
		
	}
}