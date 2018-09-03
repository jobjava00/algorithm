package algorithm.topcoder.dynamic;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class KnapsackTests {

	@Test
	public void testKnapsack() {
		int nowNum = 3;	//현재 보고 있는 물건 번호 = 총 5개의 물건이 있으므로 3번째 물건부터 4,5번째 물건을 넣는다
		int nowWeight = 1;	//현재 가지고 있는 무게
		int nowP = 2; //현재 가지고 있는 가치
		Knapsack knapsack = new Knapsack();
		knapsack.knapsack(nowNum, nowWeight, nowP);
		assertTrue(11 == knapsack.ret);

		knapsack = new Knapsack();
		int result = knapsack.knapsack2(nowNum, nowWeight);
		assertTrue(9 == result);

		knapsack = new Knapsack();
		result = knapsack.knapsack3(nowNum, nowWeight);
		assertTrue(9 == result);
	}
}
