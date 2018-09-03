package algorithm.codility.lesson3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 * Time Complexity
 *
 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to
 * Y. The small frog always jumps a fixed distance, D.
 * 
 * Count the minimal number of jumps that the small frog must perform to reach its target.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int X, int Y, int D); }
 * 
 * that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
 * 
 * For example, given:
 * 
 * X = 10
 * Y = 85
 * D = 30
 * the function should return 3, because the frog will be positioned as follows:
 * 
 * after the first jump, at position 10 + 30 = 40
 * after the second jump, at position 10 + 30 + 30 = 70
 * after the third jump, at position 10 + 30 + 30 + 30 = 100
 * Write an efficient algorithm for the following assumptions:
 * 
 * X, Y and D are integers within the range [1..1,000,000,000];
 * X ≤ Y.
 * 
 * 개구리는 X위치에서 Y위치로 D거리만큼 이동
 * Y위치로 같거나 큰 거리를 점프 했을 때의 횟수 리턴
 *
 * result : https://app.codility.com/demo/results/trainingKXPASK-R73/?showingAll=1
 */
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
