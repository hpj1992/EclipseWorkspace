package Practice;

import java.util.HashMap;
import java.util.Map;

public class PatternMatchingDropbox {

	public static void main(String[] args) {
		System.out.println(isMatched("abab", "harshitjoshiharshitjoshi"));
	}

	public static boolean isMatched(String pattern, String input) {
		return recursionMatch(pattern.toCharArray(), 0, input.toCharArray(), 0,
				new HashMap<Character, String>());

	}

	private static boolean recursionMatch(char[] patternTill, int patternStartIndex,
			char[] input, int inputStartIndex, Map<Character, String> total) {
		boolean finishedPattern = patternStartIndex >= patternTill.length;
		boolean finishedInput = inputStartIndex >= input.length;
		if (finishedInput && finishedPattern) {
			return true;
		} else if (finishedInput ^ finishedPattern) {
			return false;
		}

		char newCharacterInPattern = patternTill[patternStartIndex];

		// if the next character in pattern is already defined, check its
		// definition as prefix of the input
		if (total.containsKey(newCharacterInPattern)) {
			String newStringPattern = total.get(newCharacterInPattern);

			if (inputStartIndex + newStringPattern.length() - 1 >= input.length) {
				return false;
			}

			for (int i = 0; i < newStringPattern.length(); i++) {
				if (newStringPattern.charAt(i) != input[inputStartIndex + i]) {
					return false;
				}
			}

			return recursionMatch(patternTill, patternStartIndex + 1, input, inputStartIndex
					+ newStringPattern.length(), total);
		} else {
			StringBuilder builder = new StringBuilder();

			// try all possible definition of the current character in the
			// pattern
			for (int i = inputStartIndex; i < input.length; i++) {
				builder.append(input[i]);

				String newDef = builder.toString();

				// make sure the definition is distinct
				if (!total.containsValue(newDef)) {
					total.put(newCharacterInPattern, newDef);

					boolean isMatch = recursionMatch(patternTill, patternStartIndex + 1,
							input, inputStartIndex + newDef.length(), total);
					if (isMatch) {
						return true;
					}

					// Backtrack if not
					total.remove(newCharacterInPattern);
				}
			}

			return false;
		}
	}
}
