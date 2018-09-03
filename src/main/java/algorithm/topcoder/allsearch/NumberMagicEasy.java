package algorithm.topcoder.allsearch;

/**
 * 마법의 숫자
 * 1. 16이하 양의 정수로 이루어진 카드가 4장 있다
 * 2. 각 카드는 {1,2,3,4,5,6,7,8}, {1,2,3,4,9,10,11,12}, {1,2,5,6,9,10,13,14}, {1,3,5,7,9,11,13,15} 로 이루어짐
 * 2. 입력 받은 대답으로 카드 안에 쓰여진 숫자에 포함 된 숫자 맞추기!
 */
public class NumberMagicEasy {
    /**
     * 각 문자를 비교
     * @param answer
     * @return
     */
    public int theNumber(String answer) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] B = {1, 2, 3, 4, 9, 10, 11, 12};
        int[] C = {1, 2, 5, 6, 9, 10, 13, 14};
        int[] D = {1, 3, 5, 7, 9, 11, 13, 15};

        for (int i = 1; i <= 16; i++) {
            if (check(A, i) != answer.charAt(0)) continue;
            if (check(B, i) != answer.charAt(1)) continue;
            if (check(C, i) != answer.charAt(2)) continue;
            if (check(D, i) != answer.charAt(3)) continue;
            return i;
        }
        return 0;
    }

    public char check(int[] X, int number) {
        for (int x : X) {
            if (x == number) return 'Y';
        }
        return 'N';
    }

    /**
     * 숫자에 대한 조합을 문자열로 모두 저장 후 비교
     * @param answer
     * @return
     */
    public int theNumber2(String answer) {
        String[] c = {
                "YYYYYYYYNNNNNNNN",
                "YYYYNNNNYYYYNNNN",
                "YYNNYYNNYYNNYYNN",
                "YNYNYNYNYNYNYNYN"
        };

        for (int i = 0; i <= 15; i++) {
            String temp = "";
            for(int j=0; j<4; j++) temp += c[j].charAt(i);
            if (answer.equals(temp)) return i+1;
        }
        return 0;
    }

    /**
     * 각 숫자별로 카드에 포함되면 Y, 포함되지 않으면 N 으로 비트 계산을 하여
     * 모든 대답 조합을 추출함
     * 추출된 대답 조합을 문자열에 저장 후 비교
     * @param answer
     * @return
     */
    public int theNumber3(String answer) {
        String[] c = {
                "YYYY",
                "YYYN",
                "YYNY",
                "YYNN",
                "YNYY",
                "YNYN",
                "YNNY",
                "YNNN",
                "NYYY",
                "NYYN",
                "NYNY",
                "NYNN",
                "NNYY",
                "NNYN",
                "NNNY",
                "NNNN"
        };

        for (int i = 0; i <= 15; i++) {
            if (answer.equals(c[i])) return i+1;
        }
        return 0;
    }

}
