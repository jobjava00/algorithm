package algorithm.programmers.easy.level1.string;

/**
 * 가운데 글자 가져오기
 *
 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
 * 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 * 재한사항
 * s는 길이가 1 이상, 100이하인 스트링입니다.
 */
public class FindMiddle {
    public String solution(String s) {
        int length = s.length();
        return s.substring((length - 1) / 2, (length / 2) + 1);
    }

    public static void main(String[] args) {
        String s = "abcde";
        FindMiddle findMiddle = new FindMiddle();
        System.out.println(findMiddle.solution(s));

        s = "qwer";
        System.out.println(findMiddle.solution(s));
    }
}
