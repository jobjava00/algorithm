package algorithm.programmers.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문제 설명
 * You have several sticks of different lengths, and a stick case of a fixed length.
 * <p>
 * We want to find 2 sticks that just fit in the case.
 * <p>
 * ⚠️ Please describe algorithm complexity as comment.
 * <p>
 * Input
 * [L1] [L2] ... [LN]
 * [target]
 * The first line of input contains a list of integers separated by a whitespace. This list represents the lengths of the sticks.
 * <p>
 * The second line of input contains an integer target. This integer represents the length of the case.
 * <p>
 * Output
 * Output a pair of lengths whose sum is equal to target.
 * <p>
 * [La] [Lb]
 * Output should be ordered in ascending order. (e.g. 1 2 is acceptable. 2 1 is not)
 * <p>
 * If you find 2 or more pairs, output the pair which contains the stick of the shortest length. (e.g. If the target is 5, and you find both 1 4 and 2 3, output 1 4)
 * <p>
 * In case there is no such pairs, output a single -1
 * <p>
 * -1
 * Input Example
 * 1 2 3 4 5
 * 6
 * Output Example
 * 1 5
 * <p>
 * 문제 해석
 * <p>
 * 각자 다른 길이의 스틱이 있고 스틱 케이스는 길이가 고정되어 있다.
 * 이 케이스에 따 맞는 2개의 스틱을 찾아라!
 * <p>
 * 첫번째 줄은 integer의 리스트이고 공백으로 구분되어 있다. 이 것은 스틱들의 길이를 나타낸다.
 * 두번째 줄은 target 의 integer 이다. 이것은 케이스의 길이를 나타낸다.
 * <p>
 * 출력은 스틱 쌍의 길이 합이 target 과 같다.
 * <p>
 * 출력은 오름차순 정렬이 되어야 한다.( 1 2 => ok, 2 1 => not ok)
 * <p>
 * 만약 2개 이상의 쌍을 찾으면 가장 짧은 길이의 스틱을 포함한 것을 리턴한다.( target = 5, 1 4 and 2 3  => 1 4)
 * <p>
 * 케이스의 맞는 쌍이 없으면 -1 을 출력한다.
 */
public class Sticks {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String output = "-1";

        String[] sticks = input.split(" ");
        int target = Integer.parseInt(br.readLine());

        Stack<Integer> shortestStack = new Stack<>();

        for (int i = 0; i < sticks.length - 1; i++) {
            int lengthA = Integer.parseInt(sticks[i]);

            for (int j = i + 1; j < sticks.length; j++) {
                int lengthB = Integer.parseInt(sticks[j]);
                int sum = lengthA + lengthB;

                if (sum == target) {
                    int min = Math.min(lengthA, lengthB);
                    int max = Math.max(lengthA, lengthB);

                    if (shortestStack.isEmpty()) {
                        shortestStack.push(min);
                        output = min + " " + max;
                    } else {
                        if (min < shortestStack.peek()) {
                            shortestStack.pop();
                            shortestStack.push(min);
                            output = min + " " + max;
                        }
                    }
                }
            }
        }
        System.out.println(output);
    }
}

