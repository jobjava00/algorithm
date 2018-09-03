package algorithm.codility.lesson3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 * Time Complexity
 *
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is
 * missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * 
 * A : N개의 다른 정수로 이루어진 배열
 * A 배열은 1...(N+1)로 이루어짐
 * 각 정수는 유니크함.
 * 빠진 정수 하나를 찾아라!
 *
 * 누적합 공식 사용 : (시작숫자 + 끝숫자 ) * 끝숫자 / 2
 * result : https://app.codility.com/demo/results/trainingHNZGJ8-VJX/?showingAll=1
 */
public class PermMissingElem {
	public int solution(int[] A) {
		long lastNum = A.length + 1;
		long sum = 0;
		for (int n : A) {
			sum += n;
		}
		return (int)((1 + lastNum) * lastNum / 2 - sum);
	}

	public static void main(String[] args) {
		PermMissingElem question = new PermMissingElem();
		Assert.assertThat(question.solution(new int[] { 3, 1 }), is(2));
		Assert.assertThat(question.solution(new int[] { 2, 3, 1, 5 }), is(4));
		Assert.assertThat(question.solution(new int[] { 1, 3, 2, 4 }), is(5));
	}
}
