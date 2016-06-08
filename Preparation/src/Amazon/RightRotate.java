package Amazon;

//Given two strings. Check whether one string is rotation of other or not.

public class RightRotate {

	public static int isRotate(String str1, String str2)
	{
		// -1 : Not a rotation. 1 = is a rotation.
		if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
			return -1; 
		String temp = str1 + str1;
		return temp.contains(str2) ? 1  : -1; 
	}
}
