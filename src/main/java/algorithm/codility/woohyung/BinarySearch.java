package algorithm.codility.woohyung;

import org.junit.Assert;

/**
 * 버그가 있는 solutionOriginal 부분을 3줄만 수정해서 고쳐라!
 * @author jobjava00
 */
public class BinarySearch {
	public int solutionOriginal(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (A[m] > X) {
				r = m - 1;
			} else {
				l = m;
			}
		}
		if (A[l] == X) {
			return l;
		}
		return -1;
	}

	public int solution(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N + 1;  //수정 부분
		while (l == 0 && l < r) {   //수정 부분
			int m = (l + r) / 2;
			if (A[m] > X) {
				r = m + 1;  //수정 부분
			} else {
				l = m;
			}
		}
		if (A[l] == X) {
			return l;
		}
		return -1;
	}
	public static void main(String[] args){
		BinarySearch question = new BinarySearch();
		Assert.assertEquals(2, question.solution(new int[]{1, 2, 5, 9, 9}, 5));
		Assert.assertEquals(-1, question.solution(new int[]{1, 2, 5, 9, 9}, 6));
		Assert.assertEquals(1, question.solution(new int[]{1, 2, 5, 9, 9}, 2));
		Assert.assertEquals(3, question.solution(new int[]{1, 2, 5, 9, 9}, 9));
	}
}
