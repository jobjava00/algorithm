package algorithm.codility.lesson2;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 ### 해석
 * 배열 A : N개의 정수로 이루어진 배열
 * 배열의 Rotation : 각 요소가 하나의 인덱스만큼 오른쪽으로 이동
 * 배열의 마지막 요소에서 이동하면 제일 처음으로 이동
 * 배열 A를 K번째 회전한 배열을 리턴하라!

 ### 풀이
 * K번째 이동은 결국 A의 length 내에서의 이동이다.

 ### 제약사항
 * N,K의 범위는 정수 [0..100]
 * 배열 A의 각 요소의 범위는 정수 [−1,000..1,000]
 * 정확성에 초점.
 */
public class CyclicRotation {
    /**
     * K번째 이동은 결국 A의 length 내에서의 이동이다.
     * @param A
     * @param K
     * @return
     */
    public int[] solution(int[] A, int K) {
        int length = A.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int index = (K + i) % length;
            result[index] = A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        CyclicRotation question = new CyclicRotation();
        Assert.assertThat(question.solution(new int[]{3, 8, 9, 7, 6}, 3), is(new int[]{9, 7, 6, 3, 8}));
        Assert.assertThat(question.solution(new int[]{0, 0, 0}, 1), is(new int[]{0, 0, 0}));
        Assert.assertThat(question.solution(new int[]{1, 2, 3, 4}, 4), is(new int[]{1, 2, 3, 4}));
    }
}
