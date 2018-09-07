package algorithm.codility.lesson2;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;

/**
 ### 해석
 * 배열 A : N개의 정수로 이루어진 비어있지 않는 배열
 * 배열은 홀수 개의 요소들로 구성
 * 배열의 각 요소는 다른 요소와 같은 값으로 쌍을 이룬다.
 * 한개의 요소는 쌍을 이루지 않음.
 * 쌍을 이루지 않는 값을 리턴하라!

 ### 풀이
 * 비트 연산 활용 - XOR로 각 요소가 페어하게 발생했는지 체크

 ### 제약사항
 * N은 홀수 개이고 범위는 정수 [1..1,000,000]
 * 배열 A의 각 요소의 범위는 정수 [1..1,000,000,000]
 * A의 값 중 하나를 제외하고 모두 짝수번 발생
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        int temp = 0;
        for (int i = 0; i < A.length; ++i) {
            temp = temp ^ A[i];
        }
        return temp;
    }

    public int solution2(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : A) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        return set.iterator().next();
    }

    public int mySolution(int[] A) {
        HashMap map = new HashMap<Integer, Boolean>();
        int result = 0;
        for (int num : A) {
            if (null == map.get(num)) { //초기 값 저장
                map.put(num, false);
                result = num;
            } else {
                if (false == (boolean) map.get(num)) {  //pair 처리
                    map.put(num, true);
                } else {    //unpair 처리
                    map.put(num, false);
                    result = num;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray question = new OddOccurrencesInArray();
        Assert.assertThat(question.solution(new int[]{9, 3, 9, 3, 9, 7, 9}), is(7));
        Assert.assertThat(question.solution(new int[]{1, 2, 3, 1, 2, 3, 1}), is(1));
        Assert.assertThat(question.solution(new int[]{1, 9, 3, 3, 4, 9, 1}), is(4));
        Assert.assertThat(question.solution(new int[]{1, 1, 1, 1, 2}), is(2));
    }
}
