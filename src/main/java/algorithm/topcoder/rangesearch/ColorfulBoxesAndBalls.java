package algorithm.topcoder.rangesearch;

/**
 * 다양한 색상의 상자와 공
 * 1. numRed 개의 붉은 상자 numBlue개의 파란 상자 numRed 개의 붉은 공 numBlue 개의 파란 공이 있다
 * 2. 각 상자에는 1개의 공만 넣을 수 있다
 * 3. 붉은 상자에 붉은 공이 들어가면 onlyRed 점수를 얻는다.
 * 4. 파란 상자에 파란 공이 들어가면 onlyBlue 점수를 얻는다.
 * 5. 나머지 경우에는 bothColors 점수를 얻는다.
 * 6. 얻을 수 있는 최대 점수를 구하라!
 */
public class ColorfulBoxesAndBalls {
    public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors){
        int ans = Integer.MIN_VALUE;
        int change = Math.min(numRed, numBlue);

        for (int i = 0; i <= change; i++) {
            int myscore = (numRed - i) * onlyRed + (numBlue - i) * onlyBlue + (2 * i * bothColors);
            ans = Math.max(ans, myscore);
        }
        return ans;
    }
}
