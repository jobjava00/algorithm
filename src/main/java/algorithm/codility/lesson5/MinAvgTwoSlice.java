package algorithm.codility.lesson5;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

public class MinAvgTwoSlice {
	public int solution(int[] A) {
		int length = A.length;
		float globalMinAverage = Integer.MAX_VALUE;
		int minPosition = 0;
		float twoAverage, threeAverage, minAverage;

		for (int i = 0; i < length - 2; i++) {
			twoAverage = (A[i] + A[i + 1]) / 2.0f;
			threeAverage = (A[i] + A[i + 1] + A[i + 2]) / 3.0f;
			minAverage = Math.min(twoAverage, threeAverage);
			if (minAverage < globalMinAverage) {
				globalMinAverage = minAverage;
				minPosition = i;
			}
		}
		twoAverage = (A[length - 2] + A[length - 1]) / 2.0f;
		if (twoAverage < globalMinAverage) minPosition = length - 2;
		return minPosition;
	}

	public static void main(String[] args) {
		MinAvgTwoSlice question = new MinAvgTwoSlice();
		Assert.assertThat(question.solution(new int[] { -3, -5, -8, -4, -10 }), is(2));
		Assert.assertThat(question.solution(new int[] { 4, 2, 2, 5, 1, 5, 8 }), is(1));
		Assert.assertThat(question.solution(new int[] { 1, 4, 2, 5, 5, 1, 5, 4 }), is(0));
		Assert.assertThat(question.solution(new int[] { 1, 5, 5, 5, 5, 5, 5, 1 }), is(0));
		Assert.assertThat(question.solution(new int[] { 10, 10, -1, 2, 4, -1, 2, -1 }), is(5));

	}
}
