package algorithm.topcoder.simulation;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class KiwiJuiceEasyTests {
	private KiwiJuiceEasy kiwiJuiceEasy = new KiwiJuiceEasy();

	@Test
	public void testThePouring() {
		//첫번째 테스트
		int[] capacities = { 20, 20 };
		int[] bottles = { 5, 8 };
		int[] fromId = { 0 };
		int[] toId = { 1 };
		int[] returns = { 0, 13 };

		int[] result = kiwiJuiceEasy.thePouring(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 5, 8 };
		result = kiwiJuiceEasy.thePouring2(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 5, 8 };
		result = kiwiJuiceEasy.thePouring3(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		//두번째 테스트
		capacities = new int[] { 10, 10 };
		bottles = new int[] { 5, 8 };
		fromId = new int[] { 0 };
		toId = new int[] { 1 };
		returns = new int[] { 3, 10 };

		result = kiwiJuiceEasy.thePouring(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 5, 8 };
		result = kiwiJuiceEasy.thePouring2(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 5, 8 };
		result = kiwiJuiceEasy.thePouring3(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		//세번째 테스트
		capacities = new int[] { 30, 20, 10 };
		bottles = new int[] { 10, 5, 5 };
		fromId = new int[] { 0, 1, 2 };
		toId = new int[] { 1, 2, 0 };
		returns = new int[] { 10, 10, 0 };

		result = kiwiJuiceEasy.thePouring(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 10, 5, 5 };
		result = kiwiJuiceEasy.thePouring2(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 10, 5, 5 };
		result = kiwiJuiceEasy.thePouring3(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		//네번째 테스트
		capacities = new int[] { 14, 35, 86, 58, 25, 62 };
		bottles = new int[] { 6, 34, 27, 38, 9, 60 };
		fromId = new int[] { 1, 2, 4, 5, 3, 3, 1, 0 };
		toId = new int[] { 0, 1, 2, 4, 2, 5, 3, 1 };
		returns = new int[] { 0, 14, 65, 35, 25, 35 };

		result = kiwiJuiceEasy.thePouring(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 6, 34, 27, 38, 9, 60 };
		result = kiwiJuiceEasy.thePouring2(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 6, 34, 27, 38, 9, 60 };
		result = kiwiJuiceEasy.thePouring3(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		//다섯번째 테스트
		capacities = new int[] { 700000, 800000, 900000, 1000000 };
		bottles = new int[] { 478478, 478478, 478478, 478478 };
		fromId = new int[] { 2, 3, 2, 0, 1 };
		toId = new int[] { 0, 1, 1, 3, 2 };
		returns = new int[] { 0, 156956, 900000, 856956 };

		result = kiwiJuiceEasy.thePouring(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 478478, 478478, 478478, 478478 };
		result = kiwiJuiceEasy.thePouring2(capacities, bottles, fromId, toId);
		checkResult(result, returns);

		bottles = new int[] { 478478, 478478, 478478, 478478 };
		result = kiwiJuiceEasy.thePouring3(capacities, bottles, fromId, toId);
		checkResult(result, returns);
	}

	private void checkResult(int[] results, int[] targets) {
		for (int i = 0; i < results.length; i++) {
			assertTrue(results[i] == targets[i]);
		}
	}
}
