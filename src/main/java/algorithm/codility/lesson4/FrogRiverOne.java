package algorithm.codility.lesson4;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 ### 해석
 * 배열 A : N개의 정수로 이루어진 배열
 * A[K] : K 시간에 한 잎이 떨어지는 위치
 * 나뭇잎 : 한번 떨어지면 움직이지 않고 고정 됨
 * 개구리 : 1 to X 까지의 모든 위치가 잎으로 덮어져 있을 때 강 건너편으로 이동할 수 있다.
 * 만약 개구리가 강을 건널 수 없다면 -1 리턴
 * X의 위치가 주어졌을 때 개구리가 강을 건널 수 있는 최소 시간을 구하라!

 ### 풀이
 * 누적합 공식 사용 : (시작숫자 + 끝숫자 ) * 끝숫자 / 2

 ### 제약사항
 * N,X의 범위는 정수 [1..100,000]
 * A의 각 요소의 범위는 정수 [1..X]
 */
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
