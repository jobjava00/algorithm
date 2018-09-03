package algorithm.programmers.easy.level1.number;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 * 정수 제곱근 판벌
 *
 * 임의의 정수 n에 대해, n이 어떤 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 * 제한 사항
 * n은 1이상, 50000000000000 이하인 정수입니다.
 */
public class SquareRoot {
	public long solution(long n) {
		int sqrtNum = (int) Math.sqrt(n);
		return Math.pow(sqrtNum, 2) == n ? (long) Math.pow(sqrtNum + 1, 2) : -1;
	}

	public long mySolution(long n) {
		double k = Math.sqrt(n);
		String s = String.valueOf(k);
		String[] numArray = s.split("\\.", 2);
		long point = Long.parseLong(numArray[1]);
		long answer;
		if (point > 0)
			answer = -1;
		else {
			answer = Long.parseLong(numArray[0]) + 1;
			answer *= answer;
		}
		return answer;
	}

	public static void main(String[] args) {
		SquareRoot question = new SquareRoot();
		Assert.assertThat(question.solution(3), is(-1L));
		Assert.assertThat(question.solution(121), is(144L));
	}
}
