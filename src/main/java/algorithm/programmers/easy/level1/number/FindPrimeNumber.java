package algorithm.programmers.easy.level1.number;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

/**
 * 소수 찾기
 * <p>
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * (1은 소수가 아닙니다.)
 * 제한 조건
 * n은 2이상 1000000이하의 자연수입니다.
 */
public class FindPrimeNumber {
    //에라토스토네스의 체 사용
    public int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n + 1];
        prime[0] = false;
        prime[1] = false;

        //초기 정수 설정
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        //i의 제곱근이 n을 초과하기 전까지 구함
        for (int i = 2; i * i <= n; i++) {
            //소수 아닌것만 가져옴
            if (!prime[i]) {
                continue;
            }
            //소수의 배수는 모두 소수가 아님
            for (int j = i * i; j <= n; j += i) {
                prime[j] = false;
            }
        }

        //소수 개수 구함
        for (int i = 0; i <= n; i++) {
            if (prime[i]) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int request = 10;
        FindPrimeNumber findMiddle = new FindPrimeNumber();
        Assert.assertThat(findMiddle.solution(request), is(4));

        request = 5;
        Assert.assertThat(findMiddle.solution(request), is(3));

        request = 100;
        Assert.assertThat(findMiddle.solution(request), is(25));
    }
}
