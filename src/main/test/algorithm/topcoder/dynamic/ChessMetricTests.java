package algorithm.topcoder.dynamic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class ChessMetricTests {
	private ChessMetric chessMetric = new ChessMetric();

	@Test
	public void testHowMany() {
		int size = 3;
		int[] start = {0, 0};
		int[] end = {1, 0};
		int numMoves = 1;
		long result = chessMetric.howMany(size, start, end, numMoves);
		assertTrue(1 == result);

		size = 3;
		start = new int[]{0, 0};
		end = new int[]{1, 2};
		numMoves = 1;
		result = chessMetric.howMany(size, start, end, numMoves);
		assertTrue(1 == result);

		size = 3;
		start = new int[]{0, 0};
		end = new int[]{2, 2};
		numMoves = 1;
		result = chessMetric.howMany(size, start, end, numMoves);
		assertTrue(0 == result);

		size = 3;
		start = new int[]{0, 0};
		end = new int[]{0, 0};
		numMoves = 2;
		result = chessMetric.howMany(size, start, end, numMoves);
		assertTrue(5 == result);

		size = 100;
		start = new int[]{0, 0};
		end = new int[]{0, 99};
		numMoves = 50;
		result = chessMetric.howMany(size, start, end, numMoves);
		assertTrue(243097320072600L == result);
	}
}
