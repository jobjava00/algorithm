package algorithm.codility.lesson2;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 * Arrays
 *
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given
 * <p>
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 * <p>
 * A = [0, 0, 0]
 * K = 1
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * <p>
 * A = [1, 2, 3, 4]
 * K = 4
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * <p>
 * A 배열을 K 번째 오른쪽으로 이동 시킨 배열을 리턴하라
 * 배열의 마지막에서 이동하면 배열의 처음으로 이동한다
 * <p>
 * N : 배열 개수 [0..100]
 * K : shift 횟수 [0..100]
 * A : [-1,000..1,000] 의 수로 이루어진 배열
 *
 * result : https://app.codility.com/demo/results/trainingNR76M6-X5P/
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
