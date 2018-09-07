package algorithm.codility.lesson4;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 ### 해석
 * N개의 카운터가 주어짐
 * - 기본값은 0
 * 두가지 명령 가능
 * * increase(X) : 카운터 X를 1 증가
 * * max counter: 최대 값인 카운터의 값으로 모든 카운터 값 설정
 * A : 비어있지 않는 M 개의 정수로 이루어짐
 * A[K] = K 일때 1 <= X <= N 이면 증가
 * A[K] = N + 1 이면 max counter
 * 카운터의 시퀀스 값들을 리턴하라!

 ### 풀이
 * maxCounter 될 때 전체 couters를 업데이트 하지 말고 현재 max를 기록
 * 최종 counters 응답 시 maxCounter 보다 작으면 maxCounter로 설정

 ### 제약사항
 * N, M의 범위는 정수 [1..100,000]
 * A의 각 요소의 범위는 정수 [1..N + 1]
 */
public class MaxCounters {
	public int[] solution(int N, int[] A) {
		int[] counter = new int[N];
		int maxCounterNum = 0;
		int num, counterIndex, max = 0;
		for (int i = 0; i < A.length; i++) {
			num = A[i];
			counterIndex = num - 1;
			if (num >= 1 && num <= N) {
				if (maxCounterNum >= counter[counterIndex])
					counter[counterIndex] = maxCounterNum + 1;
				else
					counter[counterIndex] = counter[counterIndex] + 1;
				max = Math.max(max, counter[counterIndex]);
			} else if (num == N + 1)
				maxCounterNum = max;
		}

		for (int i = 0; i < counter.length; i++) {
			if (maxCounterNum > 0 && maxCounterNum > counter[i])
				counter[i] = maxCounterNum;
		}
		return counter;
	}

	public static void main(String[] args) {
		MaxCounters question = new MaxCounters();
		Assert.assertThat(question.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 }), is(new int[] { 3, 2, 2, 4, 2 }));
	}
}
