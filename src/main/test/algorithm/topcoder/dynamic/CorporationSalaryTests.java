package algorithm.topcoder.dynamic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class CorporationSalaryTests {
	private CorporationSalary corporationSalary = new CorporationSalary();

	@Test
	public void testTotalSalary() {
		String[] relations = { "N" };

		long result = corporationSalary.totalSalary(relations);
		assertTrue(1 == result);

		relations = new String[] {
		        "NNYN",
		        "NNYN",
		        "NNNN",
		        "NYYN"
		};
		result = corporationSalary.totalSalary(relations);
		assertTrue(5 == result);

		relations = new String[] {
		        "NNNNNN",
		        "YNYNNY",
		        "YNNNNY",
		        "NNNNNN",
		        "YNYNNN",
		        "YNNYNN"
		};
		result = corporationSalary.totalSalary(relations);
		assertTrue(17 == result);

		relations = new String[] {
		        "NYNNYN",
		        "NNNNNN",
		        "NNNNNN",
		        "NNYNNN",
		        "NNNNNN",
		        "NNNYYN"
		};
		result = corporationSalary.totalSalary(relations);
		assertTrue(8 == result);

		relations = new String[] {
		        "NNNN",
		        "NNNN",
		        "NNNN",
		        "NNNN"
		};
		result = corporationSalary.totalSalary(relations);
		assertTrue(4 == result);
	}
}
