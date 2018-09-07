package algorithm.codility.lesson5;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 ### 해석
 * A : N개의 정수로 구성 된 비어있지 않은 배열
 * (P, Q) : 0 <= P < Q < N 인 배열A의 조각
 * (P, Q)의 평균 : (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1)
 * 최소 평균을 가진 조각이 2개 이상인 경우 해당 조각의 최소 시작 위치 반환해야 함.
 * 최소 평균인 (P, Q)의 P값을 구하라!

 ### 풀이
 * slice가 2개 또는 3개인 경우 고려
 * * 인자가 짝수, 홀수 인 경우에 따라 최소 평균을 구해야 한다.
 * 평균의 성질 : 부분집합의 평균은 가장 작은 인자보다 항상 크다.
 * * (1,2)의 평균은 1.5이므로 1보다 크다.
 * 인자가 짝수인 평균들의 평균은 각 인자들의 평균과 같다.
 * * (1,2,3,4) = 2.5 이고 (1, 2) = 1.5, (3, 4) = 3.5 일 때 (1.5, 3.5) = 2.5가 된다.
 * 인자의 수가 4개 이상인 것은 고려하지 않아도 됨
 * * (1,2,3,4,5,6,7,8) = 4.5 이고 (1,2,3,4) = 2.5, (5,6,7,8) = 6.5 일 때 (2.5, 6.5) = 4.5
 * 3개의 인자를 고려하는 것은 2개의 부분집합으로는 구할 수 없기 때문
 * * (2,6,1) = 3 이고 (2,6) = 4, (6,1) =3.5일 때 (4, 3.5) = 3.75 가 되므로 인자가 짝수 일 때의 공식이 적용되지 않는다.
 * 결론 : 2개, 3개의 평균을 구해서 둘 간의 최소 평균값을 구한다.
 * * 위 풀이에서 제외 되는 마지막 2개 요소는 따로 둘만 더해서 평균을 구해서 최소평균과 비교한다.

 ### 제약사항
 * N의 범위는 정수 [2..100,000]
 * 배열A의 각 요소의 범위는 정수 [−10,000..10,000]
 */
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
