package algorithm.topcoder.dynamic;

/**
 * 깊이 우선 탐색
 * 1. 높이 5, 넓이 4 인 격자
 * 2. 입력값 (nowh,noww) 에서 (h, w)에 도착하기 위한 경우의 수를 구하라!
 */
public class DepthFirstSearch {
    final int h = 5;
    final int w = 4;
    int[][] dp = new int[h + 1][w + 1];
    int[][] dp2 = new int[h + 1][w + 1];

    /**
     * 일반적인 재귀 사용 - 입력 좌표에서 좌표(h, w)을 찾아가는 하향식 방법
     *
     * @param nowh
     * @param noww
     * @return
     */
    public int dfs(int nowh, int noww) {
        if (nowh > h || noww > w) return 0;
        if (nowh == h && noww == w) return 1;
        return dfs(nowh + 1, noww) + dfs(nowh, noww + 1);
    }

    /**
     * 매모화 재귀 사용 - 입력 좌표에서 좌표(h, w)을 찾아가는 하향식 방법
     * 탐색 결과
     * 저장되어 있을 경우 - 그 값을 리턴
     * 저장되어 있지 않을 경우 - 일반적인 탐색을 수행하고 결과를 배열에 저장 후 리턴
     *
     * @param nowh
     * @param noww
     * @return
     */
    public int dfs2(int nowh, int noww) {
        if (nowh > h || noww > w) return 0;
        if (nowh == h && noww == w) return 1;
        if (dp[nowh][noww] != 0) return dp[nowh][noww];
        return dp[nowh][noww] = dfs(nowh + 1, noww) + dfs(nowh, noww + 1);
    }


    public DepthFirstSearch(){
        dp2[0][0] = 1;
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= w; j++) {
                if (i != 0) dp2[i][j] += dp2[i - 1][j];
                if (j != 0) dp2[i][j] += dp2[i][j - 1];
            }
        }
    }

    /**
     * 동적 계획법을 사용한 해법 -  초기좌표(0,0)에서 입력 좌표로 찾아가는 상향식 방법
     * 지정좌표까지 오는 바업ㅂ이 몇가지나 있었는지를 메모해서 계산함
     *  초기 생성자에서 미리 계산 된 값을 넣어주고 해당 좌표만 넣어주면 나옴
     * @param nowh
     * @param noww
     * @return
     */
    public int dfs3(int nowh, int noww) {
        return dp2[nowh][noww];
    }
}
