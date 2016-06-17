package leetcode.Medium;
/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */
public class UniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//The way we can find solution is to pick each element from 1 to n. Take that element as a root and find the # of valid bst possible. And add those values which will yield the final answer.
	//Now to find the valid bst for when each element is at root we will follow below logic.
	//For each element, all the elements in it's left will be in left sub tree and all the elements in it's right will be in its right sub tree.
	//We will find valid BST for left elements and right elements. And then do the multiplication.It will give us valid BSTs for one particular root element.
	//When we have 1 or 0 elements.Valid BST would be 1.That will be our base case for DP.
	public int numTrees(int n) {
		int[] G = new int[n+1];
		G[0] = G[1] = 1;
		
		for(int i=2;i<=n;i++)
		{
			for(int j = 1;j<=i;j++)
			{
				G[i] = G[i] + G[j-1]*G[i-j];
				//G[j-1] is count of valid BST from left of j
				//G[i-j] is ocunt of valid BST from right of j
			}
		}
		return G[n];
	}

}
