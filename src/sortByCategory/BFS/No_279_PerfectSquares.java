package sortByCategory.BFS;

import org.junit.Test;

import java.util.*;

/**
 * @author haiboWu
 * @create 2020-03-12 10:29
 */
public class No_279_PerfectSquares {
    @Test
    public void testSquares() {
        System.out.println(getNumSquares(12));
    }

    public int getNumSquares(int n) {
        Set<Integer> queue = new HashSet<>();
        int count = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> nextQueue = new HashSet<>();
            for (Integer cur : queue) {
                if (cur == 0) {
                    return count;
                }
                List<Integer> squares = getSquares(cur);
                for (Integer square : squares) {
                    if (cur < square) {
                        continue;
                    } else {
                        nextQueue.add(cur - square);
                    }
                }
            }
            queue = nextQueue;
            count++;
        }
        return -1;
    }

    public int numSquares(int n) {

        ArrayList<Integer> square_nums = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }

        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);

        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> next_queue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }

    List<Integer> getSquares(int num) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (i * i <= num) {
            list.add(i * i);
            i++;
        }
        return list;
    }
}
