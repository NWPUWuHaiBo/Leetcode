package sortByCategory.Test;

/**
 * @author haiboWu
 * @create 2020-03-29 16:21
 */
public class Test1 {
    public static int result = 1;

    public static void main(String[] args) {
//        new Test1().helper(7, 1, 1);
//        System.out.println(result);
        System.out.println(new Test1().getResult(7,true));
    }

    public int getNums(int nums) {
        int last = 0;
        int climb[] = new int[nums + 1];
        climb[0] = 1;
        climb[1] = 1;
        climb[2] = 2;
        climb[3] = 3;
        for (int i = 4; i < nums + 1; i++) {
            if (last % 2 == 0) {
                climb[i] = climb[i - 1] + climb[i - 2];
                last++;
            } else {
                climb[i] = climb[i - 1];
                last = 0;
            }
        }
        return climb[nums];
    }

    public int getResult(int n, boolean flag) {
        if (n == 1) return 1;
        else if (n == 2) {
            if (flag) {
                return 2;
            } else {
                return 1;
            }
        }

        if (flag) {
            return getResult(n - 1, true) + getResult(n - 2, false);
        } else {
            return getResult(n - 1, true);
        }
    }

    private void helper(int nums, int cur, int last) {
        if (cur == nums) {
            return;
        }
        result++;
        for (int i = 1; i <= 3 - last; i++) {
            cur += i;
            helper(nums, cur, i);
        }
    }
}
