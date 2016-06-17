package leetcode.Medium;

//Implement pow(x, n).
public class PowXN {

	public static void main(String[] args) {
		System.out.println(getPower(5, 5));
	}

	// Recursive
	public static double getPower(int base, int power) {
		double temp = base;
		if (power == 0)
			return 1;
		temp = getPower(base, power / 2);

		if (power % 2 == 0) {
			return temp * temp;
		} else {
			if (power > 0) {
				return base*temp*temp;
			} else {
				return temp*temp/base;
			}
		}
	}

	// Iterative
	public static double getPower2(int base, int power) {
		double result = 1;
		while (power != 0) {
			if (power % 2 == 0) {
				base = base * base;
				power = power / 2;
			} else {
				if (power > 0) {
					result = result * base;
					power--;
				} else {
					result = result / base;
					power++;
				}
			}
		}
		return result;
	}
}
