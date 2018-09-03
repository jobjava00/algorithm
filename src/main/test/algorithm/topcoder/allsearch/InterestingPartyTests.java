package algorithm.topcoder.allsearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class InterestingPartyTests {
	private InterestingParty interestingParty = new InterestingParty();

	@Test
	public void testBestInvitation() {
		//첫번째 테스트
		String[] first = { "fishing", "gardening", "swimming", "fishing" };
		String[] second = { "hunting", "fishing", "fishing", "biting" };

		int result = interestingParty.bestInvitation(first, second);
		assertTrue(4 == result);

		result = interestingParty.bestInvitation2(first, second);
		assertTrue(4 == result);

		//두번째 테스트
		first = new String[] { "variety", "diversity", "loquacity", "courtesy" };
		second = new String[] { "talking", "speaking", "discussion", "meeting" };

		result = interestingParty.bestInvitation(first, second);
		assertTrue(1 == result);

		result = interestingParty.bestInvitation2(first, second);
		assertTrue(1 == result);

		//세번째 테스트
		first = new String[] { "snakes", "programming", "cobra", "monty" };
		second = new String[] { "python", "python", "anaconda", "python" };

		result = interestingParty.bestInvitation(first, second);
		assertTrue(3 == result);

		result = interestingParty.bestInvitation2(first, second);
		assertTrue(3 == result);

		//네번째 테스트
		first = new String[] { "t", "o", "p", "c", "o", "d", "e", "r", "s", "i", "n", "g", "l", "e", "r", "o", "u", "n", "d", "m", "a", "t", "c", "h", "f", "o", "u", "r", "n", "i" };
		second = new String[] { "n", "e", "f", "o", "u", "r", "j", "a", "n", "u", "a", "r", "y", "t", "w", "e", "n", "t", "y", "t", "w", "o", "s", "a", "t", "u", "r", "d", "a", "y" };

		result = interestingParty.bestInvitation(first, second);
		assertTrue(6 == result);

		result = interestingParty.bestInvitation2(first, second);
		assertTrue(6 == result);
	}
}
