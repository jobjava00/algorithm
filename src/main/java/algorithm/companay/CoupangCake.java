package algorithm.companay;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class CoupangCake {

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
        CoupangCake question = new CoupangCake();

        Assert.assertEquals(1, question.solution(new int[]{23, 61, 46}));
        Assert.assertEquals(2, question.solution(new int[]{44, 33, 69, 62}));
    }
}
