package algorithm.topcoder.rangesearch;

/**
 * 주식 투자 시뮬레이션
 * 1. 초기 투자로 initialInvestment 사용
 * 2. 매 월 monthlyContrinution 만큼 사용
 * 3. 매 월 시작에 주식을 구매 하고 최후에 가지고 있는 모든 주식을 판매
 * 4. 기간 중에는 가진 주식을 팔지 않는다.
 * 5. 각 요소에 매월 초의 각 주식 값이 있는 stockPrices 가 주어짐
 * 6. 기간의 끝에서 얻을 수 있는 최대 수익을 반환 하라! - 소수 부분은 반올림
 */
public class StockHistory {
    public int maximumEarnigs(int initialInvestment, int monthyContribution, String[] stockPrices){
        int money = initialInvestment;
        int month = stockPrices.length;
        int corp = stockPrices[0].split(" ").length;

        int[][] prices = new int[month][corp];
        double max = 0;
        double profit = 0;
        double[] proportion = new double[month - 1];
        boolean[] buy = new boolean[month - 1];

        //처리하기 쉽게 숫자 배열로 변환
        for (int i = 0; i < month; i++) {
            String[] s = stockPrices[i].split(" ");

            for(int j = 0; j < corp; j++){
                prices[i][j] = Integer.valueOf(s[j]);
            }
        }

        //반목문을 역으로 돌려 거슬러 올라가면서
        //각 월까지의 최대 증가율을 사야 하는지 기록
        for (int i = month - 2; 0 <= i; i--) {
            for (int j = 0; j < corp; j++) {
                double p = 1.0 * prices[month - 1][j] / prices[i][j] - 1;
                if(0 < p && max < p){
                    buy[i] = true;
                    max = p;
                    proportion[i] = p;
                }
            }

        }

        //처음부터 시작해서 사야 하는 달이 오면 모든 자금을 투자
        for (int i = 0; i < buy.length; i++) {
            if(buy[i]){
                profit += money * proportion[i];
                money = 0;
            }
            money += monthyContribution;
        }
        return (int)Math.round(profit);
    }
}
