package Algorithm;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author haiboWu
 * @create 2020-06-13 11:16
 */
public class No_08_ListMeeting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int meeting[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                meeting[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(meeting, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int prev = 0;
        int temp = meeting[0][1] - meeting[0][0];
        ans=meeting[0][1]-meeting[0][0];
        helper(meeting, prev, temp);
        System.out.println( ans);
    }

    private int baoili(int meeting[][]) {
        int ans = 0;
        for (int i = 0; i < meeting.length; i++) {
            int temp = meeting[i][1] - meeting[i][0];
            int last = meeting[i][1];
            for (int j = i + 1; j < meeting.length; j++) {
                if (meeting[j][0] >= last) {
                    int t = meeting[j][1] - meeting[j][0];
                    last = meeting[j][1];
                    temp += t;
                }
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    private static int ans = 0;
    /**
     * @param meeting 存放数据
     * @param prev    记录上一次选择的时间段
     * @param temp    记录当前选择路径中的总时间
     */
    private static void helper(int[][] meeting, int prev, int temp) {
        for (int i = 0; i < meeting.length; i++) {
            if (meeting[prev][1] <= meeting[i][0]) {
                int t = meeting[i][1] - meeting[i][0];
                temp += t;
                helper(meeting, i, temp);
                temp -= t; //回溯
            }
        }
        if (temp > ans) ans = temp;
    }
}
