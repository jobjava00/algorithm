package algorithm.topcoder.allsearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw on 2018-03-24.
 */
public class ThePalindromeTests {
	private ThePalindrome thePalindrome = new ThePalindrome();

	@Test
	public void testFind(){
		String s = "abab";
		int result = thePalindrome.find(s);
		assertTrue(result == 5);

		s = "abacaba";
		result = thePalindrome.find(s);
		assertTrue(result == 7);

		s = "qwerty";
		result = thePalindrome.find(s);
		assertTrue(result == 11);

		s = "abdfhdyrbdbsdfghjkllkjhgfds";
		result = thePalindrome.find(s);
		assertTrue(result == 38);
	}
}
