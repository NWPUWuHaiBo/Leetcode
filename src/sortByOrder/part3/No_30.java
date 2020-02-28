package sortByOrder.part3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haiboWu
 * @create 2020-02-12 17:50
 */
public class No_30 {
    public static void main(String[] args) {

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) return res;
        //1.将words通过hashmap来存储
        Map<String, Integer> words_map = new HashMap<>();
        for (String word : words) {
            if (words_map.containsKey(word)) {
                words_map.put(word, words_map.get(word) + 1);
            } else {
                words_map.put(word, 1);
            }
        }
        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;
        for (int i = 0; i < s.length() - totalLength + 1; i++) {
            Map<String, Integer> submap = new HashMap<>(words_map);
            int j = 0;
            for (j = 0; j < words.length; j++) {
                String sub = s.substring(i + wordLength * j, i + wordLength * (j + 1));
                if (submap.containsKey(sub)) {
                    int count = submap.get(sub);
                    if (count == 1) {
                        submap.remove(sub);
                    } else {
                        submap.put(sub, count - 1);
                    }
                } else {
                    break;
                }
            }
            if (j == words.length && submap.size() == 0) res.add(i);
        }
        return res;
    }
}
