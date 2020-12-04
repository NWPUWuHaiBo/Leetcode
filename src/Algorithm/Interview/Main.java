package Algorithm.Interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author haiboWu
 * @create 2020-07-01 18:49
 */
public class Main {
    private static String high = "bdfhkl";
    private static String mid = "aceimnorstuvwxz";
    private static String low = "gjpqy";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        TreeMap<Character, Integer> treeMap[] = new TreeMap[3];

        for (int i = 0; i < 3; i++) {
            treeMap[i] = new TreeMap<>();
        }

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            String s = c + "";
            if (high.contains(s)) {
                int nums = treeMap[0].get(c);
                if (nums == -1) {
                    treeMap[0].put(c, 1);
                } else {
                    treeMap[0].put(c, nums++);
                }

            } else if (mid.contains(s)) {
                int nums = treeMap[1].get(c);
                if (nums == -1) {
                    treeMap[0].put(c, 1);
                } else {
                    treeMap[0].put(c, nums++);
                }
            } else if (low.contains(s)) {
                int nums = treeMap[2].get(c);
                if (nums == -1) {
                    treeMap[0].put(c, 1);
                } else {
                    treeMap[0].put(c, nums++);
                }
            }
        }

        StringBuilder res[] = new StringBuilder[3];
        for (int i = 0; i < 3; i++) {
            res[i] = new StringBuilder();
        }
        for (int i = 0; i < 3; i++) {
            while (treeMap[i].size() != 0) {
                Character c = treeMap[i].firstKey();
                int nums = treeMap[i].get(c);
                for (int j = 0; j < nums; j++) {
                    res[i].append(c);
                }
                treeMap[i].remove(treeMap[i].firstKey());
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(res[i].toString());
        }
    }
}

