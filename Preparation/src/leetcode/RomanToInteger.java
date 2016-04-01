package leetcode;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int romanToInt(String s) {

		if (s == null || s.length() == 0)
			return 0;

		char[] letters = s.toCharArray();
		int max = 0;
		int v = 1000;
		int ans = 0;

		for (int i = 0; i < letters.length; i++) {
			int value = getIntValue(letters[i]);
			if (value > v)
				max = max - v * 2;
			max = max + value;
			v = max;

		}
		return max;
	}

	public static int getIntValue(char ch) {

		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;

		}
		return 0;
	}
}
