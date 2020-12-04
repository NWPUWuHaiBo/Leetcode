package sortByCategory.Test;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-11-20 13:01
 */
public class SubString {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        res.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(2);

        if (res.contains(list2)) {
            System.out.println("---");
        }

    }

    private List<String> generateSubString(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(list, "", s, 0);
        return list;
    }

    private void dfs(List<String> list, String sb, String s, int index) {
        if (index == s.length()) {
            if (sb != "") {
                list.add(sb);
            }
            return;

        }
        String ss = sb + s.charAt(index);
        dfs(list, sb, s, index + 1);
        dfs(list, ss, s, index + 1);
    }
}
