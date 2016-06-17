package leetcode.Easy;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String convertToTitle(int number) {
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			number--;
			char ch = (char) (number % 26 + 'A');
			sb.insert(0, ch);
			number = number / 26;
		}
		return sb.toString();
	}

}
