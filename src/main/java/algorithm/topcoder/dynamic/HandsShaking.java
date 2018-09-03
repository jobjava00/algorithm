package algorithm.topcoder.dynamic;

/**
 * 악수
 * 1. n명의 직장인이 있다.
 * 2. 각각의 직장인은 반드시 다른 사람과 악수를 한다.
 * 3. 서로의 팔을 교차할 수는 없다.
 * 4. 정수 n이 주어졌을 때 n명의 직장인 하는 악수가 성립하는 조합의 수를 구하라!
 */
public class HandsShaking {
	/**
	 * 카탈랑 수 - 참고하기
	 * 
	 * @param n
	 * @return
	 */
	public long countPerfect(int n) {
		long[] dp = new long[n / 2 + 1];
		dp[0] = 1;

		for (int i = 1; i <= n / 2; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n / 2];
	}
}