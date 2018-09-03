package algorithm.programmers.easy.level1.string;

import org.junit.Assert;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;

/**
 * 시저 암호
 *
 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
 * 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다.
 * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 * 제한 조건
 * 공백은 아무리 밀어도 공백입니다.
 * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
 * s의 길이는 8000이하입니다.
 * n은 1 이상, 25이하인 자연수입니다.
 */
public class CaesarCipher {

    public String solution(String s, int n) {
        return s.chars()
                .map(c -> {
                    char temp = (char) c;
                    if (!Character.isSpaceChar(temp)) c += n;
                    if (Character.isUpperCase(temp) && c > 90) c -= 26;
                    else if (Character.isLowerCase(temp) && c > 122) c -= 26;
                    return c;
                })
                .mapToObj(c -> String.valueOf((char) c))
                .reduce((a, b) -> a + b).orElse("");
    }

    public String mySolution(String s, int n) {
        return s.chars().mapToObj(c -> {
            char temp = (char) c;

            if (!Character.isSpaceChar(temp)) c += n;
            if (Character.isUpperCase(temp) && c > 90) c -= 26;
            else if (Character.isLowerCase(temp) && c > 122) c -= 26;

            return String.valueOf((char) c);
        }).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        CaesarCipher problem = new CaesarCipher();
        Assert.assertThat(problem.solution("AB", 1), is("BC"));
        Assert.assertThat(problem.solution("z", 1), is("a"));
        Assert.assertThat(problem.solution("a B z", 4), is("e F d"));
    }
}
