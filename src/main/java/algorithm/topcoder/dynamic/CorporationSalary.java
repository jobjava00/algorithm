package algorithm.topcoder.dynamic;

/**
 * 회사 조직과 급여
 * 1. 각 직원은 여러 명의 직접적인 매니저나 부하 직원을 가질 수 있다.
 * 2. 부하 직원도 부하 직원을 가질수 있고, 매니저도 매니저를 가질 수 있다.
 * 3. 만약 A가 B의 상사이고 B가 C의 상사이면 A는 C의 상사이다.
 * 4. 만약 A가 B의 상사라면 B는 A의 상사일 수 없다.
 * 5. 부하 없는 직원의 급여는 1 이다.
 * 6 부하 직원이 있다면 그 직원의 급여는 직접적인 부하 직원들의 급여 합과 긑다.
 * 7. 모든 직원의 급여 합계를 구하라!
 */
public class CorporationSalary {
	private long[] salaries;

	public long totalSalary(String[] relations) {
		salaries = new long[relations.length];

		long total = 0;
		for (int i = 0; i < relations.length; i++) {
			total += getSalary(i, relations);
		}

		return total;
	}

	private long getSalary(int i, String[] relations) {
		if (salaries[i] == 0) {
			long salary = 0;
			String relation = relations[i];
			for (int j = 0; j < relation.length(); j++) {
				if (relation.charAt(j) == 'Y') {
					salary += getSalary(j, relations);
				}
			}

			if (salary == 0)
				salary = 1;
			salaries[i] = salary;
		}
		return salaries[i];
	}
}
