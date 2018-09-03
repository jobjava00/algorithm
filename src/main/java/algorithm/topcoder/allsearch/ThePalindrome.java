package algorithm.topcoder.allsearch;

/**
 * 회문
 * 문자열을 앞에서 읽으나 뒤에서 읽으나 똑같게 만들 때
 * 가장 짧은 회문의 길이를 구하라.
 */
public class ThePalindrome {
	/**
	 * 문자열 앞자리와 맨 끝부터 비교 해서 같지 않으면 문자열 길이 증가
	 * i번째 문자와 (i - j - 1) 문자가 일치하는지 확인
	 * @param s
	 * @return
	 */
	public int find(String s) {
		//답의 문자 길이를 결정
		for (int i = s.length();; i++) {
			boolean flag = true;
			for (int j = 0; j < s.length(); j++) {
				//반대쪽에 문자가 존재하는 데 다를 경우 플래그를 변경
				if ((i - j - 1) < s.length() && s.charAt(j) != s.charAt(i - j - 1)) {
					flag = false;
					break;
				}
			}
			// 조건을 모두 만족하면 답 리턴
			if (flag)
				return i;
		}
	}
}
