package util;

import algorithm.codility.lesson6.Distinct;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

public class Sort {
	/**
	 * Quick Sort
	 *
	 * 정렬할 전체 원소에 대해서 정렬을 수행하지 않고, 기준 값을 중심으로 왼쪽 부분 집합과 오른쪽 부분 집합으로 분할하여 정렬하는 방법
	 * 기준 값 : 피봇 (pivot), 일반적으로 전체 원소 중에서 가운데에 위치한 원소를 선택한다.
	 * 분할(divide) : 정렬할 자료들을 기준 값을 중심으로 2개의 부분 집합으로 분할한다.
	 * 왼쪽 부분 집합 : 기준 값보다 작은 원소들을 이동
	 * 오른쪽 부분 집합 : 기준 값보다 큰 원소들을 이동
	 * 정복(conquer) : 부분집합의 원소들 중에서 기준 값보다 작은 원소들은 왼쪽 부분집합으로, 기준 값보다 큰 원소들은 오른쪽 부분집합으로 정렬한다.
	 * 부분집합의 크기가 1이하로 충분히 작지 않으면 순환 호출을 이용하여 다시 분할한다.
	 * 
	 * @param arr
	 * @param begin
	 * @param end
	 */
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
		Sort question = new Sort();
		int[] arr = new int[] { 66, 10, 1, 34, 5, -10};
		question.quickSort(arr, 0, 5);
		Assert.assertThat(arr, is(new int[] { -10, 1, 5, 10, 34, 66}));

		arr = new int[] { -66, 10, 1, 34, 1, -10};
		question.quickSort(arr, 0, 5);
		Assert.assertThat(arr, is(new int[] { -66, -10, 1, 1, 10, 34}));
	}
}
