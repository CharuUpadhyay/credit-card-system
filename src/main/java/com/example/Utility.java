package com.example;

public final class Utility {

	/**
	 * @param number
	 * @return
	 */
	public static boolean isValidCard(String number) {
		if (number == null)
			return false;

		int numberOfDigits = number.length();
		int numberSum = 0;
		boolean skip = true;
		for (int i = numberOfDigits - 1; i >= 0; i--) {

			int digit = Character.getNumericValue(number.charAt(i));
			if (!skip)
				digit = digit * 2;

			numberSum += digit / 10;
			numberSum += digit % 10;

			skip = !skip;
		}

		return (numberSum % 10 == 0);
	}
}
