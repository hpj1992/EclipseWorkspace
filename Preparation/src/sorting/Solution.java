package sorting;

/*
you can try using this code to start and run some of your own tests
make sure that you do NOT submit this code otherwise your tests will fail.
also beware that iterators do not necessarily have to come from a backing list.
take time with your corner cases.
anonymous inner classes might help although you don't have to use it. 
NO need to support delete operation
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


 class Solution22 {
	public static ArrayList<String> result=new ArrayList<String>();
	public static void main(String args[]) throws Exception {
		
		List<Iterator<String>> lists = new ArrayList<>();
		lists.add(Arrays.asList("a", "b", "c").iterator());
		lists.add(null);
		lists.add(Arrays.<String>asList().iterator());
		lists.add(Arrays.asList("d", "e").iterator());
		lists.add(Arrays.<String>asList().iterator());
		
		Iterator<Iterator<String>> iters = lists.iterator();
		Iterator<String> flattened = flatten(iters);
		while (flattened.hasNext()) {
			System.out.println(flattened.next());
		}
	}

	public static Iterator<String> flatten(Iterator<Iterator<String>> iterators) {
		
		//Iterator<Stirng> =iterators.next();
		while(iterators!=null && iterators.hasNext())
		{
			Iterator<String> it=iterators.next();
			while(it!=null && it.hasNext())
			{
				result.add(it.next());
			}
			
			
		}
		
		/*for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}*/
		return result.iterator();
	}
}



/** @return Iterator which flattens the given arguments */
/*public static Iterator<String> flatten(Iterator<Iterator<String>> iters) {
		return new Iterator<String>() {	
			public boolean hasNext() {
				return false;
			}

			public String next() {
				return null;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
}*/