package algorithm.codility.lesson4;

import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;

import org.junit.Assert;

/**
 ### 해석
 * 배열 A : N개의 비어있지 않는 정수로 구성
 * 순열 : 1 ~ N 까지 각 요소를 한번만 포함하는 시퀀스
 * * 시퀀스이므로 순차적으로 증가 해야 함. 배열 크기 1 은 시퀀스가 아님
 * 배열 A가 순열이면 1, 비순열이면 0 리턴하라!

 ### 풀이
 * 인덱스에 따른 체크 배열 사용

 ### 제약사항
 * N의 범위는 정수 [1..100,000]
 * A의 각 요소의 범위는 정수 [1..1,000,000,000]
 */
public class PermCheck {
	public int solution(int[] A) {
		boolean[] checker = new boolean[A.length + 1];
		int num;
		for (int i = 0; i < A.length; i++) {
			num = A[i];
			if (num < checker.length) checker[num] = true;
		}

		for (int i = 1; i < checker.length; i++) {
			if (false == checker[i]) return 0;
		}
		return 1;
	}

	public int mySolution(int[] A) {
		int length = A.length;
		Arrays.sort(A);

		for (int i = 0; i < length; i++) {
			if (i > 0 && A[i - 1] == A[i])
				return 0;
		}
		return length == A[length - 1] ? 1 : 0;
	}

	public static void main(String[] args) {
		PermCheck question = new PermCheck();
		Assert.assertThat(question.solution(new int[] { 1 }), is(1));
		Assert.assertThat(question.solution(new int[] { 2 }), is(0));
		Assert.assertThat(question.solution(new int[] { 1, 1 }), is(0));
		Assert.assertThat(question.solution(new int[] { 3, 1 }), is(0));
		Assert.assertThat(question.solution(new int[] { 2, 3, 1, 5 }), is(0));
		Assert.assertThat(question.solution(new int[] { 1, 3, 2, 4 }), is(1));
		Assert.assertThat(question.solution(new int[] { 9, 5, 7, 3, 2, 7, 3, 1, 10, 8 }), is(0));
	}
}
