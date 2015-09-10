package sorting;

public class bubble {

	public void swap(int[] toSort,int firstPosition,int secondPosition)
	{
		
		int temp=toSort[firstPosition];
		toSort[firstPosition]=toSort[secondPosition];
		toSort[secondPosition]=temp;
		
	}
	
	public static void main(String[] args)
	{
		bubble b=new bubble();
		int[] toSort={5,6,7,8,9,25,65,98,12,45,78,65,89,12,02,65,74,23,558,13,18,2};
		int iterationCount=0;
		for(int j=0;j<toSort.length-1;j++)
		{
			iterationCount=toSort.length-1-j;
			System.out.println();
			for(int i=0;i<iterationCount;i++)
			{
				if(toSort[i]<toSort[i+1]) // Descending : if(toSort[i]>toSort[i+1])
				{
					
				}
				else
				{
					b.swap(toSort,i,i+1);
				}
				System.out.print("Pass "+i+" : ");
				for(int value: toSort)
				{
					System.out.print(value+" ");
				}
				System.out.println();
			}
			System.out.print("------------One element at correct position.");
		}
		
		
		
	}
	
}
