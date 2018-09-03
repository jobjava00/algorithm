package algorithm.topcoder.allsearch;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 재미있는 수학
 * 1. 기준 값을 base 진법으로 계산함
 * 2. 계산 된 값의 모든 합은 기준 값의 배수가 됨
 * 3. 0,1을 제외한 위와 같은 성질의 값을 오름차순으로 리턴
 */
public class InterestingDigits {

    /**
     * 전체 탐색으로 구함
     *
     * @param base
     * @return
     */
    public int[] digits(int base) {
        ArrayList<Integer> v = new ArrayList<Integer>();

        for (int n = 2; n < base; n++) {
            boolean ok = true;
            for (int k1 = 0; k1 < base; k1++) {
                for (int k2 = 0; k2 < base; k2++) {
                    for (int k3 = 0; k3 < base; k3++) {
                        if ((k1 + k2 * base + k3 * base * base) % n == 0 && (k1 + k2 + k3) % n != 0) {
                            //n의 배수 숫자로 각 숫자의 합이 n의 배수가 아니면 n을 제외
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) break;
                }
                if (!ok) break;
            }
            if (ok) v.add(n);
        }

        int[] ans = new int[v.size()];

        for (int i = 0; i < v.size(); i++) {
            ans[i] = v.get(i);
        }
        return ans;
    }

    /**
     * an²+bn+c -> ((a(n-1) + b + 2a)(n-1)) + a + b + c
     * 1번째 항 (n-1)의 배수
     * 2번째 항 a + b + c 가 (n-1)의 배수이면 전체 식이 (n-1)의 배수가 됨
     * @param base
     * @return
     */
    public int[] digits2(int base) {
        Vector<Integer> v = new Vector<>();

        for (int i = 2; i < base; i++) {
            if (((base - 1) % i) == 0) v.add(i);
        }

        int[] ans = new int[v.size()];
        for (int i = 0; i < v.size(); i++) {
            ans[i] = v.get(i);
        }
        return ans;
    }
}
