package leetcode;

import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
	
	Stack<Integer> values = new Stack<Integer>();
	Stack<Integer> minimum = new Stack<Integer>();
	
    public MinStack() {
        
    }
    
    public void push(int x) {
        values.push(x);
        if(minimum.isEmpty() || x <= minimum.peek())
        	minimum.push(x);
    }
    
    public void pop() {
    	if(values.size() > 0)
    	{
	        int poped = values.pop();
	        if( minimum.size() > 0 && poped == minimum.peek())
	        	minimum.pop();
    	}
    }
    
    public int top() {
    	if(!values.isEmpty())
        return values.peek();
    	return -1;
    }
    
    public int getMin() {
    	if(!minimum.isEmpty())
        return minimum.peek();
    	return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */