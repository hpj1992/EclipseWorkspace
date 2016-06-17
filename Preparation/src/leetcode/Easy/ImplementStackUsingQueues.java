package leetcode.Easy;

import java.util.*;

import sorting.LinkedList;

public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}

class MyStack {
	Queue q1 =  (Queue) new LinkedList();
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
        for(int i=0;i<q1.size()-1;i++)
        {
        	q1.add(q1.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.poll();
    }

    // Get the top element.
    public int top() {
        return (int) q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.size() == 0;
    }
}
