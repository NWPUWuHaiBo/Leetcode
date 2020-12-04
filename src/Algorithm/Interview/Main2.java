package Algorithm.Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author haiboWu
 * @create 2020-07-01 18:49
 */
public class Main2 {
    private static String high = "bdfhkl";
    private static String mid = "aceimnorstuvwxz";
    private static String low = "gjpqy";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        ArrayList<Character> list[] = new ArrayList[3];

        for (int i = 0; i < 3; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            String s = c + "";
            if (high.contains(s)) {
                list[0].add(c);
            } else if (mid.contains(s)) {
                list[1].add(c);
            } else if (low.contains(s)) {
                list[2].add(c);
            }
        }

        for (int i = 0; i < 3; i++) {
            Collections.sort(list[i], ((o1, o2) -> {return o1 - o2;}));
        }

        StringBuilder res[] = new StringBuilder[3];
        for (int i = 0; i < 3; i++) {
            res[i] = new StringBuilder();
            for (int j = 0; j < list[i].size(); j++) {
                res[i].append(list[i].get(j));
            }
            if(res[i].length()==0){
                System.out.println("null");
            }else{
                System.out.println(res[i].toString());
            }
        }



       /* StringBuilder res[] = new StringBuilder[3];
        for (int i = 0; i < 3; i++) {
            res[i] = new StringBuilder();
        }
        for (int i = 0; i < 3; i++) {

        }
        for (int i = 0; i < 3; i++) {
            System.out.println(res[i].toString());
        }*/
    }
}

