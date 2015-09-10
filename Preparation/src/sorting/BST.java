package sorting;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

import sun.misc.Queue;

//import ctci.BST;

public class BST<T extends Comparable<T>> {
	TreeNode<T> root, tempNode;
	Comparator<T> comp;

	// static TreeNode<T> ;
	// MyComparator comparator=new MyComparator();
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>(new MyComparator());
		Integer[] a = { 20, 10, 30, 5, 15, 3, 7, 17 };
		// / BST<Integer> bst = new BST,Integer>();
		for (Integer n : a)
			bst.insert(n);

		// bst.in/sert(3);
		// bst.insert(2);
		// bst.insert(1);

		System.out.println(bst.root);
		System.out.println(bst.root.left);
		System.out.println(bst.root.right);
		System.out.println("Pre Order:");
		bst.preOrderTraversal();
		// bst.tempNode=new TreeNode<T>(17);

		printRootToNodePath(bst.root, bst.tempNode);
		/*
		 * System.out.println("In Order"); // bst.InOrderTraversal();
		 * System.out.println("Post Order"); // bst.postOrderTraversal();
		 * //bst.Search(55); System.out.println("Height:"+bst.height()); //
		 * bst.delete(6); bst.preOrderTraversal(); // bst.delete(4); //
		 * bst.delete(9); System.out.println("Height:"+bst.height());
		 * bst.preOrderTraversal(); Iterator<Integer>
		 * iterator=(Iterator<Integer>) bst.preOrderNonrecursive();
		 * //iterator.next();iterator.next();iterator.next();
		 * System.out.println(
		 * "NExt:"+iterator.next()+iterator.next()+iterator.next());
		 */

	}

	private static void printRootToNodePath(TreeNode<Integer> root2,
			TreeNode<Integer> node) {
		// TODO Auto-generated method stub
		if (root2 != null) {
			path.add((Integer) root2.root);
			if (root2.root == node.root) {
				System.out.println("PATH" + path.size());
				printStack(path);
				return;
			}
			// System.out.print(root2+" ");
			if (root2.left != null) {
				printRootToNodePath(root2.left, node);
				path.pop();
			}
			if (root2.right != null) {
				printRootToNodePath(root2.right, node);
				path.pop();
			}
		}
	}

	public BST() {
		root = null;
		comp = null;
	}

	public BST(Comparator<T> comp) {
		root = null;
		this.comp = comp;
	}

	public int compare(T x, T y) {
		if (comp == null)
			return x.compareTo(y);
		else
			return comp.compare(x, y);
	}

	public void insert(T data) {
		root = insertNode(root, data);
	}

	public TreeNode<T> insertNode(TreeNode<T> node, T data) {
		if (node == null)
			node = new TreeNode<T>(data);
		else if (compare(data, node.root) == 0) {
			return node;
		} else if (compare(data, node.root) > 0)
			node.left = insertNode(node.left, data);
		else if (compare(data, node.root) < 0)
			node.right = insertNode(node.right, data);

		return node;
		// else if()
	}

	public void preOrderTraversal() {
		preOrderHelper(root);
	}

	public static Stack<Integer> path = new Stack<Integer>();

	private void preOrderHelper(TreeNode<T> root2) {
		if (root2 != null) {
			System.out.print(root2 + " ");
			preOrderHelper(root2.left);
			preOrderHelper(root2.right);

		}
		// System.out.println(path.toArray().toString());
	}

	public static void printStack(Stack<Integer> s) {
		int i = 0;
		while (i < s.size()) {
			System.out.println(s.get(i));
			i++;
		}
	}

	/*
	 * public void printRootToNodePath(TreeNode<T> root2,TreeNode<T> node){
	 * 
	 * 
	 * }
	 */
	public void InOrderTraversal() {
		inOrder(root);
	}

	private void inOrder(TreeNode<T> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root + " ");
			inOrder(root.right);
		}
	}

	public void postOrderTraversal() {
		postOrder(root);
	}

	private void postOrder(TreeNode<T> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root + " ");
		}
	}

	public void Search(T searchItem) {
		TreeNode<T> result = searchNode(root, searchItem);
		if (result != null)
			System.out.println("Search successful.");
		else {
			System.out.println("Item not found.");
		}
	}

	public TreeNode<T> searchNode(TreeNode<T> root, T searchItem) {

		if (root == null) {
			System.out.println("Not found");
			return null;
		} else if (compare(searchItem, root.root) == 0) {
			return root;
		} else if (compare(searchItem, root.root) > 0)
			searchNode(root.left, searchItem);
		else if (compare(searchItem, root.root) < 0)
			searchNode(root.right, searchItem);
		return root;
	}

	public void delete(T dataToDelete) {
		root = delete(root, dataToDelete);
	}

	private TreeNode<T> delete(TreeNode<T> root, T toDelete) {
		if (root == null) {
			System.out.println("Can not delete.Tree is empty.");
		}

		else if (compare(toDelete, root.root) > 0) {
			root.left = delete(root.left, toDelete);
		} else if (compare(toDelete, root.root) < 0) {
			root.right = delete(root.right, toDelete);
		} else if (compare(toDelete, root.root) == 0) {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				root.root = getRightMostFromLeft(root.left);
				root.left = delete(root.left, root.root);
			}
		}
		return root;

	}

	public T getRightMostFromLeft(TreeNode<T> root) {
		while (root.right != null)
			root = root.right;
		return root.root;
	}

	public int height() {
		return getHeight(root);
	}

	public int getHeight(TreeNode<T> root) {
		if (root == null)
			return 0;
		else {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
	}

	/*
	 * public T getNextBFS() { Queue queue=new Queue(); if(root!=null) {
	 * queue.enqueue(root); } TreeNode<T> current = null; try { current =
	 * (TreeNode<T>)queue.dequeue(); if(current.right!=null) {
	 * queue.enqueue(current.right); } if(current.left!=null) {
	 * queue.enqueue(current.left);
	 * 
	 * }
	 * 
	 * } catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * // TODO Auto-generated method stub return current.root; }
	 */
	public Iterator<T> preOrderNonrecursive() {
		return (Iterator<T>) new NonRecursiveIterator();
	}

	class NonRecursiveIterator<T> implements Iterator<T> {

		Stack<TreeNode<T>> nodeStack = new Stack<TreeNode<T>>();
		Queue nodeQueue = new Queue();

		public NonRecursiveIterator() {
			if (root != null) {
				nodeStack.add((TreeNode<T>) root);
				nodeQueue.enqueue(root);
			}
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if (nodeStack.isEmpty())
				return false;
			else
				return true;

		}

		@Override
		/*
		 * public T next() { //bfs TreeNode<T> current = null; try { current =
		 * (TreeNode<T>)nodeQueue.dequeue(); if(current.left!=null) {
		 * //nodeStack.push(current.left); nodeQueue.enqueue(current.left); }
		 * else { //TreeNode<T> temp=nodeStack.pop(); TreeNode<T>
		 * temp=(TreeNode<T>) nodeQueue.dequeue(); while(temp.right==null) {
		 * if(nodeQueue.isEmpty()) return current.root; // temp=nodeStack.pop();
		 * temp=(TreeNode<T>) nodeQueue.dequeue(); }
		 * //nodeStack.push(temp.right); nodeQueue.enqueue(root);
		 * 
		 * } // TODO Auto-generated method stub
		 * 
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } //TreeNode<T>
		 * current=(TreeNode<T>)nodeStack.peek(); return current.root; }
		 */
		/*
		 * public T next() { //dfs-preorder TreeNode<T>
		 * current=(TreeNode<T>)nodeStack.peek(); if(current.left!=null) {
		 * nodeStack.push(current.left);
		 * 
		 * } else { TreeNode<T> temp=nodeStack.pop();
		 * 
		 * while(temp.right==null) { if(nodeStack.isEmpty()) return
		 * current.root; temp=nodeStack.pop();
		 * 
		 * } nodeStack.push(temp.right);
		 * 
		 * 
		 * } // TODO Auto-generated method stub return current.root; }
		 */
		public T next() {
			// dfs-inorder
			TreeNode<T> current = (TreeNode<T>) nodeStack.peek();
			int data = 0;
			if (current.left != null) {
				// nodeStack.push(current.left);

				while (current.left != null) {
					// if(nodeStack.isEmpty()) return current.root;
					nodeStack.push(current.left);
					current = current.left;

				}

			} else {
				TreeNode<T> temp = nodeStack.pop();

				current = temp;
				data = (int) current.root;
				while (temp.right == null) {
					// if(nodeStack.isEmpty()) return current.root;
					temp = nodeStack.pop();
				}

				nodeStack.push(temp.right);
				// nodeStack.push(temp);
			}
			// TODO Auto-generated method stub
			System.out.println("Stack:" + nodeStack.toString() + "current"
					+ current + data);
			return current.root;
		}

		/*
		 * public T next() { //dfs-preorder TreeNode<T>
		 * current=(TreeNode<T>)nodeStack.pop(); if(current.right!=null) {
		 * nodeStack.push(current.right); } if(current.left!=null) {
		 * nodeStack.push(current.left);
		 * 
		 * }
		 * 
		 * 
		 * // TODO Auto-generated method stub return current.root; }
		 */
		/*
		 * public T next() {
		 * 
		 * //bfs TreeNode<T> current = null; try { current =
		 * (TreeNode<T>)nodeQueue.dequeue(); if(current.left!=null) {
		 * nodeQueue.enqueue(current.left);
		 * 
		 * } if(current.right!=null) { nodeQueue.enqueue(current.right); }
		 * 
		 * 
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * // TODO Auto-generated method stub return current.root; }
		 */

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}
}

class TreeNode<T> {
	T root;
	TreeNode<T> left, right;

	public TreeNode(T data) {
		root = data;
		left = null;
		right = null;
	}

	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		root = data;
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return root.toString();
	}
	/*
	 * public static TreeNode<T> getOneObject(T i){ return new TreeNode<T>(i); }
	 */

}

class MyComparator implements Comparator<Integer> {
	public int compare(Integer x, Integer y) {
		return y - x;
	}

}
