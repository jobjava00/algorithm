package algorithm.topcoder.rangesearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class StockHistoryTests {
	private StockHistory stockHistory = new StockHistory();

	@Test
	public void testMaximumEarnigs() {
		int initialInvestment = 1000;
		int monthyContribution = 0;
		String[] stockPrices = {"10 20 30", "15 24 32"};

		int result = stockHistory.maximumEarnigs(initialInvestment, monthyContribution, stockPrices);
		assertTrue(500 == result);


		initialInvestment = 1000;
		monthyContribution = 0;
		stockPrices = new String[]{"10", "9"};

		result = stockHistory.maximumEarnigs(initialInvestment, monthyContribution, stockPrices);
		assertTrue(0 == result);


		initialInvestment = 100;
		monthyContribution = 20;
		stockPrices = new String[]{
				"40 50 60",
				"37 48 55",
				"100 48 50",
				"105 48 47",
				"110 50 52",
				"110 50 52",
				"110 51 54",
				"109 49 53"
		};

		result = stockHistory.maximumEarnigs(initialInvestment, monthyContribution, stockPrices);
		assertTrue(239 == result);
	}
}
