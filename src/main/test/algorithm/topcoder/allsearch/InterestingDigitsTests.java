package algorithm.topcoder.allsearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class InterestingDigitsTests {
	private InterestingDigits interestingDigits = new InterestingDigits();

	@Test
	public void testDigits() {
		//첫번째 테스트
		int base = 10;
		int[] returns = {3, 9};
		int[] result = interestingDigits.digits(base);
		checkResult(result, returns);

		result = interestingDigits.digits2(base);
		checkResult(result, returns);

		//두번째 테스트
		base = 3;
		returns = new int[] {2};
		result = interestingDigits.digits(base);
		checkResult(result, returns);

		result = interestingDigits.digits2(base);
		checkResult(result, returns);

		//세번째 테스트
		base = 9;
		returns = new int[] {2, 4, 8};
		result = interestingDigits.digits(base);
		checkResult(result, returns);

		result = interestingDigits.digits2(base);
		checkResult(result, returns);

		//네번째 테스트
		base = 26;
		returns = new int[] {5, 25};
		result = interestingDigits.digits(base);
		checkResult(result, returns);

		result = interestingDigits.digits2(base);
		checkResult(result, returns);
	}

	private void checkResult(int[] results, int[] targets) {
		for (int i = 0; i < results.length; i++) {
			assertTrue(results[i] == targets[i]);
		}
	}
}
