package Amazon;

import java.util.TreeMap;

public class KNearestPoints {

	/*
	 * 
down vote
What is wrong with below approach ?

1) Calculate distance from given point to other points.

2) Store the distance and index of that point to TreeMap<Double,Integer> map

3) Select top K elements from map. It's values will give index of Point element from points array.

	 */
	public static void main(String[] args)
	{
		
	}
	/*public Point[] gerKNearestPoints(Point[] points, int k, Point origin)
	{
		TreeMap<Double,Integer> map = new TreeMap<Double, Integer>();
	}*/
	
}

class Point{
	int x;
	int y;
	
	// this is the constructor for the Point class
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}
