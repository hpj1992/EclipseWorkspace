package sorting;

import java.util.Scanner;

public class CaterPillar {

	/**
	 * @param args
	 */
	private static int getUneatenLeaves(int n, int k) {
		Scanner in = new Scanner(System.in);
		int[] val = new int[k];
		for(int i=0; i<k; i++) {
			val[i] = Integer.parseInt(""+in.nextLine());
		}
		
		 int cnt = 0;
	        int h=1;
	            int e=n/2;
			while(e<=n)
	            {
	            h=e-(n/2)+1;
	        boolean[] flag = new boolean[n/2];
			for(int i=0; i	< val.length ; i++) {
				for(int j= h; j <= e ; j++) {
					if(j%val[i] == 0) {
						if(!flag[j-1]) {
							flag[j-1] = true;
							cnt++;
						}
					}
				}
				
			}
	            e=e+n/2;
	        }
			//return n - cnt;
		in.close();
		return n - cnt;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(""+in.nextLine());
		int k = Integer.parseInt(""+in.nextLine());
		int cnt = 0;
		
		if(n > 0 && n <= 1000000000 && k > 0 && k <= 15)
			cnt = getUneatenLeaves(n,k);

		System.out.println(cnt);
		in.close();
	}

}