package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author haiboWu
 * @create 2020-07-02 22:01
 */
public class Problem1 {
    public static void main(String[] args) {
        System.out.println("please input the data:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
        int nums[] = new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int Alltime = getWaitTime(nums);
        System.out.println(Alltime);
    }

    private static int getWaitTime(int[] nums) {
        int res = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            res += nums[i] * (len - i);
        }
        return res;
    }
}
