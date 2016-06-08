package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.*;

class bracket {

    private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
    static {
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');
    }  

    private bracket() {};

   
    public static boolean isBalanced(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("String length should be greater than 0");
        }
        // odd number would always result in false
        if ((str.length() % 2) != 0) {
            return false;
        }

        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (brackets.containsKey(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if (stack.empty() || (str.charAt(i) != brackets.get(stack.pop()))) {
                return false;
            } 
        }
        
        return true;
    } 
    

    

    public static void main(String[] args) {
    	 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	   StringBuilder out = new StringBuilder();
    	   // public int minUnfairness=0;
    	   
    	      try {
				String s1 = new String(in.readLine());
				  String s2 = new  String(in.readLine());

			       System.out.println(isBalanced(s1));
			       System.out.println(isBalanced(s2));
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    
       
    	// assertEquals(true, isBalanced("{}([])"));
        //assertEquals(false,isBalanced("([}])"));
        //assertEquals(true, isBalanced("([])"));
       // assertEquals(true, isBalanced("()[]{}[][]"));
    }
}