package algorithm.hackerrank.practice.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://jobjava00.github.io/algorithm/hackerrank/structures/ArrayList/
 */
public class ArrayListData {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d, q, x, y;

		ArrayList[] arrayList = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			d = scanner.nextInt();
			arrayList[i] = new ArrayList();

			for (int j = 0; j < d; j++) {
				arrayList[i].add(scanner.nextInt());
			}
		}

		q = scanner.nextInt();
		for (int i = 0; i < q; i++) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			try {
				System.out.println(arrayList[x - 1].get(y - 1));
			} catch (IndexOutOfBoundsException e) {
				System.out.println("ERROR!");
			}
		}
	}
}
