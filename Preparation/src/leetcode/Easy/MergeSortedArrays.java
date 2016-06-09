package leetcode;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
        	return;
        else
        {
        	  int i  = m + n -1;
              m--;
              n--;
                  while(m >=0 && n >= 0)
                  {
              		nums1[i--] = (nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
                  }
                  	while(n >= 0)
              		nums1[i--] = nums2[n--];
        }
	}

}
/*
//This is the text editor interface. 
//Anything you type or change here will be seen by the other person in real time.

//X requests over Y amount of time
//100 requests over 1 hour
//500 requests over 10 minutes
//5 requests in 1 second
/* endpoint to apply promotion to your account - (string promo_code, string user_id)
3 requests in 1 hour
3:00pm - 1 request - OK
3:15pm - 1 request - OK
3:30pm - 1 request - OK
3:45pm - 1 request - NOT SERVED
4:01pm - 1 request - OK
4:10pm - 1 request - BLOCKED
4:16pm - 1 request - OK
*/
//10 requests per 10 minute
