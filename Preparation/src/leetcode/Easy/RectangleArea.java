package leetcode;

public class RectangleArea {

	public static void main(String[] args)
	{
		
	}
	
	public static int getRectangeleArea(int A,int B,int C,int D,int E,int F,int G,int H)
	{
		int common = 0;
		if(G <= A || E >= C || F >= D || H <= B)
		{
			//not oerlapping
			common = 0;
		}
		else
		{
			int x = Math.min(G,C) - Math.max(A, E);
			int y = Math.min(D,H) - Math.max(B,F);
			common = x*y;
		}
		return (C-A)*(D-B) + (G-E)*(H-F) - common;
	}
	/*
	 * int together;
        if (C <= E || A >= G || B >= H || D <= F) {
            together = 0;
        } else {
            int x = Math.min(C, G) - Math.max(A, E);
            int y = Math.min(D, H) - Math.max(B, F);
            together = x * y;
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - together;
	 */
}
