package Amazon;

public class OverlapRactangel {

	// Given two rectangles, find if the given two rectangles overlap or not.
	/*
	 * l1: Top Left coordinate of first rectangle. r1: Bottom Right coordinate
	 * of first rectangle. l2: Top Left coordinate of second rectangle. r2:
	 * Bottom Right coordinate of second rectangle.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Returns true if two rectangles (l1, r1) and (l2, r2) overlap
	boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
		// If one rectangle is on left side of other
		if (l1.x > r2.x || l2.x > r1.x)
			return false;

		// If one rectangle is above other
		if (l1.y < r2.y || l2.y < r1.y)
			return false;

		return true;
	}
}