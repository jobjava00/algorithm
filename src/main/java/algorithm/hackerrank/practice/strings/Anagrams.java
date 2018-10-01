package algorithm.hackerrank.practice.strings;

import org.junit.Assert;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 */
public class Anagrams {

	static boolean isAnagram(String a, String b) {
		if (a.length() != b.length())
			return false;

		int[] temp = new int[128]; //ascii code length 128
		a = a.toLowerCase();
		b = b.toLowerCase();
		int sum = 0;

		for (int i = 0; i < a.length(); i++) {
			sum += ++temp[a.charAt(i)] <= 0 ? -1 : 1;   // increment
			sum += --temp[b.charAt(i)] >= 0 ? -1 : 1;   // decrement
		}
		return sum == 0;
	}

	public static void main(String[] args) {
		Assert.assertThat(isAnagram("anagram", "margana"), is(true));
		Assert.assertThat(isAnagram("anagramm", "marganaa"), is(false));
		Assert.assertThat(isAnagram("Hello", "hello"), is(true));
		Assert.assertThat(isAnagram("xyzw", "xyxy"), is(false));
		Assert.assertThat(isAnagram("abcde", "xyzwf"), is(false));
	}
}
