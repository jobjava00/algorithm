package algorithm.codility.lesson3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 ### 해석
 * 배열 A : N개의 서로 다른 정수로 구성
 * 배열 A : [1..(N + 1)]의 범위로 구성
 * 1로 시작하기 때문에 한 개의 누락된 요소 발생
 * 누락된 요소를 리턴하라!

 ### 풀이
 * 누적합 공식 사용 : (시작숫자 + 끝숫자 ) * 끝숫자 / 2

 ### 제약사항
 * N의 범위는 정수 [0..100,000]
 * A의 모든 요소는 중복되지 않는다.
 * A의 각 요소의 범위는 정수 [1..(N + 1)]
 */
public class PermMissingElem {
	public int solution(int[] A) {
		long lastNum = A.length + 1;
		long sum = 0;
		for (int n : A) {
			sum += n;
		}
		return (int)((1 + lastNum) * lastNum / 2 - sum);
	}

	public static void main(String[] args) {
		PermMissingElem question = new PermMissingElem();
		Assert.assertThat(question.solution(new int[] { 3, 1 }), is(2));
		Assert.assertThat(question.solution(new int[] { 2, 3, 1, 5 }), is(4));
		Assert.assertThat(question.solution(new int[] { 1, 3, 2, 4 }), is(5));
	}
}
