package Algorithm;

import java.util.ArrayList;

/**
 * @author haiboWu
 * @create 2020-06-05 18:43
 */
public class No_06_ChangeCoinsWays {
    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int n = 10;
        int ways = getWays(coins, n);
        System.out.println(ways);
    }

    //用三个for循环暴力穷举
    private static int getWays2(int n) {
        int count = 0;
        for (int i = n; i >= 0; i--) {
            for (int j = n; j >= 0; j = j - 2) {
                for (int k = n; k >= 0; k = k - 5) {
                    if (i + k + j == 10) {
                        System.out.println(i + "," + j + "," + k);
                        count++;
                    }
                }
            }
        }
        return count;
    }


    //递归回溯法
    private static int getWays(int[] coins, int n) {
        if (n <= 0) return 0;
        //存储所有的路径
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //存储当前选择的路径
        ArrayList cur = new ArrayList();
        //递归调用
        getHelper(coins, 0, n, res, cur);
        //打印结果
        for (ArrayList<Integer> re : res) {
            System.out.println(re.toString());
        }
        return res.size();
    }

    private static void getHelper(int[] coins, int index, int n, ArrayList res, ArrayList cur) {
        //退出条件
        if (n == 0) {
            if (cur.size() > 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        for (int i = index; i < coins.length; i++) {
            //保证当前的n一定是大于0的
            if (n < coins[i]) {
                break;
            }
            //选择当前路径
            cur.add(coins[i]);
            //递归调用
            getHelper(coins, i, n - coins[i], res, cur);
            //回退
            cur.remove(cur.size() - 1);
        }
    }
}
