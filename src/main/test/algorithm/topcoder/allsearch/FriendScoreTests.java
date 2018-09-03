package algorithm.topcoder.allsearch;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by uienw on 2018-03-24.
 */
public class FriendScoreTests {
	private FriendScore friendScore = new FriendScore();

	@Test
	public void testHighestScore(){
		String[] friends = {
				 "NNN"
				,"NNN"
				,"NNN"
		};
		int result = friendScore.highestScore(friends);
		assertTrue(result == 0);

		friends = new String[]{
				"NYY"
				,"YNY"
				,"YYN"
		};
		result = friendScore.highestScore(friends);
		assertTrue(result == 2);

		friends = new String[]{
				"NYNNN"
				,"YNYNN"
				,"NYNYN"
				,"NNYNY"
				,"NNNYN"
		};
		result = friendScore.highestScore(friends);
		assertTrue(result == 4);
	}
}
