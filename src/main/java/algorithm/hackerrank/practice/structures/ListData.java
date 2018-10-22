package algorithm.hackerrank.practice.structures;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-list/problem
 */
public class ListData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			String query = sc.next();
			int index = sc.nextInt();
			if ("Insert".equals(query)) {
				int value = sc.nextInt();
				list.add(index, value);
			} else if ("Delete".equals(query)) {
				list.remove(index);
			}
		}
		sc.close();

		for (Integer i: list) {
			System.out.print(i + " ");
		}
	}
}
