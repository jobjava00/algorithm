package algorithm.topcoder.allsearch;

import java.util.HashMap;

/**
 * 즐거운 파티
 * 1. 각각의 친구들은 2가지 주제에만 관심이 있다.
 * 2. 주제가 맞는 친구들만 초대할 때
 * 3 .파티에 초대할수 있는 최대 친구 수를 구하라.
 */
public class InterestingParty {
    /**
     * 이중 반복문으로 개별 비교해서 최대 수 구함
     * @param first
     * @param second
     * @return
     */
    public int bestInvitation(String[] first, String[] second){
        int size = first.length;
        int ans = 0;
        for(int i=0; i<size; i++){
            int fCount = 0;
            int sCount = 0;
            for(int j=0; j<size; j++){
                if(first[i].equals(first[j])) fCount++;
                if(first[i].equals(second[j])) fCount++;
                if(second[i].equals(first[j])) sCount++;
                if(second[i].equals(second[j])) sCount++;

                ans = Math.max(fCount, ans);
                ans = Math.max(sCount, ans);
            }
        }
        return ans;
    }

    /**
     * 연관 배열로 값 조회해서 증가 시킴
     * 최대 키 값으로 최대 친구 수 구함
     * @param first
     * @param second
     * @return
     */
    public int bestInvitation2(String[] first, String[] second){
        HashMap<String, Integer> dic = new HashMap<>();

        int size = first.length;
        for(int i=0; i<size; i++){
            dic.put(first[i], 0);
            dic.put(second[i], 0);
        }

        for(int i=0; i<size; i++){
            dic.put(first[i], dic.get(first[i]) + 1);
            dic.put(second[i], dic.get(second[i]) + 1);
        }

        int ans = 0;
        for(String key : dic.keySet()){
            ans = Math.max(ans, dic.get(key));
        }
        return ans;
    }
}
