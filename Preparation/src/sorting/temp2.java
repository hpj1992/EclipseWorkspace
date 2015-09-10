package sorting;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class temp2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s=new Scanner(System.in);
        int total=s.nextInt();
        while(total>0){
            int length=(int)s.nextInt();
            String value=s.nextLine();
            int[] data=new int[length];
            int i=0;
            while(length>0){
                data[i]=(int)s.nextInt();
                i++;
                length--;
            }
            int ncSum=0,cSum=0;
            int[] sumStack=new int[data.length];
            sumStack[0]=0;
            for(int j=0;j<data.length;j++)
                {
                 if(data[j]>0){
                    ncSum+=(int)data[j];
                }
                 if(j<data.length-1){
                 	if(j==0)
                    cSum=(int)data[j]+(int)data[j+1];
                 	else
                 		cSum=cSum+(int)data[j+1];
                sumStack[j+1]=cSum;
                 }
                
                    
                 
            }
            for(int k=0;k<sumStack.length-1;k++)
                {
                if(sumStack[k]>sumStack[k+1])
                { cSum=sumStack[k];break;}
                else
                    cSum=sumStack[k+1];
            }
            if(ncSum==0)
            	ncSum=data[0];
               System.out.println(cSum+" "+ncSum);
            total--;
        }
    }
}