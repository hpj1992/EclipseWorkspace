package string;

public class palindrome{
	
	private static boolean isPalinDrome(String s){
		int start = 0, i;
		int end = s.length() - 1;
		int middle = (start+end)/2;
		
		for(i = start; i<= middle; i++){
			if(s.charAt(start) == s.charAt(end)){
				start++;
				end--;
			}else{
				break;
			}
		}
		
		if(i == middle+1){
			return true;
		}
		return false;
	}
	
	private static boolean isPalinDromeAlternative(String s){
		StringBuffer sb = new StringBuffer();
		
		for(int i = s.length() -1 ; i>= 0; i--){
			sb.append(s.charAt(i));
		}
		
		if(s.equals(sb.toString())) return true;
		
		return false;
	}
	
	public static void main(String[] args){
		String s = "madM";
		
		if(isPalinDrome(s)){
			System.out.print("Given string is a palindrome");
		}else{
			System.out.print("Not a palindrome");
		}
		
		if(isPalinDromeAlternative(s)){
			System.out.println("Ok,Given string is a palindrome");
		}else{
			System.out.print("Ok, Not a palindrome");
		}
	}
}