package algorithm.topcoder.dynamic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class HandsShakingTests {
	private HandsShaking handsShaking = new HandsShaking();

	@Test
	public void testMaxDonations() {
		int n = 2;
		long result = handsShaking.countPerfect(n);
		assertTrue(1 == result);

		n = 4;
		result = handsShaking.countPerfect(n);
		assertTrue(2 == result);

		n = 8;
		result = handsShaking.countPerfect(n);
		assertTrue(14 == result);
	}
}
