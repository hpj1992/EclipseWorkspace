package string;

// Replace space in string with %20
public class replaceSpace{
	public static String replaceSpace(String s){
		int spaceCount = 0, newLength = 0;
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == ' ') spaceCount++;
		}
		
		newLength = s.length() + spaceCount*2;
		char[] str = new char[newLength];
		for(int i = s.length()-1; i >= 0; i--){
			if(s.charAt(i) == ' '){
				str[newLength-1] = '0';
				str[newLength-2] = '2';
				str[newLength-3] = '%';
				newLength = newLength - 3;
			}else{
				str[newLength-1] = s.charAt(i);
				newLength = newLength - 1;
			}
		}
		return new String(str);
	}
	
	static String replaceSpaceAlt(String s1){
		String s2 = "";
		
	/*	for(int i = s1.length()-1; i>=0; i--){
			if(s1.charAt(i) == ' '){
				s2 = "%20"+s2;
			}else{
				s2 = s1.charAt(i)+s2;
			}
		}*/
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i)==' ')
				s2=s2+"%20";
			else
				s2=s2+s1.charAt(i);
		}
		
		return s2;
	}
	
	public static void main(String[] args){
		String s = "Hi, My name is kunal barve.";
		System.out.println(s);
		//String updatedString = replaceSpace(s);
		//System.out.print(updatedString);
		System.out.println(replaceSpaceAlt(s));
	}
}