package algorithm.codility.lesson4;

import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;

import org.junit.Assert;

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
