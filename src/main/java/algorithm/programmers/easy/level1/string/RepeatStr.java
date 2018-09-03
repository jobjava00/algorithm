package algorithm.programmers.easy.level1.string;

/**
 * 수박수박수박수박수박수?
 *
 * 길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
 * 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.
 * 제한 조건
 * n은 길이 10,000이하인 자연수입니다.
 */
public class RepeatStr {
	public String solution(int n) {
        //ASCII 코드에서 \0 은 NUL 을 나타냄 : 인자 값 만큼 char 배열을 만들고 NULL 문자를 문자열로 변환
        //ASCII 코드를 유니코드로 변환해도 결과 같음 : \0 -> \u0000
		return new String(new char[n / 2 + 1]).replace("\0", "수박").substring(0, n);
	}

	public static void main(String[] args) {
		RepeatStr question = new RepeatStr();
		System.out.println(question.solution(3));
		System.out.println(question.solution(4));
		long start = System.currentTimeMillis();
		System.out.println(question.solution(100000));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
