package algorithm.codility.lesson7;

import static org.hamcrest.CoreMatchers.is;

import java.util.Stack;

import org.junit.Assert;

/**
 ## 해석

 * S : N개의 문자들로 구성되어 있으며 아래 조건을 충족하면 중첩이다.
 * * S는 비어있음
 * * S는 "(U)" 형식을 가짐. U는 중첩 된 문자열
 * * S는 "VW" 형식을 가짐. V와 W는 중첩 된 문자열
 * S가 중첩 되어 있으면 1. 그렇지 않으면 0을 반환하라!

 ## 풀이

 * 중첩이 되면 Stack에서 제거
 * Stack에 남아있으면 중첩이 아님.

 ## 제약사항

 * N의 범위는 정수 [0..1,000,000]
 * S의 문자는 "(", ")" 으로만 구성되어 있음.
 * 
 ## 결과
 * <https://app.codility.com/demo/results/training3G4N84-JDG/?showingAll=1>
 */
public class Nesting {
	public int solution(String S) {
		Stack<Character> stack = new Stack<>();
		char bracket;

		for (int i = 0; i < S.length(); i++) {
			bracket = S.charAt(i);

			if (stack.isEmpty()) {
				stack.push(bracket);
				continue;
			}

			if ('(' == stack.peek() && ')' == bracket) stack.pop();
			else stack.push(bracket);
		}
		return stack.size() > 0 ? 0 : 1;
	}

	public static void main(String[] args) {
		Nesting question = new Nesting();
		Assert.assertThat(question.solution("))(("), is(0));
		Assert.assertThat(question.solution("(()(())())"), is(1));
		Assert.assertThat(question.solution("())"), is(0));
		Assert.assertThat(question.solution(""), is(1));

	}
}
