package algorithm.codility.lesson4;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 * Counting Elements
 *
 * This is a demo task.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * 
 * ### 풀이
 * 배열 A : N개의 정수로 이루어짐
 * A에서 발생하지 않는 0보다 큰 최소 양의 정수를 리턴하라!
 * 
 * ### 제약사항
 * N의 범위는 정수 [1..100,000]
 * A의 각 요소의 범위는 정수 [−1,000,000..1,000,000]
 *
 * ### 결과
 * https://app.codility.com/demo/results/training3PDG52-S7Q/?showingAll=1
 */
public class MissingInteger {
	public int solution(int[] A) {
		boolean[] checker = new boolean[A.length + 1];
		int checkCount = 0;
		int num;
		for (int i = 0; i < A.length; i++) {
			num = A[i];
			if (num > 0 && num < checker.length) checker[num] = true;   //양수 일 때만 체크
		}

		for (int i = 1; i < checker.length; i++) {
			if(checker[i]) checkCount++;
			else return i;
		}
		return checkCount == (checker.length - 1) ? checker.length : 1;   //모두 만족하면 그 다음수 리턴 아니면 모두 음수이므로 양의 최소값 1 리턴
	}

	public static void main(String[] args) {
		MissingInteger question = new MissingInteger();
		Assert.assertThat(question.solution(new int[] { 1, 3, 6, 4, 1, 2 }), is(5));
		Assert.assertThat(question.solution(new int[] { -1, -3 }), is(1));
		Assert.assertThat(question.solution(new int[] { 1, 2, 3 }), is(4));
		Assert.assertThat(question.solution(new int[] { 2, 1, 6, 5, 3, 2 }), is(4));
	}
}
