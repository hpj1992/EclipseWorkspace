package sorting;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class insertion {

	
	
	public static void main(String[] args)
	{
	int[] toSort={9,8,7,6,5,4,3,2,1,0,3,51,0,3,5,9,8,7,1,5,6,9,8,129,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129};
		System.out.println("before");
		char c=(char)toSort[5];
		System.out.println((char)65);
		
	for(int i=0;i<toSort.length;i++)
			System.out.print(toSort[i]+" ");
		for(int i=0;i<toSort.length;i++)
		{
			int currentIndex=i;
			int current=toSort[currentIndex];
			for(int j=currentIndex;j>0;j--)
			{
				if(toSort[j]<toSort[j-1])
				{
					int k=j;
					while(k>0)
					{
						
						if(current<toSort[k-1])
						{
							//int swap=toSort[k];
							toSort[k]=toSort[k-1];
						toSort[k-1]=current;
						
						}
						k--;
					}
					for(int r=0;r<toSort.length;r++)
						System.out.print(toSort[r]+" ");
				System.out.println();
				}
			}
		}
		System.out.println("after"+toSort.toString());
		for(int i=0;i<toSort.length;i++)
			System.out.print(toSort[i]+" ");
		
	}
}

//-------------------------- More simple Solution below.
/*
package sorting;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class insertion {

	
	
	public static void main(String[] args)
	{
		int[] toSort={9,8,7,6,5,4,3,2,1,0,3,51,0,3,5,9,8,7,1,5,6,9,8,129,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129};
		System.out.println("before");
		char c=(char)toSort[5];
		System.out.println((char)65);
		
		for(int i=0;i<toSort.length;i++)
			System.out.print(toSort[i]+" ");
		for(int i=0;i<toSort.length-1;i++)
		{
			int j=i+1;
			int temp=toSort[j];
			int k=i;
			while(k>=0)
			{
				if(toSort[k]>temp)
				{
					toSort[j]=toSort[k];
					toSort[k]=temp;
				}
				else
				{
					toSort[j]=temp;
					break;
				}
				k--;
				j--;
			}
			
			System.out.println("pass "+i);
			for(int ii=0;ii<toSort.length;ii++)
				System.out.print(toSort[ii]+" ");
		}
		System.out.println("after"+toSort.toString());
		for(int i=0;i<toSort.length;i++)
			System.out.print(toSort[i]+" ");
		
	}
}

*/