package algorithm.codility.woohyung;

import org.junit.Assert;

import java.util.HashSet;

/**
 * 엘리베이터를 최대한 한번에 타서 각 사람들의 목표 층수에 내릴때 count, 다시 ground floor에 돌아올 때 count
 * 모든 사람들이 내리고 돌아왔을 때 엘리베이터가 멈춘 횟수를 구하라!
 * @author jobjava00
 */
public class Elevator {
	/**
	 * @param A 몸무게
	 * @param B 목표 층수
	 * @param M 최대 층 수
	 * @param X 최대 인원
	 * @param Y 최대 몸무게
	 * @return
	 */
	public int solution(int[] A, int[] B, int M, int X, int Y) {
		int cnt = A.length;
		int totalStop = 0;
		int i = 0;

		while (i < cnt){
			int totalWeight = 0;
			int totalPeople = 0;

			HashSet floor = new HashSet();
			while(totalPeople < X && i < cnt && (totalWeight + A[i] <= Y)) {
				totalWeight += A[i];
				floor.add(B[i]);
				i++;
				totalPeople++;
			}
			totalStop = totalStop + floor.size() + 1;
		}
		return totalStop;
	}

	public static void main(String[] args){
		Elevator elevator = new Elevator();
		Assert.assertEquals(5, elevator.solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 5, 2, 200));
		Assert.assertEquals(6, elevator.solution(new int[]{40, 40, 100, 80, 20}, new int[]{3, 3, 2, 2, 3}, 3, 5, 200));
	}
}
