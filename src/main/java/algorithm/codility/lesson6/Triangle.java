package algorithm.codility.lesson6;

import org.junit.Assert;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

/**
 * ### 해석
 * A : N개의 정수로 구성 된 배열
 * (P, Q, R)이 삼각형일 때
 * ```
 * 0 ≤ P < Q < R < N
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * ```
 * 배열에 삼각형이 있으면 1, 없으면 0을 리턴하라!
 * 
 * ### 풀이
 * 배열 크기가 3이하 일 경우 처리 필요
 * 각 요소의 범위가 정수 최대치 이므로 더했을 경우 long 형으로 처리해야 함
 * 정렬을 우선 한다.
 * 위에 나온 식으로 더해서 모두 true 일 경우 루프 중단.
 * 
 * ### 제약사항
 * N의 범위는 정수 [0..100,000]
 * 배열A의 각 요소의 범위는 정수 [−2,147,483,648..2,147,483,647]
 * 
 * ### 결과
 * https://app.codility.com/demo/results/training6JU3SE-AN9/?showingAll=1
 */
public class Triangle {
	public int solution(int[] A) {
		int N = A.length;
		if (3 > N) return 0;

		Arrays.sort(A);

		for (int i = 0; i < N - 2; i++) {
			long P = A[i], Q = A[i + 1], R = A[i + 2];
			if (P + Q > R) return 1;
		}
		return 0;
	}

	public int mySolution(int[] A) {
		int N = A.length;
		if (3 > N) return 0;

		Arrays.sort(A);

		for (int i = 0; i < N - 2; i++) {
			int passSum = 0;
			long P = A[i], Q = A[i + 1], R = A[i + 2];
			if (P + Q > R) passSum++;
			if (Q + R > P) passSum++;
			if (R + P > Q) passSum++;
			if (3 == passSum) return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		Triangle question = new Triangle();

		Assert.assertThat(question.solution(new int[] { 10, 2, 5, 1, 8, 20 }), is(1));
		Assert.assertThat(question.solution(new int[] { 10, 50, 5, 1 }), is(0));
		Assert.assertThat(question.solution(new int[] { -10, -2, -5, -1, -8, -20 }), is(0));
	}
}
