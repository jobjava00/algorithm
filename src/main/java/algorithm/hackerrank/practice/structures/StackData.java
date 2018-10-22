package algorithm.hackerrank.practice.structures;

import java.util.Scanner;
import java.util.Stack;

public class StackData {
	public static void main2(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			Stack stack = new Stack();

			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if ('(' == c || '{' == c || '[' == c) {
					stack.push(input);
				} else {
					if (stack.isEmpty()) {
						stack.push(input);
						break;
					}
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
	}

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		String input = sc.next();
		while (input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length())
		System.out.println(input.isEmpty());
	}
}
