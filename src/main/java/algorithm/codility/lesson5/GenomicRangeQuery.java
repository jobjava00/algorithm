package algorithm.codility.lesson5;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

public class GenomicRangeQuery {
	public int[] solution(String S, int[] P, int[] Q) {
		int length = S.length();
		int impactLength = 4;
		int[] impactCnt = new int[impactLength];
		int[][] impactFactorArray = new int[impactLength][length + 1];

		char c;
		int impactFactor = 0;
		for (int i = 0; i < length; i++) {
			c = S.charAt(i);
			if ('A' == c) impactFactor = 1;
			else if ('C' == c) impactFactor = 2;
			else if ('G' == c) impactFactor = 3;
			else if ('T' == c) impactFactor = 4;

			impactCnt[impactFactor - 1] += 1;

			for (int j = 0; j < impactLength; j++) {
				impactFactorArray[j][i + 1] = impactCnt[j];
			}
		}

		int[] result = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j < impactLength; j++) {
				if (impactFactorArray[j][Q[i] + 1] - impactFactorArray[j][P[i]] > 0) {
					result[i] = j + 1;
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		GenomicRangeQuery question = new GenomicRangeQuery();
		Assert.assertThat(question.solution("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 }), is(new int[] { 2, 4, 1 }));
		Assert.assertThat(question.solution("CAGCCTATA", new int[] { 1, 5, 0 }, new int[] { 3, 8, 6 }), is(new int[] { 1, 1, 1 }));
	}
}