package algorithm.codility.lesson3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

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
