package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dna {

	public static void main(String[] args) {
int[] count=new int[4];
double[][] data= new double[4][9];



FileInputStream fstream;
char[][] seq=new char[10][];
try {
	fstream = new FileInputStream(new File("D://workspaceLuna//Preparation//src//sorting//dna.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

	String strLine;
	int i=0;
	//Read File Line By Line
	while ((strLine = br.readLine()) != null)   {
	  // Print the content on the console
		
	  System.out.println (strLine);
	  char[] arr=strLine.toCharArray();
	  seq[i]=arr;
	  i++;
	}

	//Close the input stream
	br.close();

} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

char[] preset= {'A','G','C','T'};
/*for(int i=0;i<seq.length;i++)

{

for(int j=0;j<seq[i].length;j++)

{

System.out.print(seq[i][j]);

}

System.out.println();

}*/
System.out.println();
System.out.println("Position weight matrix:");

for(int m=0; m<9; m++)
{
 for(int n=0; n<seq.length; n++)
 {
	 char c= seq[n][m];
	 for(int k=0; k<4; k++)
	 {
		 if(c==preset[k])
		 {
			 count[k]++;
		 }
	 }
 }
 for(int t=0; t<4; t++)
 {
	 data[t][m]=(count[t]+ 0.1)/(10.4);
 }
 for(int c=0;c<4;c++)
 {
	 count[c]=0;
 }
}

for(int x=0; x<data.length;x++)
{
	for(int y=0; y<data[x].length;y++)
	{
		System.out.print("   "+data[x][y]);
	}
	System.out.println();
}
System.out.println();
for(int a=0; a<4;a++)
{
	for(int b=0; b<9; b++)
	{
		data[a][b]=Math.log(data[a][b]/0.25);
	}
		}
System.out.println("PWM in log-odds:");
for(int x=0; x<data.length;x++)
{
	for(int y=0; y<data[x].length;y++)
	{
		System.out.print( "     "+data[x][y]);
	}
	System.out.println();
}
double sum=0;
char[] arr1={'C','G','T','G','A','G','G','A','A'};
char[] arr2={'A','C','C','G','T','C','G','A','C'};

double sum1=getSum(arr1,preset,data);
double sum2=getSum(arr2,preset,data);
System.out.println();
System.out.println("CGTGAGGAA:"+sum1);
System.out.println("ACCGTCGAC:" +sum2);
}



public static double getSum(char[] arr,char[] preset,double[][] data)
{
	double sum=0;
	for(int p=0; p<arr.length; p++)
	{
		for(int q=0; q<preset.length; q++)
		{
			if(arr[p]==preset[q])
			{
				sum=sum + data[q][p];
			}
		}
			
	}
	return sum;
}
			
}		

