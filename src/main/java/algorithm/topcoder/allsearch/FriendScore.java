package algorithm.topcoder.allsearch;

/**
 * 친구 수
 * 1. 서로 친구라면 친구
 * 2. C가 A와 B와 친구라면 A, B도 서로 친구
 * 3. 가장 친구가 많은 사람의 친구 수를 구하라!
 */
public class FriendScore {
    public int highestScore(String[] friends){
        int size = friends.length;
        int ans = 0;

        for(int i=0; i<size; i++){
            int cnt = 0;
            for(int j =0; j<size; j++){
                if(i == j){
                    continue;
                }

                char origin = friends[i].charAt(j);
                if('Y' == origin){
                    cnt ++;
                }else{
                    for(int k=0; k<size; k++){
                        if('Y' == friends[k].charAt(j) && 'Y' == friends[i].charAt(k)){
                            cnt ++;
                            break;
                        }
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
