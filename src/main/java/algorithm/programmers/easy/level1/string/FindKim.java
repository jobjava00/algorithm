package algorithm.programmers.easy.level1.string;

import java.util.Arrays;

/**
 * 김서방 찾기
 *
 * String형 배열 seoul의 element중 Kim의 위치 x를 찾아,
 * 김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요.
 * seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
 */
public class FindKim {
    public String findKim(String[] seoul) {
        //x에 김서방의 위치를 저장하세요.
        int x = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + x + "에 있다";
    }

    // 실행을 위한 테스트코드입니다.
    public static void main(String[] args) {
        FindKim kim = new FindKim();
        String[] names = {"Queen", "Tod", "Kim"};
        System.out.println(kim.findKim(names));
    }

}
