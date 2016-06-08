package Amazon;

import java.util.Stack;

public class ValidParenthesis {

	public boolean isValidParenthesis(String str)
	{
		if(str== null || str.length() == 0)
			return false;
		
		Stack<Character> chars = new Stack<Character>();
		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			if(chars.isEmpty())
				chars.push(ch);
			else if(ch - chars.peek() == 1 || chars.peek() - ch == 2) // Ascii values if all the close bracket - open bracket is either 1 or 2. Which is condition for valid brackets.
				chars.pop();
			else	
				chars.push(ch);
		}
		return chars.isEmpty();
	}
}
