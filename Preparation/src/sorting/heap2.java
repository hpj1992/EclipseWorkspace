/*
 * Java Program to Implement Heap Sort
 */
 package sorting;
import java.util.Scanner;
 
/* Class HeapSort */
public class heap2 
{    
    private static int N;
    /* Sort Function */
    public static void sort(int arr[])
    {       
        heapify(arr); 
        for(int i=0;i<arr.length;i++)
        {
        	System.out.print(arr[i]);
        }
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    }     
    /* Function to build a heap */   
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
        {    maxheap(arr, i);
        for(int r=0;r<arr.length;r++)
			System.out.print(arr[r]+" ");
		System.out.println();
        }
    }
    /* Function to swap largest element in heap */        
    public static void maxheap(int arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }    
    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    
    /* Main method */
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner( System.in );        
        System.out.println("Heap Sort Test\n");
        int n, i;    
        int arr[]={6, 5, 3, 1, 8, 7, 2,4};
        n=arr.length;
        sort(arr);
        /* Print sorted Array */
        System.out.println("\nElements after sorting ");        
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");            
        System.out.println();            
    }    
}