package Practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
/*
 * Input
 * 9
MERVIN:865965036
BOUCK,MERVIN:865965036
MERVIN BOUCK:865965036
BOUCK,MERVIN ADELINE:865965036
MERVIN ADELINE BOUCK:865965036
LEN:992989227
GERALD:358648156
BYER,GERALD:358648156
GERALD BYER:358648156
 */
public class Solutions {

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		String line = "";

		Scanner s = new Scanner(System.in);
		int count = Integer.valueOf(s.nextLine());
		LinkedHashMap<Integer, String> ans = new LinkedHashMap<Integer, String>();
		while (count > 0) {
			line = s.nextLine();
			String[] nameSSN = line.split(":");
			String name = nameSSN[0];
			int ssn = Integer.valueOf(nameSSN[1]);
			if (ans.containsKey(ssn)) {
				ans.remove(ssn);
			}
			if (isValid(name)) {
				ans.put(ssn, name);
			}
			count--;
		}
		for (Integer ssn : ans.keySet()) {
			System.out.println(ans.get(ssn) + ":" + ssn);
		}
	}

	public static boolean isValid(String name) {
		return (name.matches("\\w*,?\\w* ?\\w*")
				|| name.matches("\\w* ?\\w* ?\\w*") || name
					.matches("\\w* ?\\w* ?\\w*"));
	}
}
