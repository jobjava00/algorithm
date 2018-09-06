package algorithm.codility.lesson1;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

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
