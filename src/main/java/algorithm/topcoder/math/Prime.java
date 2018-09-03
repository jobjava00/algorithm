package algorithm.topcoder.math;

/**
 * 소수 판정
 */
public class Prime {
    /**
     * O(n) 방법
     * @param n
     * @return
     */
    public boolean isPrime(int n){
        if(n < 2) return false;
        for (int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    /**
     * O(√n) 방법
     * @param n
     * @return
     */
    public boolean isPrime2(int n){
        if(n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
