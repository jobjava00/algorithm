package algorithm.topcoder.rangesearch;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class AutoLoanTests {
    private AutoLoan autoLoan = new AutoLoan();

    @Test
    public void testInterestRate() {
        double price = 6800;
        double monthlyPayment = 100;
        int loanTerm = 68;

        double result = autoLoan.interestRate(price, monthlyPayment, loanTerm);
        System.out.println(result);
        assertTrue(0.00 == result);


        price = 2000;
        monthlyPayment = 510;
        loanTerm = 4;
        result = autoLoan.interestRate(price, monthlyPayment, loanTerm);
        System.out.println(result);
        assertTrue(9.56 == result);

        price = 15000;
        monthlyPayment = 364;
        loanTerm = 48;
        result = autoLoan.interestRate(price, monthlyPayment, loanTerm);
        System.out.println(result);
        assertTrue(7.68 == result);
    }

    @Test
    public void alTest(){
        int test =3;
        int res = test % 2;
        System.out.println(res);

        test =4;
        res = test % 2;
        System.out.println(res);
    }

    public static class ReverseStr {
        public String reverseStr(String str) {
            char[] sol = str.toCharArray();
            Arrays.sort(sol);
            return new StringBuilder(new String(sol)).reverse().toString();
        }


        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        public static void main(String[] args) {
            ReverseStr rs = new AutoLoanTests.ReverseStr();
            System.out.println( rs.reverseStr("Zbcdefg") );

            System.out.println( rs.reverseStr("ZbCdEfg") );
        }
    }
}
