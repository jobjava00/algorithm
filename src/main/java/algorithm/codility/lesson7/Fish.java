package algorithm.codility.lesson7;

import static org.hamcrest.CoreMatchers.is;

import java.util.Stack;

import org.junit.Assert;

/**
 * ## 해석
 *
 * A, B : 비어있지 않은 N개의 정수로 구성 된 배열
 * 물고기 : 0 ~ N - 1
 * 물고기 P, Q가 있으면 : P < Q
 * P : 물고기 번호. A[P], B[P]
 * 배열 A : 물고기 size
 * 배열 B : 물고기의 방향
 * * 0 : 상류
 * * 1 : 하류
 * 두 물고기가 서로 다른 방향으로 움직이고 서로 만날 때 큰 물고기가 작은 물고기 잡아먹음
 * P < Q, B[P] = 1 이고 B[Q] = 0 일 때 두 물고기는 서로 만난 후
 * * A[P] > A[Q] 이면 P가 Q 잡아먹고 P는 하류로 이동함.
 * * A[Q] > A[P] 이면 Q가 P 잡아먹고 Q는 상류로 이동함.
 * 같은 방향으로 움직이는 물고기는 서로 만나지 않음.
 * 살아있는 물고기의 수를 반환하라!

 ## 풀이

 * 하류로 이동하는 물고기만 Stack에 담는다.
 * 상류로 이동하는 물고기를 만날 때 사이즈 비교
 * * Stack이 비어 있지 않으면 사이즈 비교를 하고 상류로 이동하는 물고기가 더 클 경우 Stack에서 pop을 해준다.
 * * 상류로 올라가는 경우가 하류로 내려오는 물고기들 보다 클 경우 Stack은 비게 되고 상류로 올라가는 물고기 수가 증가된다.

 ## 제약사항

 * N의 범위는 정수 [0..100,000]
 * 배열 A의 각 요소의 범위는 정수 [0..1,000,000,000]
 * 배열 B의 각 요소는 0, 1 중에 하나
 * A의 모든 요소는 유니크
 * 
 * ### 결과
 * https://app.codility.com/demo/results/trainingZYTXV6-AYR/?showingAll=1
 */
public class Fish {
	public int solution(int[] A, int[] B) {
		Stack<Integer> down = new Stack<>();
		int lastSize;
		int aliveCount = 0;

		for (int i = 0; i < A.length; i++) {
			if (B[i] == 1) down.push(A[i]);
			else {
				while (!down.isEmpty()) {
					lastSize = down.peek();
					if (lastSize > A[i]) break;
					else down.pop();
				}
				if (down.isEmpty()) aliveCount++;
			}
		}
		return aliveCount + down.size();
	}

	public static void main(String[] args) {
		Fish question = new Fish();
		Assert.assertThat(question.solution(new int[] { 4, 3, 2, 1, 5 }, new int[] { 0, 1, 0, 0, 0 }), is(2));
		Assert.assertThat(question.solution(new int[] { 0, 1 }, new int[] { 1, 1 }), is(2));
		Assert.assertThat(question.solution(new int[] { 4, 3, 5, 1, 6 }, new int[] { 1, 0, 1, 0, 0 }), is(1));
		Assert.assertThat(question.solution(new int[] { 4, 3, 5, 1, 6 }, new int[] { 1, 1, 1, 1, 0 }), is(1));
		Assert.assertThat(question.solution(new int[] { 4, 3, 5, 1, 6 }, new int[] { 0, 0, 0, 1, 0 }), is(4));
	}
}
