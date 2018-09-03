package algorithm.topcoder.graph;

import org.junit.Test;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class ConnectTests {
    private Connect connect = new Connect();

    @Test
    public void testIsConnect() {
        int from = 0;
        int to = 1;
        int v = 1;

        boolean result = connect.isConnect(from, to, v);
        System.out.println(result);
      //  assertTrue(0.00 == result);

    }
}
