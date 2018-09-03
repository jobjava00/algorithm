package algorithm.topcoder.allsearch;

/**
 * 고장난 로봇
 * 1. 로봇은 n번 움직임
 * 2. 로봇은 각 단계에서 한 방향(동,서,남,북) 중에 한 방향을 랜덤하게 선택해서 한칸 움직인다.
 * 3. 로봇이 동,서,남,북을 선택할 확률을 입력 받는다.
 * 4. 로봇이 같은 지점을 통과하지 않으면 성공, 같은 곳을 통과하면 실패
 * 5. 로봇이 성공적으로 보행할 확률을 구해라!
 */
public class CrazyBot {
	boolean[][] grid = new boolean[100][100]; //전체 100 * 100 사이즈 판
	int vx[] = { 1, -1, 0, 0 };
	int vy[] = { 0, 0, 1, -1 };

	double[] prob = new double[4];

	public double getProbability(int n, int east, int west, int south, int north) {
		prob[0] = east / 100.0;
		prob[1] = west / 100.0;
		prob[2] = south / 100.0;
		prob[3] = north / 100.0;

		return dfs(50, 50, n); //가운데 지점에서 시작 - 시작점
	}

	public double dfs(int x, int y, int n) {
		if (grid[x][y])
			return 0;
		if (n == 0)
			return 1;

		grid[x][y] = true;
		double ref = 0;
		for (int i = 0; i < 4; i++) {
			//east, west, south, north 순서로 로봇을 움직인다.
			ref += dfs(x + vx[i], y + vy[i], n - 1) * prob[i];
		}
		grid[x][y] = false;

		return ref;
	}
}
