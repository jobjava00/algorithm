package algorithm.topcoder.simulation;

/**
 * 주스 재분배
 * 1. 여러 용량의 병과 그 병에 들어있는 주스를 옮겨서 재분배 한다.
 */
public class KiwiJuiceEasy {

	/**
	 * capacities 와 bottles는 같은 수의 요소를 갖는다.
	 * fromId 와 toId는 같은 수의 요소를 갖는다.
	 * @param capacities : 병의 용량
	 * @param bottles : 주스 용량
	 * @param fromId : 기존 병
	 * @param toId : 옮길 병
	 * @return
	 */
	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		int fromSize = fromId.length;

		for (int i = 0; i < fromSize; i++) {
			int from = fromId[i];
			int to = toId[i];
			int space = capacities[to] - bottles[to];   //옮길 병의 남은 용량 구함

			if(space >= bottles[from]){ //옮길 병의 남은 용량 >= 옮길 주스 용량
				int vol = bottles[from];
				bottles[to] += vol;
				bottles[from] = 0;
			}else{
				int vol = space;
				bottles[to] += vol;
				bottles[from] -= vol;
			}
		}
		return bottles;
	}

	/**
	 * 개선 - Math.min 함수 사용으로 분기문 제거
	 * 옮길 주스의 양과 기존 주스 병의 남은 용량을 비교하면 둘 중 작은것이 이동량이 됨.
	 * 기존 주스에 이동량 추가
	 * 옮길 주스에 이동량 제거
	 * @param capacities
	 * @param bottles
	 * @param fromId
	 * @param toId
	 * @return
	 */
	public int[] thePouring2(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		int fromSize = fromId.length;

		for (int i = 0; i < fromSize; i++) {
			int from = fromId[i];
			int to = toId[i];
			int space = capacities[to] - bottles[to];   //옮길 병의 남은 용량 구함

			int vol = Math.min(bottles[from], space);
			bottles[from] -= vol;
			bottles[to] += vol;
		}
		return bottles;
	}

	/**
	 * 개선 - 다른 버전
	 * 옮길 주스와 기존 주스 양의 총합이 일정함.
	 * 옮길 주스 총량과 기존 주스 병의 용량 중에 작은 값이 됨
	 * 기존주스 : 옮길 주스와 기존 주스의 총합과 기존 주스 병의 용량에서 작은 값
	 * 옮길주스 : 옮길 주스와 기존 주스의 총합에서 위의 값을 제외한 값
	 * @param capacities
	 * @param bottles
	 * @param fromId
	 * @param toId
	 * @return
	 */
	public int[] thePouring3(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		int fromSize = fromId.length;

		for (int i = 0; i < fromSize; i++) {
			int sum = bottles[fromId[i]] + bottles[toId[i]];
			bottles[toId[i]] = Math.min(sum, capacities[toId[i]]);
			bottles[fromId[i]] = sum - bottles[toId[i]];
		}
		return bottles;
	}
}
