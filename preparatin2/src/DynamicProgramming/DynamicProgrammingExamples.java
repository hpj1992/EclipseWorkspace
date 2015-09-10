package DynamicProgramming;


import java.util.ArrayList;
import java.util.List;
public class DynamicProgrammingExamples {
	
	//-----------------------------------------------------------------------------------------------------
	// Given n steps, a child can climb 1,2 or 3 at a time. Count no of ways to climb the stairs.
	
	static int countWays(int noOfStairs, int[] map){
		if(noOfStairs < 0)
			return 0;
		else if(noOfStairs == 0)
			return 1;
		else{
			map[noOfStairs] = countWays(noOfStairs-1, map)+
								countWays(noOfStairs-2, map)+
								countWays(noOfStairs-3, map);
			return map[noOfStairs];
		}
		
	}
	
	//-----------------------------------------------------------------------------------------------------
	// Find all subsets of the given set O(2^n) time and space

	static List<List<Integer>> getAllSubsets(List<Integer> set){
		List<List<Integer>> allSubsets = new ArrayList<>();
		if(set.size() == 0){
			List<Integer> emptySet = new ArrayList<>();
			allSubsets.add(emptySet);
		}else{
			int lastIndex = set.size()-1;
			int lastItem = set.get(lastIndex);
			set.remove(lastIndex);
			allSubsets = getAllSubsets(set);
			
			List<List<Integer>> moreSubsets = new ArrayList<>();
			for(List<Integer> subSet : allSubsets){
				List<Integer> newSet = new ArrayList<>();
				newSet.addAll(subSet);
				newSet.add(lastItem);
				
				moreSubsets.add(newSet);
			}
			allSubsets.addAll(moreSubsets);
		}
		
		return allSubsets;
	}
	
	//-----------------------------------------------------------------------------------------------------
	// Print all valid combination of n - pairs of parenthesis
	
	static void createPairs(List<String> pair, char[] str, int leftRem, int rightRem, int count){
		if(leftRem < 0 || rightRem < 0 || rightRem < leftRem)
			return;
		
		if(leftRem == 0 && rightRem == 0){
			pair.add(String.copyValueOf(str));
		}else{
			if(leftRem > 0){
				str[count] = '(';
				createPairs(pair, str, leftRem-1, rightRem, count+1);
			}
			
			if(rightRem > leftRem){
				str[count] = ')';
				createPairs(pair, str, leftRem, rightRem-1, count+1);
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------------------
	// Given N*M matrix of color, implement paintFill method which will change the color with new color till 
	// it's able to find pixcel with new color
	
	enum Color{
		Black, White, Orange, Green, Blue;
	}
	
	static boolean paintFill(Color[][] screen, int x, int y, Color oColor, Color newColor){
		if(x<0 || x>= screen[0].length || y <0 || y>= screen.length)
			return false;
		
		if(screen[y][x] == oColor){
			screen[y][x] = newColor;
			paintFill(screen, x+1, y, oColor, newColor);
			paintFill(screen, x-1, y, oColor, newColor);
			paintFill(screen, x, y+1, oColor, newColor);
			paintFill(screen, x, y-1, oColor, newColor);
		}
		return true;
	}
	
	//-----------------------------------------------------------------------------------------------------
	// No of ways to Make change using the given coins for the fiven amount
	 
	static int makeChange(int amount, int denom){
		int nextDenom = 0;
		switch(denom){
		case 25:
			nextDenom = 10;
			break;
			
		case 10:
			nextDenom = 5;
			break;
			
		case 5:
			nextDenom = 1;
			break;
			
		case 1:
			return 1;
		}
		
		int ways = 0;
		for(int i = 0; i*denom <= amount; i++){
			ways += makeChange(amount - i*denom, nextDenom);
		}
		return ways;
	}
	
	//-----------------------------------------------------------------------------------------------------
	// 8 queens problem
	static int GRID_SIZE = 8;
	
	static boolean checkValid(Integer[] columns, int newRow, int newCol){
		for(int oldRow = 0; oldRow < newRow; oldRow++){
			int oldCol = columns[oldRow];
			
			if(oldCol == newCol)
				return false;
			
			int columnDistance = Math.abs(newCol - oldCol);
			int rowDistance = newRow - oldRow;
			
			if(columnDistance == rowDistance)
				return false;
		}
		return true;
	}
	static int count = 1;
	static void printPositions(Integer[] columns){
		System.out.println("Result No: "+count);
		count++;
		for(int i = 0; i< columns.length; i++){
			System.out.println("("+i+" , "+columns[i]+")");
		}
		System.out.println();
	}
	
	static void placeQueen(int row, Integer[] columns){
		if(row == GRID_SIZE){
			printPositions(columns);
		}else{
			for(int col = 0; col<GRID_SIZE; col++){
				if(checkValid(columns, row, col)){
					columns[row] = col;
					placeQueen(row+1, columns);
				}
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------------------
	
	public static void main(String[] args){
		
		/*int noOfStairs = 30;
		int[] map = new int[noOfStairs+1];
		System.out.println(""+countWays(noOfStairs, map));*/
		
		/*List<Integer> set = new ArrayList<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		List<List<Integer>> result = getAllSubsets(set);
		for(List<Integer> subSet: result){
			System.out.println(subSet.toString());
		}*/
		
		/*int noOfPairs = 3;
		char[] str = new char[noOfPairs*2];
		List<String> list = new ArrayList<>();
		createPairs(list, str, noOfPairs, noOfPairs, 0);
		System.out.println(list.toString());
		*/
		Color[][] screen = new Color[100][100];
		int x=10,  y = 10;
		Color newColor = Color.Blue, oldColor = Color.Green;
		if(screen[y][x] == newColor){
			System.out.println("ALready Painted");
		}else{
			paintFill(screen, x, y, oldColor, newColor);
		}
		
		System.out.println("No of way to make chang: "+makeChange(10, 5));
		
		placeQueen(0, new Integer[GRID_SIZE]);
		
	}
	
}
