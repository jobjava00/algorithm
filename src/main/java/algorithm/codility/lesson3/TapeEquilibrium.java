package algorithm.codility.lesson3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 * Time Complexity
 *
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * 
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * 
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * 
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * 
 * For example, consider array A such that:
 * 
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * We can split this tape in four places:
 * 
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * 
 * For example, given:
 * 
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * the function should return 1, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * 
 * A : N개의 정수로 이루어진 배열
 * P : 임의의 정수
 * 0 < P < N,
 * (A[0]...A[P-1]) - (A[P]...A[N-1]) 의 절대값
 * 절대값 중에 제일 작은 수를 구하라
 *
 * result : https://app.codility.com/demo/results/trainingHR9K4Q-ZYM/?showingAll=1
 */
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
