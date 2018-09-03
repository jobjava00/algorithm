package algorithm.topcoder.allsearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class CryptographyTests {
	private Cryptography cryptography = new Cryptography();

	@Test
	public void testEncrypt() {
		//첫번째 테스트
		int[] numbers = {1, 2, 3 };
		long result = cryptography.encrypt(numbers);
		assertTrue(12 == result);

		cryptography.encrypt2(numbers);
		assertTrue(12 == result);

		//두번째 테스트
		numbers = new int[] {1, 3, 2, 1, 1, 3};
		result = cryptography.encrypt(numbers);
		assertTrue(36 == result);

		cryptography.encrypt2(numbers);
		assertTrue(36 == result);

		//세번째 테스트
		numbers = new int[] {1000, 999, 998, 997, 996, 995};
		result = cryptography.encrypt(numbers);
		assertTrue(986074810223904000L == result);

		cryptography.encrypt2(numbers);
		assertTrue(986074810223904000L == result);

		//네번째 테스트
		numbers = new int[] {1, 1, 1, 1};
		result = cryptography.encrypt(numbers);
		assertTrue(2 == result);

		cryptography.encrypt2(numbers);
		assertTrue(2 == result);
	}
}
