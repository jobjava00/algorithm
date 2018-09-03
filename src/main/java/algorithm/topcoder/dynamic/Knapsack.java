package algorithm.topcoder.dynamic;

/**
 * 배낭문제
 * 1. 몇 개의 물건이 있고 각 물건에는 무게와 가치라는 2개의 매개변수가 주어짐
 * 2. 일정한 무게까지 물건을 배낭에 넣을 수 있음
 * 3. 가치의 합계가 최대가 되려면 물건을 배낭에 어떻게 넣어야 하는가!
 */
public class Knapsack {
    int[] ws = {3,4,1,2,3};
    int[] ps = {2,3,2,3,6};
    int[][] dp = new int[6][11];
    int maxw = 10;
    int ret = 0;

    public void knapsack(int n, int w, int p){
        if(w > maxw) return;
        ret = Math.max(ret, p);
        if( n >= ws.length) return;
        knapsack(n + 1, w, p);
        knapsack(n + 1, w + ws[n], p + ps[n]);
    }

    public int knapsack2(int n, int w){
        if(w > maxw) return -1;
        if( n >= ws.length) return 0;
        return Math.max(knapsack2(n + 1, w), knapsack2(n + 1, w + ws[n]) + ps[n]);
    }

    public int knapsack3(int n, int w){
        if(w > maxw) return -1;
        if( n >= ws.length) return 0;
        if(dp[n][w] > 0) return dp[n][w];
        return dp[n][w] = Math.max(knapsack3(n + 1, w), knapsack3(n + 1, w + ws[n]) + ps[n]);
    }
}
