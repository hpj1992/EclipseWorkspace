package leetcode;

import java.util.Stack;

public class ImplementQueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Stack<Integer> front = new Stack<Integer>();
	Stack<Integer> back = new Stack<Integer>();

	public void push(int x) {
		front.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if(back.isEmpty())
		{
		moveStackElements();
		}
		back.pop();
	}

	// Get the front element.
	public int peek() {

		int toReturn = 0;
		if(back.isEmpty())
		{
		moveStackElements();
		}
		toReturn = (int) back.peek();

		return toReturn;

	}

	// Return whether the queue is empty.
	public boolean empty() {

		moveStackElements();
		return back.isEmpty();
	}

	public void moveStackElements() {
		while (!front.isEmpty()) {
			back.push(front.pop());
		}

	}

}
