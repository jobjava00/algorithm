package algorithm.topcoder.dynamic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class BadNeighborsTests {
	private BadNeighbors badNeighbors = new BadNeighbors();

	@Test
	public void testMaxDonations() {
		int[] donations = { 10, 3, 2, 5, 7, 8 };

		int result = badNeighbors.maxDonations(donations);
		assertTrue(19 == result);

		donations = new int[] { 11, 15 };
		result = badNeighbors.maxDonations(donations);
		assertTrue(15 == result);

		donations = new int[] { 7, 7, 7, 7, 7, 7, 7 };
		result = badNeighbors.maxDonations(donations);
		assertTrue(21 == result);

		donations = new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		result = badNeighbors.maxDonations(donations);
		assertTrue(16 == result);

		donations = new int[] {
		        94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679,
		        4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47,
		        1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7,
		        36, 57, 86, 81, 72
		};
		result = badNeighbors.maxDonations(donations);
		assertTrue(2926 == result);
	}
}
