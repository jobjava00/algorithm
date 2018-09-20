package algorithm.codility.lesson8;

import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;

/**
 * ## 해석
 * 
 * 배열A : 정수 N으로 구성
 * 배열A의 지배자 : A의 요소의 절반 이상에서 발생하는 값.
 * 배열A의 지배자가 발생하는 요소의 인덱스 중 하나를 반환하라!
 * * 만약 지배자가 없으면 -1을 반환
 * 
 * ## 풀이
 * 
 * 배열의 절반 이상을 차지해야 하므로 리더는 한명만 존재!
 * 리더 선출에 stack 사용
 * stack에 값이 없으면 push
 * 이전 값이랑 현재 값이 다르면 이전값이랑 현재값 제거
 * 이전 값이랑 현재 값이 같으면 stack에 쌓음
 * 최종적으로 stack에 남아 있는 값이 후보자
 * 후보자를 대상으로 카운트를 세서 절반 이상인지 확인
 * * 절반 이상이면 리더
 * 
 * ## 제약사항
 * 
 * N의 범위는 정수 [0..100,000]
 * 배열 A 의 요소의 범위는 [−2,147,483,648..2,147,483,647]
 *
 * ## 결과
 * <https://app.codility.com/demo/results/training3S95UU-VY7/>
 */
public class Dominator {
	public int solution(int[] A) {
		int N = A.length;
		if (N == 0) return -1;
		Stack<Integer> stack = new Stack<>();

		for (int num : A) {
			if (stack.isEmpty()) {
				stack.push(num);
				continue;
			}
			if (stack.peek() == num) stack.push(num);
			else stack.pop();
		}

		int candidate = -1;
		int leaderIndex = -1;
		int count = 0;

		if (stack.size() > 0) candidate = stack.peek();

		for (int i = 0; i < N; i++) {
			if (candidate == A[i]) count++;
			if (count > (N / 2)) {
				leaderIndex = i;
				break;
			}
		}
		return leaderIndex;
	}

	public static void main(String[] args) {
		Dominator question = new Dominator();
		List<Integer> expectResult = Arrays.asList(0, 2, 4, 6, 7);
		Assert.assertThat(expectResult.contains(question.solution(new int[] { 3, 4, 3, 2, 3, -1, 3, 3 })), is(true));

		expectResult = Arrays.asList(-1);
		Assert.assertThat(expectResult.contains(question.solution(new int[] { 1, 2, 3, 4, 5, 6, 6, 6 })), is(true));

		expectResult = Arrays.asList(1, 2, 3, 4);
		Assert.assertThat(expectResult.contains(question.solution(new int[] { 4, 6, 6, 6, 6, 8, 8 })), is(true));
	}
}
