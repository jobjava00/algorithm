package algorithm.topcoder.math;

/**
 * 최대공약수 구하기
 */
public class Gcd {

    public int gcd(int a, int b){
        for (int i = Math.min(a, b); i >= 2; i--) {
            if(a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }
}
