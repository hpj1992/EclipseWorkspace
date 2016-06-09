package leetcode;

public class CountAndSay
{
public String countAndSay(int n) {
         if(n==0 || n==1)
            return "1";
        String prev = "1";
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=n;i++)
        {
            for(char ch:prev.toCharArray())
            {
                if(sb.length() > 0 && ch==sb.charAt(sb.length()-1))
                {
                    char count = sb.charAt(sb.length()-2);
                    sb.setCharAt(sb.length()-2,(char)(count+1));
                }
                else
                {
                    sb.append("1");
                    sb.append(ch);
                }
            }
            prev = sb.toString();
            sb = new StringBuilder();

        }
        return prev;
    }
}