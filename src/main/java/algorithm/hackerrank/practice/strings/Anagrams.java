package algorithm.hackerrank.practice.strings;

import org.junit.Assert;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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
			sum += ++temp[a.charAt(i)] <= 0 ? -1 : 1; // increment
			sum += --temp[b.charAt(i)] >= 0 ? -1 : 1; // decrement
		}
		return sum == 0;
	}

	public static void main(String[] args) {
		Assert.assertThat(isAnagram("anagram", "margana"), is(true));
		Assert.assertThat(isAnagram("anagramm", "marganaa"), is(false));
		Assert.assertThat(isAnagram("Hello", "hello"), is(true));
		Assert.assertThat(isAnagram("xyzw", "xyxy"), is(false));
		Assert.assertThat(isAnagram("abcde", "xyzwf"), is(false));

		String zeroTo255 = "([0-9]|[0-9][0-9]|(0|1)[0-9][0-9]|2[0-4][0-9]|25[0-5])";
		String pattern = zeroTo255 + "." + zeroTo255 + "." + zeroTo255 + "." + zeroTo255;
		String IP = "2.3.123.262";
		System.out.println(IP.matches(pattern));
	}
}
