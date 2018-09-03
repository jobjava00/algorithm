package algorithm.programmers.easy.level1.string;

import org.junit.Assert;

/**
 * 문자열 내 p와 y의 개수
 *
 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
 * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
 * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 * 예를들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.
 * 제한사항
 * 문자열 s의 길이 : 50 이하의 자연수
 * 문자열 s는 알파벳으로만 이루어져 있습니다.
 */
public class StringCount {
    public boolean solution(String s) {
        s = s.toUpperCase();

        char[] checkChar = {'P', 'Y'};
        int pCount = 0, yCount = 0;

        char[] inputChar = s.toCharArray();
        for (char c : inputChar) {
            if (c == checkChar[0]) pCount++;
            if (c == checkChar[1]) yCount++;
        }
        return pCount == yCount;
    }

    //아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String args[]) {
        StringCount strToInt = new StringCount();
        Assert.assertTrue(strToInt.solution("pPoooyY"));
        Assert.assertFalse(strToInt.solution("Pyy"));
    }
}
