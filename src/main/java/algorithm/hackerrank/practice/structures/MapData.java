package algorithm.hackerrank.practice.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/phone-book/problem
 */
public class MapData {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> phoneBook = new HashMap<>();
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			in.nextLine();

			phoneBook.put(name, phone);
		}
		while (in.hasNext()) {
			String s = in.nextLine();
			Integer phone = phoneBook.get(s);
			if (null == phone) {
				System.out.println("Not found");
			} else {
				System.out.println(s + "=" + phone);
			}
		}
	}
}
