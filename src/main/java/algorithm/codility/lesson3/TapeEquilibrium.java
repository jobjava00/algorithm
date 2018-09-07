package algorithm.codility.lesson3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 ### 해석
 * 배열 A : N개의 비어있지 않는 정수로 구성
 * 배열 A : 테이프의 숫자
 * P : 임의의 정수, 0 < P < N
 * 테이프 : 비어있지 않는 두 부분으로 나뉨. A[0]
 * 두 부분 : A[1], ..., A[P − 1] 와 A[P], A[P + 1], ..., A[N − 1]
 * 두 부분의 차이값 : |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * 최소 차이값를 리턴하라!

 ### 풀이
 * 이전 요소 + 현재 값의 합 배열 사용 - 이중 for문 피하는데에 중점.
 * (모든요소의 합 - 이전요소까지의 합) - 이전요소까지의 합 = (A[0] + A[1] + ... + A[P − 1]) - (A[P] + A[P + 1] + ... + A[N − 1])

 ### 제약사항
 * N의 범위는 정수 [2..100,000]
 * A의 각 요소의 범위는 정수 [−1,000..1,000]
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
