import java.util.Scanner;

public class NumberToWordConverter {
	public static void main(String[] args) {
		int number = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type a number(max upto 9 digits)");
		try {
			if (number == 0) {
				System.out.print("Number in words: Zero");
			} else {
				System.out.print("Number in words:" + word(number));
			}
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
		}

		scanner.close();
	}

	private static String word(int number) {

		String words = "";
		String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
				"ninety" };

		if (number == 0) {
			return "zero";
		}

		if (number < 0) {
			// convert the number to a string
			String numberStr = "" + number;
			// remove minus before the number
			numberStr = numberStr.substring(1);
			// add minus before the number and convert the rest of number
			return "minus " + word(Integer.parseInt(numberStr));
		}
		// check if number is divisible by 1 million
		if ((number / 1000000) > 0) {
			words += word(number / 1000000) + " million ";
			number %= 1000000;
		}
		if ((number / 1000) > 0) {
			words += word(number / 1000) + " thousand ";
			number %= 1000;
		}
		// check if number is divisible by 1 hundred
		if ((number / 100) > 0) {
			words += word(number / 100) + " hundred ";
			number %= 100;
		}
		if (number > 0) {
			// check if number is within teens
			if (number < 20) {
				// fetch the appropriate value from unit array
				words += unitsArray[number];
			} else {
				words += tensArray[number / 10];
				if ((number % 10) > 0) {
					words += "-" + unitsArray[number % 10];
				}

			}
		}
		return words;
	}
}