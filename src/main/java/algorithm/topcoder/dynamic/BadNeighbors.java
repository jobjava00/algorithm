package algorithm.topcoder.dynamic;

/**
 * 나쁜 이웃집 사람들
 * 1. 마을의 주민은 모두 int 배열 donations의 금액만큼만 기부하려 한다.
 * 2. int 배열 donation은 우물을 기준으로 시계 방향 순서이다.
 * 3. 이웃 사람이 기부하면 자신은 기부하지 않는다.
 * 4. 이웃은 donations에 연속되어 있으므로 donations 배열의 1번째 요소와 마지막 번째 요수는 서로 이웃이다.
 * 5. 마을에서 얻을 수 있는 가장 큰 기부 금액을 구하라!
 */
public class BadNeighbors {
	public int maxDonations(int[] donations) {
		int i;
		int ans = 0;

		int N = donations.length;
		int[] dp = new int[N];

		for (i = 0; i < N - 1; i++) {
			dp[i] = donations[i];
			if (i > 0)
				dp[i] = Math.max(dp[i], dp[i - 1]);
			if (i > 1)
				dp[i] = Math.max(dp[i], dp[i - 2] + donations[i]);
			ans = Math.max(ans, dp[i]);
		}

		for (i = 0; i < N - 1; i++) {
			dp[i] = donations[i + 1];
			if (i > 0)
				dp[i] = Math.max(dp[i], dp[i - 1]);
			if (i > 1)
				dp[i] = Math.max(dp[i], dp[i - 2] + donations[i + 1]);
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}
}
