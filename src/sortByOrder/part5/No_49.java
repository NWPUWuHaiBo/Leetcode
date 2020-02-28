package sortByOrder.part5;

import java.util.*;

/**
 * @author haiboWu
 * @create 2020-02-21 18:56
 */
public class No_49 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, ArrayList<String>> map = new HashMap<>();
        if (strs == null || strs.length == 0) return new ArrayList<>(map.values());
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String ss = new String(s);
            if (map.containsKey(ss)) {
                ArrayList<String> list = map.get(ss);
                list.add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(ss, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
