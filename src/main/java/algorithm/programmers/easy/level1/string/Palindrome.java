package algorithm.programmers.easy.level1.string;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

/**
 * 가장 긴 팰린드롬
 *
 * 앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
 * 문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.
 * 예를들면, 문자열 s가 abcdcba이면 7을 return하고 abacde이면 3을 return합니다.
 * 제한사항
 * 문자열 s의 길이 : 2500 이하의 자연수
 * 문자열 s는 알파벳 소문자로만 구성
 */
public class Palindrome {
    //manacher 알고리즘 사용
    public int solution(String s) {
        int A[] = new int[2501 * 2];
        String str = "";

        //짝수 부분 문자열의 팰린드롬을 구하기 위해 # 추가
        for (int i = 0; i < s.length(); i++) {
            str += '#';
            str += s.charAt(i);
        }
        str += '#';
        int N = str.length();

        int r = 0;    //각 인덱스 별 팰린드롬이 될 수 있는 최대 범위
        int p = 0;    //r이 형성되고 있는 중심 인덱스 번호
        int ans = 1;  //최대 팰린드롬 길이

        for (int i = 0; i < N; i++) {
            //A[i]의 초기값 결정
            if (i > r)
                A[i] = 0;
            else    //i는 p를 중심으로 한 회문에 속함 그 회문에서 i의 대칭점은 2p - i 이고 A[i]의 초기값은 min(A[2 * p - i], r - i)min(A[2p - i], r - i)
               A[i] = Math.min(A[2 * p - i], r - i);

            //str.charAt(i - A[i] - 1) 와 str.charAt(i + A[i] + 1) 같으면 A[i] 증
            while (i - A[i] - 1 >= 0 && i + A[i] + 1 < N
                    && str.charAt(i - A[i] - 1) == str.charAt(i + A[i] + 1))
                A[i]++;

            if (r < i + A[i]) {
                r = i + A[i];
                p = i;
                ans = Math.max(ans, A[p]);
            }

        }
        return ans;
    }

    public int solution2(String s) {
        int size = s.length();
        int answer = 0;

        String str;
        String reverseStr;
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = size; j > 0; j--) {
                str = s.substring(i, j);
                int strLength = str.length();
                if (strLength <= answer) {
                    break;
                }
                reverseStr = temp.append(str).reverse().toString();
                temp.delete(0, strLength);
                if (str.equals(reverseStr)) {
                    answer = Math.max(answer, strLength);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "abcba";
        Palindrome question = new Palindrome();
        Assert.assertThat(5, CoreMatchers.is(question.solution(s)));

        s = "abacde";
        Assert.assertThat(3, CoreMatchers.is(question.solution(s)));

        s = "abaabbabc";
        Assert.assertThat(4, CoreMatchers.is(question.solution(s)));

        s = "abaabbabc";
        Assert.assertThat(4, CoreMatchers.is(question.solution(s)));

        s = "bcabacde";
        Assert.assertThat(5, CoreMatchers.is(question.solution(s)));

        long start = System.currentTimeMillis();
        s = "bcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsjlfdkfhdkjafhkjewrhdfhfdalfjdlafjdlcvjdljvldjasfldjflajfldjfldsjfldsajfldjflajfdljflajfljewrwpeipefipdifadfbcabacdesadfjldsafjlkdaflkjdaldsfsdfkjreroudfjsdflasfdsjfaslfjdlfdsafjlkfdafjladsdsjfaslfjdlfdsafjlkfdafjladsdsjfaslfjdlfdsafjlkfdafjladsdsjfaslfjdlfdsafdsafjlkfdafjladsdsjfaslfjdlfdsafdsafjlkfdafjladsdsjfaslfjdlfdsafdsafjlkfdafjladsdsjfaslfjdl";
        Assert.assertThat(5, CoreMatchers.is(question.solution(s)));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
