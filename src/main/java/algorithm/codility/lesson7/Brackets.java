package algorithm.codility.lesson7;

import static org.hamcrest.CoreMatchers.is;

import java.util.Stack;

import org.junit.Assert;

/**
 ## 해석

 * S : 아래 조건을 충족하는 N개의 문자로 구성 된 중첩 된 문자열
 * * S는 비어있음.
 * * S는  "(U)" or "[U]" or "{U}" 형식을 가지면 U는 중첩 된 문자열
 * * S는 "VM" 형식을 가지면 V와 W는 중첩 된 문자열이다.
 * * S가 제대로 중첩되면 1을 반환, 그렇지 않으면 0을 반환하라!.

 ## 풀이

 * Stack 이용
 * 여는 괄호 (,{,[ push
 * 닫는 괄호 ),},] pop
 * 최종적으로 stack 이 비어있어야 함.

 ## 제약사항

 * N의 범위는 정수 [0..200,000]
 * 문자열 S는 "(", "{", "[", "]", "}"및 ")"문자로만 구성 됨.
 * 
 * ### 결과
 * https://app.codility.com/demo/results/training8VEY8K-QQU/?showingAll=1
 */
public class Brackets {
	public int solution(String S) {
		Stack<Character> stack = new Stack<>();
		char lastChar;
		for (char c : S.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') stack.push(c);
			else {
				if (stack.empty()) return 0;
				lastChar = stack.pop();

				if (c == ')' && lastChar != '(') return 0;
				else if (c == ']' && lastChar != '[') return 0;
				else if (c == '}' && lastChar != '{') return 0;
			}
		}
		return stack.isEmpty() ? 1 : 0;
	}

	public static void main(String[] args) {
		Brackets question = new Brackets();
		Assert.assertThat(question.solution("{[()()]}"), is(1));
		Assert.assertThat(question.solution("([)()]"), is(0));
	}
}
