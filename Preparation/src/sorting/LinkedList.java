package sorting;

public class LinkedList {
	
	Node head;
	int count=0;
	
	public LinkedList()
	{
		head=new Node();
		count=0;
	}
	
	public void insertAtEnd(int data)
	{
		Node newNode=new Node(data,null);
		Node ptr=head;
		if(count==0)
		{
			head=newNode;
		}
		
		else
		{
			while(ptr.next!=null)
			{
				ptr=ptr.next;
			}
			ptr.next=newNode;
			
		}
		
		count++;
	}
	
	public void insertAtBeginning(int data)
	{
		Node newNode=new Node(data,null);
		
		if(count==0)
		{
			head=newNode;
		}
		else 
		{
			
			newNode.next=head;
			head=newNode;
		}
		count++;
	}
	
	public void insertAfterThisNode(int data,int newData)
	{
		Node newNode=new Node(newData,null);
		if(count==0)
		{
			System.out.println("Can not insert after"+ data +" node. List is empty.");
			
		}
		else if(head.data==data)
		{
			head.next=newNode;
			count++;
		}
		else
		{
			Node ptr=head;
			while(ptr!=null)
			{
				if(ptr.data==data)
				{
					Node temp=ptr.next;
					ptr.next=newNode;
					newNode.next=temp;
					count++;
					break;
					
				}
				else
				{
					ptr=ptr.next;
				}
			}
		}
	}
	public void insertBeforeThisNode(int data,int newData)
	{
		Node newNode=new Node(newData,null);
		if(count==0)
		{
			System.out.println("Can not insert after"+ data +" node. List is empty.");
			
		}
		else if(head.data==data)
		{
			head.next=newNode;
			count++;
		}
		else
		{
			Node ptr=head;
			while(ptr!=null)
			{
				if(ptr.next.data==data)
				{
					Node temp=ptr.next;
					ptr.next=newNode;
					newNode.next=temp;
					count++;
					break;
					
				}
				else
				{
					ptr=ptr.next;
				}
			}
		}
	}
	
	public void printReverse(Node ptr)
	{
		if(ptr==null)
			{
			System.out.print("test");return;
			}
		//ptr=ptr.next;
		printReverse(ptr.next);
		System.out.print(ptr.data);
	}
	public void checkForPalindrom()
	{
		Node ptr=head;
		Node headBackup=head;
		int count=0;
		while(ptr!=null)
			{
			ptr=ptr.next;count++;
			}
		System.out.println("length="+count);
		isPalindrome(head,count);
		head=headBackup;
		
	}
	public void isPalindrome(Node ptr,int length)
	{
		//Node ptr2=ptr;
		System.out.println("Lenght:"+length);
		if(ptr==null)
			{
			return;
			}
		//ptr=ptr.next;
		//head=head.next;
		isPalindrome(ptr.next,length-2);
		if(length==0 || length==1)
		{
			System.out.println("String is palindrome");
			System.exit(1);
		}
		else
		{
			if(ptr.data!=head.data)
				{
				System.out.println(ptr.data+ "!="+head.data);
				System.out.println("NOT A PALINDROME");
			System.exit(0);}
			else
			{
			System.out.println(ptr.data+ "="+head.data+" length="+length);
			head=head.next;
			}
		}
		
		
		
	}
public void displayLinkedList() 
	{
		Node current=head;
		int temp=count;
		if(count==0)
		{
			System.out.println("Empty Linked List.");
		}
		else if(current.next==null)
		{
			System.out.println("["+head.data+"]");
		}
		else
		{
			System.out.print("[");
			
			while(count!=0)
			{
				System.out.print(current.data+"-->");
				current=current.next;
				count--;
			}
			System.out.print("]");
		}
		count=temp;
		
	}
	
	public void RemoveNode(int data)
	{
		if(head.data==data)
		{
			head=null;
			System.out.println("Node removed.Empty list.");
		}
		else
		{
			Node current=head;
			while(current!=null)
			{
				
				if(current.next.data==data)
				{
					Node temp=current.next.next;
					current.next=temp;
					
					count--;
					break;
				}
					current=current.next;			
			}
		}
	}
	public static void main(String[] args)
	{
		LinkedList list=new LinkedList();
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.insertAtEnd(9);
		list.insertAtEnd(7);
		list.insertAtEnd(6);
		list.insertAtEnd(5);
	//	list.insertAtEnd(6);
		//list.insertAtEnd(55);
		//list.insertAtBeginning(12);
		//list.insertAfterThisNode(55,23);
		//list.insertBeforeThisNode(55,32);
		//System.out.println(list.head.data);
		list.displayLinkedList();
		list.printReverse(list.head);
		list.displayLinkedList();
		list.checkForPalindrom();
		list.RemoveNode(32);
		list.displayLinkedList();
		
	}

}

class Node
{
	
	 int data;
	 Node next;
	
	public Node()
	{
		data=0;
		next=null;
	}
	
	public Node(int data,Node link)
	{
		this.data=data;
		next=link;
	}
}
