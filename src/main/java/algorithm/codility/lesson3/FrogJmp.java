package algorithm.codility.lesson3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

public class FrogJmp {
	public int solution(int X, int Y, int D) {
		double divideNum = (Y - X) * 1.0 / D;
        return (int) Math.ceil(divideNum);
	}

	public static void main(String[] args) {
		FrogJmp question = new FrogJmp();
		Assert.assertThat(question.solution(10, 85, 30), is(3));
		Assert.assertThat(question.solution(10, 90, 30), is(3));
        Assert.assertThat(question.solution(5, 105, 3), is(34));

	}
}
