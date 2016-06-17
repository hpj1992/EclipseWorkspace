package leetcode.Easy;
public class LengthOfLastWord
{
public int lengthOfLastWord(String s) {
        if(s==null || s.length() == 0)
            return 0;
            int toReturn = 0;
            String[] splitted = s.split(" ");
            if(splitted.length > 0)
            toReturn = splitted[splitted.length-1].length();
        return toReturn;
    }

}