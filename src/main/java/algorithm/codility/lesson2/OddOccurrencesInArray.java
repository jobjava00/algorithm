package algorithm.codility.lesson2;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;

/**
 * Arrays
 *
 * A non-empty array A consisting of N integers is given.
 * <p>
 * The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 * <p>
 * For example, in array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 * <p>
 * Assume that:
 * <p>
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 * <p>
 * 풀이
 * 각 요소는 다른 요소와 쌍을 이룬다.
 * 한 개 남은 요소는 쌍을 이루지 않는다.
 * 쌍을 이루지 않는 요소의 값을 리턴하라.
 * <p>
 * 제약사항
 * N : 홀수 개의 정수로 이루어진 배열, N의 개수 범위 [1..1,000,000]
 * N의 각 요소의 범위 [1..1,000,000,000]
 * A의 값 중 하나를 제외하고는 모든 짝수번 발생
 * <p>
 * 참고 : http://hojak99.tistory.com/314
 * result : https://app.codility.com/demo/results/training9BNNP4-5EB/
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
