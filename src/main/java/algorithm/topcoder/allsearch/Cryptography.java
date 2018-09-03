package algorithm.topcoder.allsearch;

import java.util.Arrays;

/**
 * 암호
 * 1. 입력 배열에서 숫자 하나를 선택하면 그 숫자는 1 증가
 * 2. 모든 배열숫자를 곱해서 곱의 최댓값을 리턴하라!
 */
public class Cryptography {

	/**
	 * 이중반복문으로 모든 수 곱함
	 * 
	 * @param numbers
	 * @return
	 */
	public long encrypt(int[] numbers) {
		int size = numbers.length;
		long result = 0;

		for (int i = 0; i < size; i++) {
			int incrementNumber;
			long productNumber = 1;
			for (int j = 0; j < size; j++) {
				if (i == j)
					incrementNumber = numbers[j] + 1;
				else
					incrementNumber = numbers[j];
				productNumber = incrementNumber * productNumber;
			}
			result = Math.max(result, productNumber);
		}
		return result;
	}

	/**
	 * 최소값에 +1을 해주면 그게 최댓값이 된다.
	 * 1. 숫자 정렬 후 첫번째 요소에 +1을 해줌
	 * 
	 * @param numbers
	 * @return
	 */
	public long encrypt2(int[] numbers) {
		long result = 1;
		Arrays.sort(numbers);
		numbers[0]++;
		int size = numbers.length;
		for (int i = 0; i < size; i++) {
			result *= numbers[i];
		}
		return result;
	}
}
