package algorithm.codility.lesson6;

import org.junit.Assert;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

/**
 * ### 해석
 * A : N개의 정수로 구성 된 비어있지 않은 배열
 * 삼중 항 (P, Q, R) : A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * 삼중 항의 최대 값을 리턴해라!
 * 
 * ### 풀이
 * 우선 정렬 시킨다.
 * 모두 양수 일 경우
 * * 1 2 3 4 5 6 = A[N-1] * A[N-2] * A[N-3]
 * 모두 음수 일 경우
 * * -6 -5 -4 -3 -2 -1 = A[N-1] * A[0] * A[1]
 * 음수, 양수 혼합 일 경우
 * * -1 -2 -3 -4 -5 6 = A[N-1] * A[N-2] * A[N-3]
 * A[N-1] 은 항상 곱해진다.
 * A[N-1] 이 음수, 양수 여부에 따라 최소값, 최대값을 구해준다.
 * 
 * ### 제약사항
 * N의 범위는 정수 [3..100,000]
 * 배열A의 각 요소의 범위는 정수 [−1,000..1,000]
 * 
 * ### 결과
 * https://app.codility.com/demo/results/trainingUMX35Q-3VE/?showingAll=1
 */
public class MaxProductOfThree {
	public int solution(int[] A) {
		Arrays.sort(A);

		int N = A.length;
		int firstProduct = A[0] * A[1];
		int secondProduct = A[N - 3] * A[N - 2];
		int lastProduct = A[N - 1];

		if (lastProduct < 0) return Math.min(firstProduct, secondProduct) * A[N - 1];
		else return Math.max(firstProduct, secondProduct) * A[N - 1];
	}

	public static void main(String[] args) {
		MaxProductOfThree question = new MaxProductOfThree();

		Assert.assertThat(question.solution(new int[] { 4, 7, 3, 2, 1, -3, -5 }), is(105));
		Assert.assertThat(question.solution(new int[] { -10, -2, -4 }), is(-80));
		Assert.assertThat(question.solution(new int[] { -3, 1, 2, -2, 5, 6 }), is(60));
		Assert.assertThat(question.solution(new int[] { -30, -5, 2, 3, 5, 6 }), is(900));
		Assert.assertThat(question.solution(new int[] { -5, -6, -4, -7, -10 }), is(-120));
	}
}
