package leetcode;

public class ExcelSheetColumn {

	public static void main(String[] args)
	{
		System.out.println(ExcelSheetColumn.getColumnNumber("AAA"));
	}
	
	public static String getColumnName(int number)
	{
		StringBuilder sb = new StringBuilder();
		while(number!=0)
		{
			char ch = (char)(number%26+64);
			sb.append(ch);
			number = number/26;
		}
		return sb.toString();
	}
	public static int getColumnNumber(String s)
	{
		 double number = 0;
			for(int i=s.length();i>0;i--)
			{
				char ch = s.charAt(s.length()-i);
				int cur = ch - 64;
				number = number + (Math.pow(26,(i-1)))*cur;
			}
			return (int)number;
		
	}
}
