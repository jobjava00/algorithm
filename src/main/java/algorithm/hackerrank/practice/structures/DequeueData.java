package algorithm.hackerrank.practice.structures;

import java.util.*;

/**
 * Created by uienw on 2018-10-20.
 */
public class DequeueData {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();
		Set set = new HashSet<Integer>();
		int max = 0;
		int n = in.nextInt();
		int m = in.nextInt();

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			deque.add(num);
			set.add(num);

			if (deque.size() == m) {
				max = Math.max(max, set.size());
				int pollNum = deque.poll();
				if (!deque.contains(pollNum)) {
					set.remove(pollNum);
				}
			}
		}
		System.out.println(max);
	}
}
