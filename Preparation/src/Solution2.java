
public class Solution2 {

	public static void main(String[] args)
	{
		System.out.println(getCompressesString("aaaaabbbbbbbbbccccdeeeeeee"));;
	}
	
	public static String getCompressesString(String str)
	{
		if(str != null & str.length() != 0)
		{
			char[] arr = str.toCharArray();
			int count = 1;
			char prev = arr[0];
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<arr.length;i++)
			{
				if(arr[i] == prev)
					count++;
				else
				{
					sb.append(prev);
					if(count != 1)
					sb.append(count);
					prev = arr[i];
					count = 1;
				}
			}
			sb.append(prev);
			if(count != 1)
			sb.append(count);
			return sb.toString();
		}
		return "";
	}
}
