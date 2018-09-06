package algorithm.codility.lesson5;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

public class PassingCars {
	public int solution(int[] A) {
        int pCount = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (0 == A[i]) pCount++;
            else {
                sum += pCount * A[i];
                if (sum > 1000000000) return -1;
            }
        }
        return sum;
    }

	public static void main(String[] args) {
		PassingCars question = new PassingCars();
		Assert.assertThat(question.solution(new int[] { 0, 1, 0, 1, 1 }), is(5));
		Assert.assertThat(question.solution(new int[] { 0, 0, 0, 1, 1 }), is(6));
		Assert.assertThat(question.solution(new int[] { 1, 1, 0, 1, 1 }), is(2));
	}
}
