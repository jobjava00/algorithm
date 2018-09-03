package algorithm.topcoder.allsearch;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by uienw on 2018-03-24.
 */
public class FibonacciTests {
	private Fibonacci fibonacci = new Fibonacci();

	@Test
	public void testFib(){
		int result = fibonacci.fib(2);
		assertTrue(result == 2);

		result = fibonacci.fib(3);
		assertTrue(result == 3);

		result = fibonacci.fib(4);
		assertTrue(result == 5);

		result = fibonacci.fib(5);
		assertTrue(result == 8);
	}
}
