package leetcode.Medium;
import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		System.out.println(getPermutation(3, 5));
		System.out.println(getPermutation2(3, 5));
	}

	public static String getPermutation2(int n, int k)
	{
		int sum =1 ;
		int[] factorials = new int[n+1];
		factorials[0] = 1;
		for(int i=1;i<= n;i++)
		{
			sum *=i;
			factorials[i] = sum;
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=1;i<=n;i++)
		{
			arr.add(i);
		}
		StringBuilder sb = new StringBuilder();
		k--;
		for(int i=1;i<=n;i++)
		{
			int index = k/factorials[n-i];
			sb.append(arr.get(index).toString());
			arr.remove(index);
			k = k - index*factorials[n-i];
		}
		return sb.toString();
	}
	
	
	public static String getPermutation(int n, int k) {

		String one = "";
		for (int i = 1; i <= n; i++)
			one += i;

		List<String> all = getAllPermutations(one);
		return all.get(k - 1);
	}

	public static List<String> getAllPermutations(String value) {
		if (value == null || value.length() == 0) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(" ");
			return temp;
		}
		char cur = value.charAt(0);
		ArrayList<String> previousAll = (ArrayList<String>) getAllPermutations(value
				.substring(1, value.length()));
		ArrayList<String> ans = new ArrayList<String>();

		for (String str : previousAll) {
			for (int i = 1; i <= str.length(); i++) {
				String e = str.substring(0, i) + cur
						+ str.substring(i, str.length());
				ans.add(e);
			}
		}
		return ans;
	}

}
