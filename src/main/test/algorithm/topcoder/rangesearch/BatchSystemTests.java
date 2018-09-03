package algorithm.topcoder.rangesearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class BatchSystemTests {
    private BatchSystem batchSystem = new BatchSystem();

    @Test
    public void testMaximumEarnigs() {
        int[] duration = {400, 100, 100, 100};
        String[] user = {"Danny Messer", "Stella Bonasera", "Stella Bonasera", "Mac Taylor"};
        int[] returns = {3, 1, 2, 0};

        int[] result = batchSystem.schedule(duration, user);
        checkResult(returns, result);


        duration = new int[]{200, 200, 200};
        user = new String[]{"Gil", "Sarah", "Warrick"};
        returns = new int[]{0, 1, 2};

        result = batchSystem.schedule(duration, user);
        checkResult(returns, result);


        duration = new int[]{100, 100, 50};
        user = new String[]{"Horatio Caine", "horatio caine", "YEAAAAAAH"};
        returns = new int[]{2, 0, 1};

        result = batchSystem.schedule(duration, user);
        checkResult(returns, result);
    }

    private void checkResult(int[] results, int[] targets) {
        for (int i = 0; i < results.length; i++) {
            assertTrue(results[i] == targets[i]);
        }
    }
}
