package Amazon;

import java.util.ArrayList;

public class GreyCode {

	public static void main(String[] args)
	{
		
	}
	
	public int generateGreyCode()
	{
		// term1 and term2 are subject to two BYTE
		// Code might not be working. Pass term1 and term2. Exact question is not known currently.
		byte term1 = 0,term2 = 0;
		byte X = ( byte ) (term1 ^ term2);
		 int Total =  0 ;
		 while (X !=  0 ) {
		    X = ( byte ) (X & (X -  1 ));
		    Total ++ ;
		}
		return Total == 1? 1 :0;
	}
	
	public static ArrayList<String> find(int n)
	{
		ArrayList<String> list=new ArrayList<String>();
		if(n==1)
		{
			list.add("0");
			list.add("1");
			return list;
		}
		
		ArrayList<String> ans=find(n-1);
		ArrayList<String> list1=new ArrayList<String>();
		for(int i=0;i<ans.size();i++)
		{
			String s=ans.get(i);
			list.add("0"+s);
			list1.add("1"+s);
		}
		
		for(int i=list1.size()-1;i>=0;i--)
		{
			list.add(list1.get(i));
		}
		return list;
	}
}
