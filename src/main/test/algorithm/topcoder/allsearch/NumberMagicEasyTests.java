package algorithm.topcoder.allsearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class NumberMagicEasyTests {
	private NumberMagicEasy numberMagicEasy = new NumberMagicEasy();

	@Test
	public void testEncrypt() {

		String answer = "YNYY";
		int result = numberMagicEasy.theNumber(answer);
		assertTrue(5 == result);

		result = numberMagicEasy.theNumber2(answer);
		assertTrue(5 == result);

		result = numberMagicEasy.theNumber3(answer);
		assertTrue(5 == result);


		answer = "YNNN";
		result = numberMagicEasy.theNumber(answer);
		assertTrue(8 == result);

		result = numberMagicEasy.theNumber2(answer);
		assertTrue(8 == result);

		result = numberMagicEasy.theNumber3(answer);
		assertTrue(8 == result);


		answer = "NNNN";
		result = numberMagicEasy.theNumber(answer);
		assertTrue(16 == result);

		result = numberMagicEasy.theNumber2(answer);
		assertTrue(16 == result);

		result = numberMagicEasy.theNumber3(answer);
		assertTrue(16 == result);


		answer = "YYYY";
		result = numberMagicEasy.theNumber(answer);
		assertTrue(1 == result);

		result = numberMagicEasy.theNumber2(answer);
		assertTrue(1 == result);

		result = numberMagicEasy.theNumber3(answer);
		assertTrue(1 == result);


		answer = "NYNY";
		result = numberMagicEasy.theNumber(answer);
		assertTrue(11 == result);

		result = numberMagicEasy.theNumber2(answer);
		assertTrue(11 == result);

		result = numberMagicEasy.theNumber3(answer);
		assertTrue(11 == result);
	}
}
