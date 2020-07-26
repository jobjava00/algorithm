package algorithm.companay;

import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;

/**
 * 케익에 촛불을 꽂는다.
 * 초 세트는 0 ~ 9까지의 숫자
 * 6은 9로 쓸 수 있다. 9는 6으로 가능
 * 생일인 사람들의 초를 모두 꽂으려면 총 몇개의 초 세트가 필요한가?
 * ages : [23, 61, 46], result : 1
 * ages : [44, 33, 69, 62], result : 2
 */
public class BirthdayCake {

    public int solution(int[] ages) {
        Map<Integer, Integer> candleMap = new HashMap();

        for (int ageNum : ages) {
            String ageStr = String.valueOf(ageNum);
            for (char candle : ageStr.toCharArray()) {
                int num = Character.getNumericValue(candle);
                if (num == 6 || num == 9)
                    num = 6;

                Integer candleCount = candleMap.get(num);
                int candleSum = candleCount == null ? 1 : candleCount + 1;
                candleMap.put(num, candleSum);
            }
        }

        Map.Entry<Integer, Integer> maxEntry = candleMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();
        return maxEntry.getKey() == 6 ? Math.round(maxEntry.getValue().floatValue() / 2) : maxEntry.getValue();
    }

    public static void main(String args[]) {
        BirthdayCake question = new BirthdayCake();

        Assert.assertEquals(1, question.solution(new int[]{23, 61, 46}));
        Assert.assertEquals(2, question.solution(new int[]{44, 33, 69, 62}));
    }
}
