package algorithm.programmers.easy.level1.string;

import org.junit.Assert;

/**
 * 문자열 다루기 기본
 *
 * 문자열 s의 길이가 4혹은 6이고, 숫자로만 구성되있는지 확인해주는 함수, solution을 완성하세요.
 * 예를들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
 * 제한 사항
 * s는 길이 1 이상, 길이 8 이하인 문자열입니다.
 */
public class StrControll {
	public boolean solution(String s) {
		int size = s.length();
		if (size != 4 && size != 6) return false;
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "a234";
		StrControll question = new StrControll();
		Assert.assertFalse(question.solution(s));

		s = "1234";
		Assert.assertTrue(question.solution(s));
	}
}
