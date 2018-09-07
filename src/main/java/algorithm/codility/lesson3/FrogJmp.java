package algorithm.codility.lesson3;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 ### 해석
 * 개구리는 길 건너편으로 가길 원함.
 * X : 현재 위치
 * Y : 타겟 위치
 * 개구리는 현재 위치 X 에서 Y 보다 크거나 같은 위치로 가길 원함
 * 개구리는 항상 고정된 거리 D 만큼 점프
 * 개구리가 Y에 도달하는 최소 횟수를 리턴하라!

 ### 풀이
 * (Y - X) / D
 * 소수점은 올림 처리

 ### 제약사항
 * X, Y, D의 범위는 정수 [1..1,000,000,000]
 * X ≤ Y
 */
public class FrogJmp {
	public int solution(int X, int Y, int D) {
		double divideNum = (Y - X) * 1.0 / D;
        return (int) Math.ceil(divideNum);
	}

	public static void main(String[] args) {
		FrogJmp question = new FrogJmp();
		Assert.assertThat(question.solution(10, 85, 30), is(3));
		Assert.assertThat(question.solution(10, 90, 30), is(3));
        Assert.assertThat(question.solution(5, 105, 3), is(34));

	}
}
