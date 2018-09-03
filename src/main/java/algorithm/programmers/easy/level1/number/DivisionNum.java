package algorithm.programmers.easy.level1.number;

import java.util.Arrays;

/**
 * 나누에 떨어지는 숫자배열
 * <p>
 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수,
 * solution을 작성해주세요.
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 * 제한사항
 * arr은 자연수를 담은 배열입니다.
 * 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
 * divisor는 자연수입니다.
 * array는 길이 1 이상인 배열입니다
 */
public class DivisionNum {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter(n -> n % divisor == 0)
                .sorted()
                .toArray();

        if (answer.length == 0) {
            return new int[]{-1};
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 7, 10};
        int divisor = 5;
        DivisionNum question = new DivisionNum();
        System.out.println(Arrays.toString(question.solution(arr, divisor)));

        arr = new int[]{2, 36, 1, 3};
        divisor = 1;
        System.out.println(Arrays.toString(question.solution(arr, divisor)));

        arr = new int[]{3, 2, 6};
        divisor = 10;
        System.out.println(Arrays.toString(question.solution(arr, divisor)));
    }
}