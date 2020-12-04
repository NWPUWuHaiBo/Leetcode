package Algorithm;

import java.util.Scanner;

/**
 * @author haiboWu
 * @create 2020-07-02 22:01
 */
public class Problem2 {
    //需要执行的任务数
    public static int n;
    //能够执行任务的机器数
    public static int k;
    //存每个任务的时间
    public static int task_time[] = new int[10000];
    //最终需要的最小时间
    public static int min_t;
    //每个机器当前存储的最小时间
    public static int machine[] = new int[1000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the number of missions:");
        n = scanner.nextInt();
        System.out.println("please input the number of machines:");
        k = scanner.nextInt();
        System.out.println("please input each mission cost time:");
        for (int i = 0; i < n; i++) {
            task_time[i] = scanner.nextInt();
            min_t += task_time[i];
        }
        backTrack(0);
        System.out.println(min_t);
    }

    private static void backTrack(int t) {
        if (t == n) {
            int nowMaxTime = 0;
            for (int i = 0; i < k; i++) {
                nowMaxTime = nowMaxTime > machine[i] ? nowMaxTime : machine[i];
            }
            min_t = min_t > nowMaxTime ? nowMaxTime : min_t;
        } else {
            for (int i = 0; i < k; i++) {
                machine[i] += task_time[t];
                //剪枝
                if (machine[i] < min_t) {
                    //递归
                    backTrack(t + 1);
                }
                //回溯
                machine[i] -= task_time[t];
            }
        }
    }
}
