package Practice;

public class AmazonRutvik_4 {
	int count1=0,count2=0,count3=0;
	String top1 = null,top2=null,top3=null;
	//At any point of time, top1,top2 and top3 will give top3 video bieng viewed.
	public void videoViewed(String video)
	{
		
		if(video.equals(top1))
		{
			count1++;
			
		}
		else if(video.equals(top2))
		{
			count2++;
		}
		else if(video.equals(top3))
		{
			count3++;
		}
		else if(count1 == 0)
		{
			top1 = video;
			count1++;
		}
		else if(count2 == 0)
		{
			top2 = video;
			count2++;
		}
		else if(count3 == 0)
		{
			top3 = video;
			count3++;
		}
		else
		{
			count1--;
			count2--;
			count3--;
		}
	}

}

//You have streaming data for videos bieng viewed. Write algo to get top 3 videos at a time.

