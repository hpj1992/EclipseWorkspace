package Uber;

//This is the text editor interface. 
//Anything you type or change here will be seen by the other person in real time.

import java.util.*;
class IP
{
 int[] address;
 private String getIp()
 {
     return address[0]+"."+address[1]+"."+address[2]+"."+address[3];
 }
 
 @Override
 public boolean equals(Object o)
 {
     return this.getIp().equals(((IP)o).getIp());
 }
 
 
 public int hashcode()
 {
     return this.getIp().hashCode();
 }
}

class RateLimiter
{
 
 //Keeps a track of count for particular IP
 HashMap<IP,Integer> counts = new HashMap<IP,Integer>();
 
 //Keeps a track of time in milliseconds for the first time requst from specific IP wad received
 HashMap<IP,Long> firstRequest = new HashMap<IP,Long>();
 
 private static Integer expiry = 60000;
 
 public static void main(String[] args)
 {
     Date d = new Date();
     System.out.println(d.getTime());
 }
 
 public void serve(IP request)
 {
	 
	 if(counts.containsKey(request))
	 {
		 Long firstTime = firstRequest.get(request);
		 Long current = new Date().getTime();
		 if(Math.abs(current-firstTime) > expiry)
		 {
			 //Not allowed further
		 }
		 else
		 {
			 counts.put(request, counts.get(request) + 1);
			 //Serve the request
		 }
	 }
 }
 
 public void flushOldRequests()
 {
	 for(IP ip : firstRequest.keySet())
	 {
		 Long curr = (new Date()).getTime();
		 Long value = firstRequest.get(ip);
		 if(Math.abs(value-curr) > expiry)
		 {
			 counts.remove(ip);
		 }
	 }
 }
 
}