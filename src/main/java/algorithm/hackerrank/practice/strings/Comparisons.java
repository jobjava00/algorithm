package algorithm.hackerrank.practice.strings;

import java.util.Scanner;

/**
 * 문자열 비교
 *
 * 첫번째 줄 : 문자열
 * 두번재 줄 : 비교할 문자의 크기
 * 문자열은 알파벳 순
 * 입력 문자열은 [a-zA-Z] 만 포함됨.
 *
 * output
 * 첫째줄 : 가장 작은 순서의 문자열
 * 둘째줄 : 가장 높은 순서의 문자열
 *
 * Sample Input 0
 *
 * welcometojava
 * 3
 *
 * Sample Output 0
 *
 * ava
 * wel
 */
public class Comparisons {
	public static String getSmallestAndLargest(String s, int k) {
		String smallest = s.substring(0, k);
		String largest = smallest;

		String tempStr;
		for (int i = 0; i <= s.length() - k; i++) {
			tempStr = s.substring(i, i + k);
			if (tempStr.compareTo(smallest) < 0) {
				smallest = tempStr;
			}
			if (tempStr.compareTo(largest) > 0) {
				largest = tempStr;
			}
		}
		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}
