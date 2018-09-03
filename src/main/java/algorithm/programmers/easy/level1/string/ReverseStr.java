package algorithm.programmers.easy.level1.string;

import java.util.Arrays;

/**
 * 문자열 내림차순으로 배치하기
 *
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 * 제한 사항
 * str은 길이 1 이상인 문자열입니다.
 */
public class ReverseStr {
    public String solution(String s) {
        char[] sol = s.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        ReverseStr rs = new ReverseStr();
        System.out.println(rs.solution("Zbcdefg"));
    }
}
