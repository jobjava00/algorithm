package algorithm.codility.lesson4;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

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
