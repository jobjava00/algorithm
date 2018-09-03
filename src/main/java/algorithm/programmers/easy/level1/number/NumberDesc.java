package algorithm.programmers.easy.level1.number;

import org.junit.Assert;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

/**
 * 정수 내림차순으로 배치하기
 *
 * 함수 solution은 정수 n을 매개변수로 입력받습니다.
 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 * 제한 조건
 * n은 1이상 8000000000 이하인 자연수입니다.
 */
public class NumberDesc {
    String res = "";

    public long solution(long n) {
        Long.toString(n).chars().sorted()
                .forEach(c -> res = (char) c + res);
        return Long.parseLong(res);
    }

    public long mySolution(long n) {
        String s = String.valueOf(n);
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = s.charAt(i) - '0';
        }
        Arrays.sort(array);

        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return Long.parseLong(new StringBuilder(result).reverse().toString());
    }

    public static void main(String[] args) {
        long request = 118372;
        long result = 873211;
        NumberDesc numberDesc = new NumberDesc();
        Assert.assertThat(numberDesc.solution(request), is(result));
    }
}
