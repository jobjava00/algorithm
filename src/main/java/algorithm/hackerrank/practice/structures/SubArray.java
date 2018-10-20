package algorithm.hackerrank.practice.structures;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 * 부분배열
 * 연속적인 부분배열의 합이 음수인 배열의 조합 개수를 리턴하라!
 * https://www.hackerrank.com/challenges/java-negative-subarray/problem
 */
public class SubArray {
    public int solution(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (i != j) {
                    sum += arr[j];
                }
                if (sum < 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        SubArray question = new SubArray();
        Assert.assertThat(question.solution(new int[]{1, -2, 4, -5, 1}), is(9));
    }
}
