package algorithm.programmers.easy.level1.string;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 * 이상한 문자 만들기
 *
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
 * 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
 * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 * 제한 사항
 * 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
 */
public class StrangeChar {
	public String solution(String s) {
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			idx = Character.isSpaceChar(c) ? 0 : idx+1;
			c = (idx % 2) == 1 ? Character.toUpperCase(c) : Character.toLowerCase(c);
			sb.append(c);
		}
		return sb.toString();
	}

	public String mySolution(String s) {
		boolean isEven = true;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isSpaceChar(c)) {
				isEven = true;
			} else {
				if (isEven) {
					c = Character.toUpperCase(c);
					isEven = false;
				} else {
					c = Character.toLowerCase(c);
					isEven = true;
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		StrangeChar question = new StrangeChar();
		Assert.assertThat(question.solution("try hello world"), is("TrY HeLlO WoRlD"));
		Assert.assertThat(question.solution("aBcD derf  hewq"), is("AbCd DeRf  HeWq"));
		Assert.assertThat(question.solution(" ABCD"), is(" AbCd"));
	}
}
