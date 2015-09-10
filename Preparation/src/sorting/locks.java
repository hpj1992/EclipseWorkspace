package sorting;

import java.util.Stack;

public class locks
{
	
	public static Stack<String> stackLock=new Stack<String>();
	
    static int check_log_history(String[] events){
		int count=0;
		for(int i=0;i<events.length;i++)
		{
			String[] split=events[i].split(" ");
			String first=split[0];
			String second=split[1];
			
			if(first.equals("Acquire"))
			{
				if(stackLock.contains(second))
				{
					count++;
					return i+1;
					
				}
				else
					stackLock.push(second);
			}
			else if(first.equals("Release"))
			{
				if(!stackLock.contains(second))
					return i+1;
				else
				{
					if(stackLock.peek().equals(second))
						stackLock.pop();
					else
						return i+1;
				}
			}
		}
		
		if(stackLock.size()>0)
			return count+1;
		
		return 0;
		
		
	}

	
	public static void main(String[] args)
	{
		
		System.out.println("fssfs");
		String[] str={
				
				"Acquire 364","Acquire 84","Release 364","Release 84"	};
		System.out.println(check_log_history(str));
		
	}
	
}

