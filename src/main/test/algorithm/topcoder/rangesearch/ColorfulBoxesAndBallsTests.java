package algorithm.topcoder.rangesearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class ColorfulBoxesAndBallsTests {
	private ColorfulBoxesAndBalls colorfulBoxesAndBalls = new ColorfulBoxesAndBalls();

	@Test
	public void testGetMaximum() {
		int numRed = 2;
		int numBlue = 3;
		int onlyRed = 100;
		int onlyBlue = 400;
		int bothColors = 200;

		int result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		assertTrue(1400 == result);

		numRed = 2;
		numBlue = 3;
		onlyRed = 100;
		onlyBlue = 400;
		bothColors = 300;

		result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		assertTrue(1600 == result);

		numRed = 5;
		numBlue = 5;
		onlyRed = 464;
		onlyBlue = 464;
		bothColors = 464;

		result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		assertTrue(4640 == result);

		numRed = 1;
		numBlue = 4;
		onlyRed = 20;
		onlyBlue = -30;
		bothColors = -10;

		result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		assertTrue(-100 == result);

		numRed = 9;
		numBlue = 1;
		onlyRed = -1;
		onlyBlue = -10;
		bothColors = 4;

		result = colorfulBoxesAndBalls.getMaximum(numRed, numBlue, onlyRed, onlyBlue, bothColors);
		assertTrue(0 == result);
	}
}
