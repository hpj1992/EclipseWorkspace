package leetcode.Medium;

import java.util.Stack;

public class Brackets_20 {

	public static void main(String[] args)
	{
		System.out.println(getProperBrackets("[[[[]]]]"));
	}
	
	public static boolean getProperBrackets(String s)
	{
		String openBrackets = "({[";
        String closeBrackets = "}])";
        Stack<Character> brackets = new Stack<Character>();
        
        if( s == null || s.length()==0)
            return false;
        else
        {
            char[] letters = s.toCharArray();
            for(int i=0;i<letters.length;i++)
            {
            	char ch = letters[i];
              switch(ch)
              {
              case '{' : brackets.push(ch);break;
              case '(' : brackets.push(ch);break;
              case '[' : brackets.push(ch);break;
              case '}' :
              {
            	  if(!brackets.peek().equals('{'))
            		  return false;
            	  else
            		  brackets.pop();
            	  
            	  break;
              }
              case ']' :
              {
            	  if(!brackets.peek().equals('['))
            		  return false;
            	  else
            		  brackets.pop();
            	  
            	  break;
              }
              case ')' :
              {
            	  if(!brackets.peek().equals('('))
            		  return false;
            	  else
            		  brackets.pop();
            	  
            	  break;
              }
              }
            }
            return true;
        }
	}
}
