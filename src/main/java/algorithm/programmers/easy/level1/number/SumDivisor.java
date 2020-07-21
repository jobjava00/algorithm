package algorithm.programmers.easy.level1.number;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 * 약수의 합
 *
 * 자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
 *
 * 제한 사항
 * n은 0 이상 3000이하인 자연수입니다.
 */
public class SumDivisor {
	public int solution(int n) {
		int answer = 0;
		for (int i = 1; i * 2 <= n; i++) {
			System.out.println(i);
			if (n % i == 0) answer += i;
		}
		return answer + n;
	}

	public static void main(String[] args) {
		int request = 12;
		SumDivisor findMiddle = new SumDivisor();
		Assert.assertThat(findMiddle.solution(request), is(28));

		request = 5;
		Assert.assertThat(findMiddle.solution(request), is(6));
	}
}
