package algorithm.topcoder.dynamic;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by uienw00 on 2018-03-09.
 */
public class DepthFirstSearchTests {
	private DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

	@Test
	public void testDfs() {
		int nowh = 1;
		int noww = 1;

		//입력 좌표에서 (5,4)를 찾아가는 최단 거리 방법
		int result = depthFirstSearch.dfs(nowh, noww);
		assertTrue(35 == result);

		//입력 좌표에서 (5,4)를 찾아가는 최단 거리 방법
		result = depthFirstSearch.dfs2(nowh, noww);
		assertTrue(35 == result);

		nowh = 5;
		noww = 4;
		//(0,0)에서 입력 좌표까지 찾아가는 최단 거리 방법
		result = depthFirstSearch.dfs3(nowh, noww);
		assertTrue(126 == result);
	}
}
