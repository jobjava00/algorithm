package algorithm.codility.lesson5;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 ### 해석
 * DNA sequence : 문자 A,C,G,T로 구성된 문자열 S
 * S : N개의 문자로 구성된 비어 있지 않은 문자열 S[0]S[1]..S[N-1]
 * A,C,G,T는 각각 1,2,3,4 이라는 impact factor 로 매치됨.
 * 배열 P, Q : 비어있지 않은 배열로 각각 M개의 정수로 구성 됨
 * K번째 query : (0 <= K < M) 위치 P[K]와 Q[K] 사이의 DNA sequence 포함된 최소 impact factor를 찾음.
 * 주어진 DNA sequence의 K번째 query 들로 이루어진 배열을 리턴하라!

 ### 풀이
 * 각 글자별 누적 카운트를 저장
 * 누적카운트[endIndex] - 누적카운트[startIndex - 1] 를 계산

 ### 제약사항
 * N의 범위는 정수 [1..100,000]
 * M의 범위는 정수 [1..50,000]
 * P,Q 배열의 각 요소의 범위는 정수 [0..N - 1]
 * P[K] <= Q[K]
 * 0 <= K < M
 * S : 대문자 A,C,G,T 으로만 구성됨
 */
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