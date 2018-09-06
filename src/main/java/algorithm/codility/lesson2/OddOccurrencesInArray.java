package algorithm.codility.lesson2;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;

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
