package algorithm.programmers.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 문제 설명
 * Given a directed graph, detect whether the graph contains a cycle or not.
 * <p>
 * ⚠️ Please describe algorithm complexity as comment.
 * <p>
 * Input
 * [N_NODES]
 * [E1_FROM_NODE] [E1_TO_NODE]
 * [E2_FROM_NODE] [E2_TO_NODE]
 * ...
 * Where N_NODES is the number of nodes in the graph,
 * <p>
 * and a pair of EnFROMNODE and EnTONODE represents a directed edge in the graph.
 * <p>
 * EnFROMNODE and EnTONODE are node ids, which are integers in the range 0..N_NODES-1
 * <p>
 * Output
 * Output true if the graph contains at least one cycle; otherwise, false.
 * <p>
 * [RESULT]
 * Input Example
 * 3
 * 0 1
 * 1 2
 * 2 0
 * Output Example
 * true
 * <p>
 * 문제 해석
 * 방향성이 있는 그래프가 있을 때 그래프에 cycle이 포함되었는지 아닌지를 탐지한다.
 * N_NODES : 그래프에서의 node들의 수
 * EnFROMNODE, EnTONODE : 그래프에서의 방향을 나타내는 edge
 * <p>
 * OUTPUT
 * 최소 한개의 cycle 이 포함되면 true 아니면 false
 */
public class DirectedGraph {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int nodeCount = Integer.parseInt(input);
        Set<Integer> nodeSet = new HashSet<>();
        Set<Integer> visitedSet = new HashSet<>();

        for (int i = 0; i < nodeCount; i++) {
            String[] node = br.readLine().split(" ", 2);
            int start = Integer.parseInt(node[0]);
            int end = Integer.parseInt(node[1]);

            nodeSet.add(start);
            nodeSet.add(end);

            if(!visitedSet.contains(end)){
                visitedSet.add(end);
            }
        }

        boolean isCycle = true;
        Iterator<Integer> iter = nodeSet.iterator();
        while (iter.hasNext()){
            int node = iter.next();
            if(!visitedSet.contains(node)){
                isCycle = false;
                break;
            }
        }
        System.out.println(isCycle);
    }
}