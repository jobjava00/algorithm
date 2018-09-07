package algorithm.codility.lesson6;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;

import java.util.Arrays;

/**
 ### 해석
 * A : N개의 정수로 구성 된 배열
 * 배열A의 고유한 값의 개수를 리턴하라!

 ### 풀이
 * 우선 정렬 시킨다.
 * XOR 비트 연산으로 중복 된 값 인지 체크


 ### 제약사항
 * N의 범위는 정수 [0..100,000]
 * 배열A의 각 요소의 범위는 정수 [−1,000,000..1,000,000]

 ### 결과
 * Arrays.sort 사용 : https://app.codility.com/demo/results/trainingM5TBK8-V45/?showingAll=1
 * 퀵소트 구현 : https://app.codility.com/demo/results/trainingWCP72J-SUQ/?showingAll=1
 */
public class Distinct {
	public int solution(int[] A) {
		int N = A.length;
		if(0 == N) return 0;

		quickSort(A, 0, N-1);
		int distinctNum = 1;
		for (int i=1; i<N; i++){
			if(0 != (A[i -1] ^ A[i])) distinctNum++;
		}
		return distinctNum;
	}

	public int solution2(int[] A) {
		int N = A.length;
		if(0 == N) return 0;

		Arrays.sort(A);
		int distinctNum = 1;
		for (int i=1; i<N; i++){
			if(0 != (A[i -1] ^ A[i])) distinctNum++;
		}
		return distinctNum;
	}

	public void quickSort(int[] arr, int begin, int end) {
		int middle = (begin + end) / 2;
		int pivot = arr[middle];
		int left = begin;
		int right = end;
		int temp;

		while (left < right) { //left와 right가 만나면 루프 종료
			while (arr[left] < pivot) left++;       //left : pivot 값 보다 큰 값을 찾기 위해 이동
			while (arr[right] > pivot) right--;     //right : pivot 값 보다 작은 값을 찾기 위해 이동

			if (left <= right) { //left가 right보다 같거나 작으면 서로 값 교환해줌
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		//부분 분할 실행
		if (begin < right) quickSort(arr, begin, right);
		if (end > left) quickSort(arr, left, end);
	}

	public static void main(String[] args) {
		Distinct question = new Distinct();
		Assert.assertThat(question.solution(new int[] { 2, 1, 1, 2, 3, 1}), is(3));
		Assert.assertThat(question.solution(new int[] { -10, 5, -5, 3, -5, 3}), is(4));
	}
}
