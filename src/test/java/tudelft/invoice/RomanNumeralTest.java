package tudelft.invoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tudelft.roman.RomanNumeral;

public class RomanNumeralTest {

	@Test
	void singleDigit() {
		String input = "I";

		int result = new RomanNumeral().parse(input);

		Assertions.assertEquals(1, result);

	}

	@Test
	void twoDigits() {
		String input = "II";

		int result = new RomanNumeral().parse(input);

		Assertions.assertEquals(2, result);
	}

	@Test
	void subtractiveNotation() {
		String input = "IV";

		int result = new RomanNumeral().parse(input);

		Assertions.assertEquals(4, result);
	}
}
