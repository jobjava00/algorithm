package algorithm.codility.lesson4;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

public class FrogRiverOne {
	public int solution(int X, int[] A) {
		int[] result = new int[X + 1];
		int num, sum = 0;
		int totalSum = (1 + X) * X / 2;
		for (int i = 0; i < A.length; i++) {
			num = A[i];
			if (0 == result[num]) {
				result[num] = 1;
				sum += num;
			}
			if (totalSum == sum) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		FrogRiverOne question = new FrogRiverOne();
		Assert.assertThat(question.solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }), is(6));
		Assert.assertThat(question.solution(5, new int[] { 1, 2, 1, 4, 2, 4, 5, 4 }), is(-1));
		Assert.assertThat(question.solution(5, new int[] { 5, 4, 3, 2, 1, 4, 5, 4 }), is(4));
	}
}
