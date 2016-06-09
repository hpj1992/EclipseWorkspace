package leetcode;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("A man, a plan, a canal: Panama"));
	}

	public static boolean isValid(String str)
	{
		 if(str == null || str.length() == 0)
				return true;
			char[] arr = str.toCharArray();
			int end = arr.length - 1;
			int i = 0;
			while(i <= end)
			{
				char ch1 = arr[i];
				char ch2 = arr[end];
				if(!Character.isLetterOrDigit(ch1))
				{
					i++;
				}
				else if (!Character.isLetterOrDigit(ch2))
				{
					end--;
				}
				else{
				    if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2))
					return false;
						i++;
			        	end--;
				}
			
			}
			return true;
	}
	
}
