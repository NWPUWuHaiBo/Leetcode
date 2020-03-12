package sortByCategory.BFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author haiboWu
 * @create 2020-03-12 10:29
 */
public class No_279_PerfectSquares {
    @Test
    public void testSquares() {
        System.out.println(dfs(12));
    }

    private int dfs(int n) {
        if (n <= 3) return n;

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            int output = dfs(j);
            min = Math.min(min, output + 1);
        }

        return min;
    }

    public int numSquares(int n) {
        List<Integer> squares = getSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean marked[] = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur=queue.poll();
                for (Integer square : squares) {
                    int next=cur-square;
                    if(next<0){
                        break;
                    }
                    if(next==0){
                        return level;
                    }
                    if(marked[next]){
                        continue;
                    }
                    marked[next]=true;
                    queue.add(next);
                }

            }
        }
        return level;
    }

    List<Integer> getSquares(int num) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (i * i < num) {
            list.add(i * i);
            i++;
        }
        return list;
    }
}
