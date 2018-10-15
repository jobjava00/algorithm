package algorithm.hackerrank.practice.strings;

import java.util.Scanner;

/**
 * palindrome
 *
 * Given a string A, print Yes if it is a palindrome, print No otherwise.
 *
 * Constraints
 *
 * A will consist at most lower case english letters.
 *
 * Sample Input
 * madam
 *
 * Sample Output
 * Yes
 *
 * 팰린드롬 : 앞뒤가 똑같은 문자열
 * 문자열 A가 팰린드롬이면 Yes, 아니면 No
 */
public class Reverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();

		StringBuilder sb = new StringBuilder(A);
		if (A.equals(sb.reverse().toString())) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
