package ctci;

 public class Sol1_7 {
	 
	 int row_o=0;
	 int col_o=0;
	 int m_len;
	 int c_len;
	 
	 
	 public static void main(String[] args)
	 {
		// int[][] mat= {{1,2,3},{4,5,6},{7,8,9}};
		 int[][] mat={{1,2,3,11,111},{4,5,6,22,222},{7,8,9,33,333},{10,11,12,44,444},{13,14,15,55,555}};
		 
		 for(int i=0;i<mat.length;i++)
		 {
			 for(int j=0;j<mat[i].length;j++)
			 {
				 System.out.print(mat[i][j]+" ");
			 }
			 System.out.println(); 
		 }
		 System.out.println("after");
		 new Sol1_7().rotateClockWise(mat);
		
	 }
	 
	 public  void rotateClockWise(int[][] mat)
	 {
		 int length=mat.length;
		 m_len=length;
		 c_len=length-1;
		 System.out.println("mlen"+m_len);
		 System.out.println("clen"+c_len);
		 int layer=m_len/2;
		 for(int k=0;k<layer;k++)
		 {
			 
			 col_o=k;
			 row_o=k;
			int  m=row_o;
			 System.out.println("col_o"+col_o+" row_o"+row_o+" c_len"+c_len);
			// for(int m=row_o;m<c_len;++m)
			// 
			// {
				 for(int n=col_o;n<(c_len-row_o);++n)
				 {
					int temp=mat[m][n];
					mat[m][n] =mat[c_len-n][m];
					mat[c_len-n][m]=mat[c_len-m][c_len-n];
					mat[c_len-m][c_len-n]=mat[n][c_len-row_o];
					mat[n][c_len-row_o]=temp;
				 }
				 System.out.println("result:");
				 for(int i=0;i<mat.length;i++)
				 {
					 for(int j=0;j<mat[i].length;j++)
					 {
						 System.out.print(mat[i][j]+" ");
					 }
					 System.out.println("");
				 }
				 System.out.println("------------");
			// }
			 
			//c_len--;
		 }
	 }
	

}
 /*
  * int temp=mat[m][n];
					mat[m][n] =mat[c_len-row_o-n][col_o];
					mat[c_len-row_o-n][col_o]=mat[c_len-row_o][c_len-col_o-n];
					mat[c_len-row_o][c_len-col_o-n]=mat[row_o+n][c_len-col_o];
					mat[row_o+n][c_len-col_o]=temp;*/
