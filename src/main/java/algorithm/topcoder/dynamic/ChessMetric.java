package algorithm.topcoder.dynamic;

/**
 * 킹나이트 체스
 * 1. n x n 사이즈의 체스판이 있다.
 * 2. 킹 나이트라는 말이 있다.
 * 3. 'K'로 표시된 킹 나이트는 1회만 움직여서 'K'부터 'X' 또는 'L'의 위치로 이동 할 수 있다.
 * 4. 킹 나이트는 모든 방향(수직, 수평, 대각선) 으로 1칸 움직이거나 L 모양으로 움직일 수 있다.
 * 5. L 모양은 "수평으로 2칸 수직으로 1칸" 또는 "수직으로 2칸 수평으로 1칸" 이동 하는 것
 * 6. 크기 size 체스판 일때 start 에서 end 까지 numMoves 만에 움직일 수 있는 방법이 몇가지 있지 구하라!
 */
public class ChessMetric {
	long[][][] ways = new long[100][100][55];
	int[] dx = new int[] { 1, 1, 1, 0, -1, -1, -1, 0, 2, 1, -1, -2, -2, -1, 1, 2 };
	int[] dy = new int[] { 1, 0, -1, -1, -1, 0, 1, 1, -1, -2, -2, -1, 1, 2, 2, 1 };

	/**
	 * @param size 체스판의 크기
	 * @param start 시작 위치 - 첫번째 요소 : 줄, 두번째 요수 : 열
	 * @param end 최종 위치 - 첫번째 요소 : 줄, 두번째 요수 : 열
	 * @param numMoves 움직일 수 있는 횟수
	 * @return
	 */
	public long howMany(int size, int[] start, int[] end, int numMoves) {
		int x, y, i, j;
		int sx = start[0];
		int sy = start[1];
		int ex = end[0];
		int ey = end[1];

		ways[sy][sx][0] = 1;

		for (i = 1; i <= numMoves; i++) {
			for (x = 0; x < size; x++) {
				for (y = 0; y < size; y++) {
					for (j = 0; j < dx.length; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if (nx < 0 || ny < 0 || nx >= size || ny >= size)
							continue;

						ways[ny][nx][i] += ways[y][x][i - 1];
					}
				}
			}
		}
		return ways[ey][ex][numMoves];
	}
}
