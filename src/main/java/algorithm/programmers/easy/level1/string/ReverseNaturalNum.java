package algorithm.programmers.easy.level1.string;

/**
 * 자연수 뒤집어 배열로 만들기
 *
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 * 제한 조건
 * n은 10,000,000,000이하인 자연수입니다.
 */
public class ReverseNaturalNum {
	public int[] solution(long n) {
		String s = new StringBuilder(String.valueOf(n)).reverse().toString();
		return s.chars().map(c -> Character.getNumericValue((char) c)).toArray();
	}

	public static void main(String[] args) {
		ReverseNaturalNum question = new ReverseNaturalNum();
		int[] result = question.solution(12345);
		for (int i: result) {
			System.out.println("i:"+ i);
		}
	}
}
