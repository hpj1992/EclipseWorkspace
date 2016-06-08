package Uber;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class MySol {

}
/*class RateLimiter
{
 private static long duration = 1000000;
 private static int maxCount = 10;
 
 //Keeps a track of total counts made by specific user id
 HashMap<String,Integer> counts = new HashMap<String,Integer>(); 
 
 //Keeps a track when user requested specific ride. ArrayList will store each timestamp in order it was requested
 HashMap<String,ArrayList<Long>> requestTime = new HashMap<String,ArrayList<Long>>();
 
 public void applyPromoCode(String userId,String promoCode)
 {
     resetCountAndTime(userId);
     if(requestTime.containsKey(userId))
     {
         //User initiated request before. So  check for count and time
         int currentCount = counts.get(userId);
         ArrayList<Long> times = requestTime.get(userId);
         Long lastTime = times.get(0);
         Long currTime = new Date().getTime();
         if(Math.abs(lastTime-currTime) < duration)
         {
             // User requested within 1 hour. So check count
             int requestMade = counts.get(userId) + 1;
             if(requestMade > maxCount)
             {
                 System.out.println("BLOCKED");
             }
             else
             {
                 System.out.println("OK");
                 servePromoRequest(userId,promoCode);
             }
         }
         else
         {
             //this request is bigger than the difference.
        	 servePromoRequest(userId,promoCode);
             
         }
     
         
     }
     else
     {
         //Use rrequested first time . So serve it and log the timestamp and count.
         if(maxCount > 0)
         {
             Long currTime = new Date().getTime();
             ArrayList<Long> time = new ArrayList<Long>();
             time.add(currTime);
             requestTime.put(userId,time);
             counts.put(userId,1);
              System.out.println("OK");
         }
     }
 }
 
 public void servePromoRequest(String userId,String promoCode)
 {
                  Long currTime = (new Date()).getTime();
                 ArrayList<Long> time = requestTime.get(userId);
                  time.add(currTime);
                  
                 counts.put(userId,counts.get(userId)+1);
                 requestTime.put(userId,time);
 }
 
 public void resetCountAndTime(String userId)
 {
     ArrayList<Long> times = requestTime.get(userId);
     int count = 0;
     long lastTime = times.get(times.size()-1);
     ArrayList<Long> newTime = new ArrayList<Long>();
     // Remove the time which are not in the range of 1 hour.
     for(int i=0;i<times.size();i++)
     {
         long diff = Math.abs(lastTime-times.get(i));
         if(diff > duration)
         {
             count++;
         }
         else
         {
             newTime.add(times.get(i));
         }
     }
     
     requestTime.remove(userId);
     requestTime.put(userId,newTime);
     counts.put(userId,counts.get(userId)-count); // update the count for specific user
 }
 
}*/