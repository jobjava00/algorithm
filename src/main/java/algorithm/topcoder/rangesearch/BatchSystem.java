package algorithm.topcoder.rangesearch;

import java.util.HashMap;

/**
 * 배치 시스템
 * 1. 작업을 완료 하는데 필요한 합계 시간 - int[] duration
 * 2. 작업을 요청한 사용자 - String[] user
 * 3. 한 사람의 사용자는 여러 개의 작업을 요청 할 수 있다.
 * 4. 컴퓨터는 한 번에 1개의 작업만을 처리 할 수 있다.
 * 5. 사용자의 대기 시간은 해당 사용자가 의뢰한 모든 작업이 완료 될 때까지 기다리는 시간이다.
 * 6. 프로그램은 모든 사용자의 평균 대기 시간을 최소화 하여야 한다.
 * 7. 0부터 n개의 작업 번호를 처리 순서로 리턴하고 여러 결과가 나온다면 사전 순서로 정리해서 가장 앞의 결과로 리턴하라!
 */
public class BatchSystem {
    public int[] schedule(int[] duration, String[] user){
        int N = duration.length;

        HashMap<String, Long> jobTime = new HashMap<String, Long>();

        //초기 설정
        for (int n = 0; n < N; n++) {
            jobTime.put(user[n], 0L);
        }
        //같은 이름의 유저 있으면 대기 시간 더해 줌
        for (int n = 0; n < N; n++) {
            jobTime.put(user[n], jobTime.get(user[n]) + duration[n]);
        }

        boolean[] done = new boolean[N];
        int[] ans = new int[N];
        int ansCount = 0;
        while (ansCount < N){
            String next = "";
            for (int n = 0; n < N; n++) {
                if(!done[n] && (next.equals("") || jobTime.get(user[n]) < jobTime.get(next))){
                    next = user[n];
                }
            }

            for (int n = 0; n < N; n++) {
                if(user[n].equals(next)){
                    done[n] = true;
                    ans[ansCount++] = n;
                }
            }
        }
        return ans;
    }
}
