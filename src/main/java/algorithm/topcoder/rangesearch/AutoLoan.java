package algorithm.topcoder.rangesearch;

/**
 * 자동차 대출
 * 1. 대출 초기 잔액은 price 이다
 * 2. monthlyPayment 만큼의 금액을 loanTerm 개월 만큼 지불하면 자동차를 살 수 있다.
 * 3. 대출의 연 이자율(%)을 double 자료형으로 리턴하라!
 */
public class AutoLoan {
    public double interestRate(double price, double monthlyPayment, int loanTerm) {
        double balance;
        double high = 100;
        double low = 0;
        double mid = 0;

        //오차 판정
        while ((1e-9 < (high - low) && (1e-9 < (high - low) / high))) {
            balance = price;
            mid = (high + low) / 2;

            for (int j = 0; j < loanTerm; j++) {
                balance *= mid / 1200 + 1;  //12개월이라서 1200으로 나눠지고 원금에 더해주기 위해 + 1 해줌
                balance -= monthlyPayment;
            }

            if (0 < balance) high = mid;
            else low = mid;
        }

        return Math.floor(mid * 100d) / 100d;
    }
}
