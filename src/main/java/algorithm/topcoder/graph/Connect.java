package algorithm.topcoder.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 정점과 정점이 연결되어 있는가?
 * 1. 정점 0과 정점 1이 연결되어 있는지 판정하라.
 * 2. 정점 0부터 연결되어 있는 정점에 모두 0을 붙인다.
 * 3. 만약 정점 1에 0이라는 이름이 붙어 있으면 정점 0과 정점 1이 붙어 있는 것.
 * 4. 정점 2와 정점이 연결되어 있는지 판정할 때는 정점와 정점에 0이라는 이름이 붙어 있는지만 확인하면 됨..
 */
public class Connect {
    private int[][] edge;   //정점 i의 j번째 변을 나타내는 배열

    /**
     * 정점 from과 정점 to가 연결되어 있는지 판별하는 함수
     * @param from
     * @param to
     * @param v : 정점 수
     * @return
     */
    public boolean isConnect(int from, int to, int v){
        boolean[] dp = new boolean[v];  //연결되어 있는 변에 true를 넣는 배열
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(from);
        dp[from] = true;

        //너비 우선 탐색의 기본적인 구문
        while (!q.isEmpty()){
            int now = q.poll();
            for (int i = 0; i < edge[now].length; i++) {
                int next = edge[now][i];
                if(dp[next]) continue;
                if(next == to) return true;

                dp[next] = true;
                q.add(next);
            }
        }
        return false;
    }
}
