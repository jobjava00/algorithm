package algorithm.codility.lesson3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

public class TapeEquilibrium {
	public int solution(int[] A) {
		int[] sumArray = new int[A.length];
		int length = A.length;

		for (int i = 0; i < length; i++) {
			if (0 == i) sumArray[i] = A[i];
			else sumArray[i] = sumArray[i - 1] + A[i];
		}
		boolean isFirst = true;
		int result = 0;
		for (int i = 1; i < length; i++) {
			int sum = (sumArray[length - 1] - sumArray[i - 1]) - sumArray[i - 1];
			sum = Math.abs(sum);
			if (isFirst) {
				result = sum;
				isFirst = false;
			} else result = Math.min(result, sum);
		}
		return result;
	}

	public static void main(String[] args) {
		TapeEquilibrium question = new TapeEquilibrium();
		Assert.assertThat(question.solution(new int[] { -1000, 1000 }), is(2000));
		Assert.assertThat(question.solution(new int[] { 3, 1, 2, 4, 3 }), is(1));
		Assert.assertThat(question.solution(new int[] { 7, 5 }), is(2));
		Assert.assertThat(question.solution(new int[] { 7, 3, 2, 4, 1 }), is(3));
	}
}
