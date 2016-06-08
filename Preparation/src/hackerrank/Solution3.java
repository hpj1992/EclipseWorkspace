package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int total = Integer.parseInt(s.nextLine());
		for (int i = 0; i < total; i++) {
			String[] matrix = s.nextLine().split(" ");

			int N = Integer.parseInt(matrix[0]);
			int M = Integer.parseInt(matrix[1]);
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			System.out.println(N + " " + M);
			for (int j = 0; j < N; j++) {
				// System.out.println(s.nextLine());
				String key = s.nextLine();
				if(!key.matches("^([0-9])\1*$"))
				{
					System.out.println("NO");
					break;
				}
				if(map.containsKey(key))
				{
					int index = map.get(key);
					if(Math.abs(j-index)>1)
					{
						map.put(key, j);
					}
					else
						{
							System.out.println("NO");
							break;
						}
				}
				else
				{
					map.put(key, j);
				}
			}
			
			System.out.println("YES");
		}
	}
}
