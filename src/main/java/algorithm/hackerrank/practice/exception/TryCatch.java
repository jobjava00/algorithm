package algorithm.hackerrank.practice.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem
 */
public class TryCatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;

		try {
			x = sc.nextInt();
			y = sc.nextInt();
			System.out.println(x / y);
		} catch (InputMismatchException e) {
			System.out.println("java.util.InputMismatchException");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
