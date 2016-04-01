package Practice;

public class Directory_Google {
	
	public static void main(String[] args)
	{
		String path = "dir1\n\tdir11\n\tdir12\n\t\timage1.jpeg\ndir2\n\tdir21\n\tdir22\n\timage2.jpeg\nimage3.jpeg";	
		
		String[] topLevel = path.split("\\n\\b");
		for(String level : topLevel)
		{
			if(level.contains(".jpeg"))
			{
				StringBuilder root = new StringBuilder();
				root.append("//");
				
				
			}
			
		}
	}

}
/*
dir1
	dir11
	dir12
		image1.jpeg
dir2
	dir21
	dir22
	image2.jpeg
image3.jpeg
*/