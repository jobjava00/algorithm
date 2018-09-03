package algorithm.topcoder.allsearch;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by uienw on 2018-03-24.
 */
public class CrazyBotTests {
	private CrazyBot crazyBot = new CrazyBot();

	@Test
	public void testGetProbability(){
		int n = 1;
		int east = 25;
		int west = 25;
		int south = 25;
		int north = 25;

		double result = crazyBot.getProbability(n, east, west, south, north);
		assertTrue(result == 1.0);

		n = 2;
		east = 25;
		west = 25;
		south = 25;
		north = 25;

		result = crazyBot.getProbability(n, east, west, south, north);
		assertTrue(result == 0.75);

		n = 14;
		east = 50;
		west = 50;
		south = 0;
		north = 0;

		result = crazyBot.getProbability(n, east, west, south, north);
		assertTrue(result == 1.220703125E-4);
	}
}
