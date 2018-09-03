package algorithm.programmers.easy.level2.string;

/**
 * 올바른 괄호
 *
 * 올바른 괄호란 두 개의 괄호 '(' 와 ')' 만으로 구성되어 있고, 괄호가 올바르게 짝지어진 문자열입니다.
 * 괄호가 올바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 합니다.
 * 예를들어
 * ()() 또는 (())() 는 올바른 괄호입니다.
 * )()( 또는 (()( 는 올바르지 않은 괄호입니다.
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때,
 * 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return하는 solution 함수를 완성해 주세요.
 * 제한사항
 * 문자열 s의 길이 : 100,000 이하의 자연수
 * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
 */
public class RightBracket {
	public boolean solution(String s) {
		int cnt = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') cnt++;
			else cnt--;
			if (cnt < 0) {
				break;
			}
		}
		return cnt == 0 ? true : false;
	}

	public static void main(String[] args) {
		String s = "()()";
		RightBracket question = new RightBracket();
		System.out.println(question.solution(s));

		s = "(())()";
		System.out.println(question.solution(s));

		s = ")()(";
		System.out.println(question.solution(s));

		s = "(()(";
		System.out.println(question.solution(s));
	}
}
