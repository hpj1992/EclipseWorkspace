package sorting;

//file:    bucketsort.java
//author:  Robert Keller
//purpose: illustrating a very fast sorting program for natural numbers in
//       a reasonably small range only
//
//       bucketsort works as follows: The minimum and maximum of the 
//       range of numbers is found.  Then an array of "buckets" is 
//       allocated for each integral value between the minimum and
//       maximum inclusive.  The number of each value in the original
//       array is counted by one pass over the latter, using the datum
//       as an index into the bucket array.
//
//       This method is O(N) where N is the number of elements to be sorted;
//       a prime example of the use of the linear-addressing principle.
//
//       If the range of numbers is to large, the bucket array can't be
//       allocated and the method will fail.

import java.lang.*;
import java.io.*;
import java.util.*;

class bucket
{
/**
 *  Calling bucketsort constructor on array of floats sorts the array.
 *  Parameter N is the number of elements to be sorted.
**/

bucket(int array[], int N)
 {
 if( N <= 0 )
   return;                                   // Case of empty array

 int min = array[0];
 int max = min;
 for( int i = 1; i < N; i++ )                // Find the minimum and maximum
   if( array[i] > max )
     max = array[i];
   else if( array[i] < min )
     min = array[i];

 int bucket[] = new int[max-min+1];          // Create buckets
 
 for( int i = 0; i < N; i++ )                // "Fill" buckets
   bucket[array[i]-min]++;                   // by counting each datum

 int i = 0;                                  
 for( int b = 0; b < bucket.length; b++ )    // "Empty" buckets
   for( int j = 0; j < bucket[b]; j++ )      // back into array
     array[i++] = b+min;                     // by creating one per count
 }


/**
 *  test program for bucketsort; reads arbitrarily-many numbers 
 *  from standard input, sorts them, then writes them to standard output.
**/


/**
 * @param args
 */
public static void main(String[] args)
 {
 StreamTokenizer in = new StreamTokenizer(System.in);
System.out.println("hi");
 int Size = 1;                       // initial allocation
 int N = 0;                          // number of elements in array
 int array[] = {9,8,7,6,5,4,3,2,1,0,3,51,0,3,5,9,8,7,1,5,6,9,8,129,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,129,8,7,6,5,4,3,2,1,0,3,5,9,8,7,1,5,6,9,8,12};        // initial array allocation
 N=array.length;
/* try
   {
   // while more numbers in file
   while( in.nextToken() != java.io.StreamTokenizer.TT_EOF ) 
     {
     if( N == Size )                 // if the array is full
       {
       array = reallocate(array);    // int the array size
       Size *= 2;    
       }
     array[N++] = (int)in.nval;      // put item in array
     }
   }
 catch(IOException e)
   {
   System.err.println("*** IOException caught");
   }
*/
 Date startTime = new Date();
 System.out.println(startTime);
 System.err.println("Sorting started");

 new bucket(array, N);		// calling constructor sorts

 
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Date endTime = new Date();
System.out.println(endTime);
 long time = endTime.getTime() - startTime.getTime();

 System.err.println("Sorting finished in " + time + " ms");

 for( int i = 0; i < N; i++ )
   {
   System.out.print(array[i] + " ");
   }    

 System.out.println();

 System.err.println("Sorting " + N + " elements using bucketsort took " + 
                     time + " ms");
 }


/**
 *  reallocate allocates a new array int the size of the original
 *  and copies the original into it.  The new array is returned.
**/

static int[] reallocate(int array[])
 {
 int[] newArray = new int[2*array.length];
 for( int i = 0; i < array.length; i++ )             // copy old array
   newArray[i] = array[i];    
 return newArray;
 }
}