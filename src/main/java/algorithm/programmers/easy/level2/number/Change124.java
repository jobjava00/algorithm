package algorithm.programmers.easy.level2.number;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 * 124 나라의 숫자
 *
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
 * 124 나라에는 자연수만 존재합니다.
 * 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
 * 예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
 *
 * 자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 * 제한사항
 * n은 500,000,000이하의 자연수 입니다.
 */
public class Change124 {
    /**
     *  0이 4로 치환되는 3진수가 동일
     *  0이 될 때는 앞에 숫자를 - 해줘야 한다.
     */
	public String solution(int n) {
		String[] list = { "4", "1", "2" };
		String result = "";
		while (n > 0) {
			int mod = n % 3;
			n /= 3;
			if (mod == 0) {
				n--;
			}
			result = list[mod] + result;
		}
		return result;
	}

	public static void main(String[] args) {
		Change124 question = new Change124();
		Assert.assertThat(question.solution(1), is("1"));
		Assert.assertThat(question.solution(2), is("2"));
		Assert.assertThat(question.solution(4), is("11"));
		Assert.assertThat(question.solution(5), is("12"));
		Assert.assertThat(question.solution(9), is("24"));
		Assert.assertThat(question.solution(10), is("41"));
		Assert.assertThat(question.solution(24), is("214"));
	}
}
