package algorithm.codility.lesson1;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

/**
 * Iterations
 *
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * <p>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 * <p>
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 * <p>
 * 2진갭 : N의 2진수에서 1로 둘러쌓인 연속적인 0의 최대 수
 *
 * result : https://app.codility.com/demo/results/trainingXWB8X8-76E/
 */
public class BinaryGap {
    public int solution(int N) {
        String binaryStr = Integer.toBinaryString(N);
        int length = binaryStr.length();
        int maxSequence = 0;
        int sequence = 0;

        for (int i = 0; i < length; i++) {
            if ('1' == binaryStr.charAt(i)) {
                maxSequence = Math.max(sequence, maxSequence);
                sequence = 0;
            } else sequence++;
        }
        return maxSequence;
    }

    public static void main(String[] args) {
        BinaryGap question = new BinaryGap();
        Assert.assertThat(question.solution(9), is(2));
        Assert.assertThat(question.solution(15), is(0));
        Assert.assertThat(question.solution(32), is(0));
        Assert.assertThat(question.solution(20), is(1));
        Assert.assertThat(question.solution(328), is(2));
        Assert.assertThat(question.solution(529), is(4));
        Assert.assertThat(question.solution(1041), is(5));

    }
}
