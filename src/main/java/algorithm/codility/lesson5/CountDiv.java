package algorithm.codility.lesson5;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 ### 해석
 * 세개의 정수 A,B,K 가 주어짐
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * [A..B] 사이에 K로 나누어 떨어질수 있는 정수를 리턴하라!

 ### 풀이
 * A와 B사이에 K로 나눌수 있는 수 = (B / K) - (A / K)
 * A가 K로 나눌수 있는지 여부 = (A % K == 0)
 * A == B 이면 A와 B사이에 K로 나눌수 있는 수는 없음.

 ### 제약사항
 * A,B의 범위는 정수 [0..2,000,000,000]
 * K의 범위는 정수 [1..2,000,000,000]
 */
public class CountDiv {
	public int solution(int A, int B, int K) {
		int count = 0;
		if (A % K == 0) count++;
		if(A != B){
			int firstDivided = A / K;
			int secondDivided = B / K;
			count += secondDivided - firstDivided;
		}
		return count;
	}

	public static void main(String[] args) {
		CountDiv question = new CountDiv();
		Assert.assertThat(question.solution(11, 13, 2), is(1));
		Assert.assertThat(question.solution(10, 10, 7), is(0));
		Assert.assertThat(question.solution(6, 11, 2), is(3));
		Assert.assertThat(question.solution(11, 345, 17), is(20));
		Assert.assertThat(question.solution(10, 10, 5), is(1));
		Assert.assertThat(question.solution(0, 0, 11), is(1));
		Assert.assertThat(question.solution(1, 1, 11), is(0));
		Assert.assertThat(question.solution(11, 14, 2), is(2));
		Assert.assertThat(question.solution(101, 123456789, 10000), is(12345));
	}
}
