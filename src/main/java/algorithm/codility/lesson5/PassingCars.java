package algorithm.codility.lesson5;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 * Prefix Sums
 * <p>
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 * <p>
 * Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 * <p>
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * the function should return 5, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.

 ### 해석
 * 배열 A : N개의 정수로 이루어짐
 * A의 요소들은 도로상의 차들을 의미함.
 * - 0 : 동쪽으로 이동하는 차
 * - 1 : 서쪽으로 이동하는 차
 * (P, Q) : P는 동쪽으로 이동하는 차, Q는 서쪽으로 이동하는 차
 * 0 ≤ P < Q < N
 * 1,000,000,000 초과하면 차의 쌍 수는 -1 리턴
 * 서로 지나가는 차의 쌍 수를 리턴하라!

 ### 풀이
 * P보다 작은 값은 제외
 * (동쪽으로 이동하는 차) * (그 이후에 서쪽으로 이동하는 차)
 * ex) A[0] = 0, A[1] = 1, A[2] = 0, A[3] = 1, A[4] = 1
 * A[0] 동쪽으로 이동 차량 + 1
 * A[1] 동쪽으로 이동 차량 * 서쪽으로 이동하는 차 = 1 * 1 = 1
 * A[2] 동쪽으로 이동 차량 + 1
 * A[3] 동쪽으로 이동 차량 * 서쪽으로 이동하는 차 = 2 * 1 = 2
 * A[4] 동쪽으로 이동 차량 * 서쪽으로 이동하는 차 = 2 * 1 = 2
 * 총합 5

 ### 제약사항
 * N의 범위는 정수 [1..100,000]
 * A의 각 요소의 값은 0, 1 중의 하나를 가진다.
 *
 * 결과 : https://app.codility.com/demo/results/trainingBJ5CRZ-U2C/?showingAll=1
 */
public class PassingCars {
    /**

     */
    public int solution(int[] A) {
        int pCount = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (0 == A[i]) pCount++;
            else {
                sum += pCount * A[i];
                if(sum > 1000000000) return -1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        PassingCars question = new PassingCars();
        Assert.assertThat(question.solution(new int[]{0, 1, 0, 1, 1}), is(5));
        Assert.assertThat(question.solution(new int[]{0, 0, 0, 1, 1}), is(6));
        Assert.assertThat(question.solution(new int[]{1, 1, 0, 1, 1}), is(2));
    }
}
