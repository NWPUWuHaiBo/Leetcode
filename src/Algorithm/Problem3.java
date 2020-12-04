package Algorithm;

import java.util.Scanner;

/**
 * @author haiboWu
 * @create 2020-07-02 22:01
 */
public class Problem3 {
    static int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int ans) {

        if (count == n && graph[currPos][0] > 0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }

        /*
         * 回溯步骤（BACKTRACKING STEP）
         * 循环遍历currPos结点的邻接表，将计数增加1，并按graph[currPos][i]值增加成本
         * cost + graph[currPos][i]
         */

        for (int i = 0; i < n; i++) {
            if (v[i] == false && graph[currPos][i] > 0) {

                // 标记结点被访问过
                v[i] = true;
                ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans);

                // 标记结点没有被访问过
                v[i] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 顶点（结点）的数量
        int n = 4;

        int[][] graph = {{0, 8, 5, 36},
                {6, 0, 8, 5},
                {8, 9, 0, 5},
                {7, 7, 8, 0}};

        // boolean类型的数组 v 用来标记一个城市结点是否被访问过
        boolean[] v = new boolean[n];

        // 标记第 0 个 结点已经被访问过，所以v[0]=true
        v[0] = true;
        int ans = Integer.MAX_VALUE;

        // 查找最小权重的汉密尔顿回路 Hamiltonian Cycle
        ans = tsp(graph, v, 0, n, 1, 0, ans);

        // 输出结果ans就是最小权重的汉密尔顿回路
        System.out.println(ans);

    }
}
