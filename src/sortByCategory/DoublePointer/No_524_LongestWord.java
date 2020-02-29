package sortByCategory.DoublePointer;

import java.util.List;

/**
 * @author haiboWu
 * @create 2020-02-29 16:56
 */
public class No_524_LongestWord {
    public String findLongestWord(String s, List<String> d) {
        if (d.size() == 0) return "";
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length();
            int l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    public boolean isSubstr(String src, String target) {
        int i = 0;
        int j = 0;
        while (i < src.length() && j < target.length()) {
            if (src.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
