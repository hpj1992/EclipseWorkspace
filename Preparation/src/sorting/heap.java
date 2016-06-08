package sorting;

public class heap {

	static int  length;
	
	public static void main(String[] args)
	{
		int[] toSort={6, 5, 3, 1, 8, 7, 2,4};
		int[] heap=new int[toSort.length];
		
		heap=toSort.clone();
	heap h=new heap();
	System.out.println("before heap"+heap.toString());
	print(heap);
	length=heap.length-1;
	h.heapify(heap);
	
	/*for(int i=length;i>=0;i--)
	{
		h.swap(heap,0,i);
		length-=1;
		h.maxheap(heap, 0);
	}*/
	System.out.println("after heap"+heap.toString());
	print(heap);
	}
	
	public void heapify(int[] heap)
	{
		int len=heap.length;
		for(int i=len/2;i>=0;i--)
		{
			
			maxheap(heap,i);
			print(heap);
		}
		
	}
	
	public void maxheap(int[] heap,int root)
	{
		int left=root*2;

		int right=root*2+1;
		int max=root;
		
		//int length=heap.length-1;
		if(left<=length &&  heap[root]<heap[left])
		{
			max=left;
		
			
		}
		else if(right<=length && heap[max]<heap[right])
		{
			max=right;
			
			//87643521
		}
		if(max!=root)
		{
			swap(heap,root,max);
			maxheap(heap,max);
		}
	}
	
	public void swap(int[] heap,int root,int ele)
	{
		int temp=heap[root];
		heap[root]=heap[ele];
		heap[ele]=temp;
	}
	
	public static void print(int[] heap)
	{
		for(int r=0;r<heap.length;r++)
			System.out.print(heap[r]+" ");
		System.out.println();
	}
}
