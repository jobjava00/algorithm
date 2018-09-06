package algorithm.codility.lesson2;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

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
