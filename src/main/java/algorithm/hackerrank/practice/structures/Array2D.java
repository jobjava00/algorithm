package algorithm.hackerrank.practice.structures;

import org.junit.Assert;

import static org.hamcrest.core.Is.is;

/**
 * 6 * 6 인 2차원 배열
 * 모래시계들의 합을 구해서 최대 합을 갖는 모래시계의 합을 출력하라.
 * https://www.hackerrank.com/challenges/java-2d-array/problem
 */
public class Array2D {
    public int solution(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int sum;

        for (int i = 2; i < 6; i++) {
            for (int j = 2; j < 6; j++) {
                sum = arr[i][j] + arr[i][j - 1] + arr[i][j - 2]
                        + arr[i - 1][j - 1]
                        + arr[i - 2][j] + arr[i - 2][j - 1] + arr[i - 2][j - 2];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        Array2D question = new Array2D();
        Assert.assertThat(question.solution(new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        }), is(7));

        Assert.assertThat(question.solution(new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        }), is(19));

        Assert.assertThat(question.solution(new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 9, 2, -4, -4, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, -1, -2, -4, 0}
        }), is(13));
    }
}
