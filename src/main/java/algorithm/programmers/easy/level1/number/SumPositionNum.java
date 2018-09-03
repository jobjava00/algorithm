package algorithm.programmers.easy.level1.number;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 * 자연수 더하기
 *
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 *
 * 제한사항
 * N의 범위 : 100,000,000 이하의 자연수
 */
public class SumPositionNum {
	public int solution(int n) {
		String s = String.valueOf(n);
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			int num =  s.charAt(i) - '0';	//숫자 '0'에 해당하는 아스키코드 빼줌
			answer += num;
		}
		return answer;
	}

	public static void main(String[] args) {
		int request = 123;
		SumPositionNum findMiddle = new SumPositionNum();
		Assert.assertThat(findMiddle.solution(request), is(6));

		request = 987;
		Assert.assertThat(findMiddle.solution(request), is(24));
	}
}
