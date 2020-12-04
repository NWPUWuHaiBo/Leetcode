package sortByCategory.BackTracking;

import java.util.*;

/**
 * @author haiboWu
 * @create 2020-11-19 17:09
 */
public class No_93_RestoreIPAddress {
    List<String> res = new LinkedList<>();
    LinkedList<String> segment = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        helper(s, 0);
        return res;
    }

    void helper(String s, int start) {
        if (start == s.length() && segment.size() == 4) {
            StringBuilder t = new StringBuilder();
            for (String se : segment) t.append(se).append(".");
            t.deleteCharAt(t.length() - 1);
            res.add(t.toString());
            return;
        }
        if (start < s.length() && segment.size() == 4) return;
        for (int i = 1; i <= 3; i++) {
            if (start + i - 1 >= s.length()) return;
            if (i != 1 && s.charAt(start) == '0') return;
            String str = s.substring(start, start + i);
            if (i == 3 && Integer.parseInt(str) > 255) return;
            segment.addLast(str);
            helper(s, start + i);
            segment.removeLast();
        }
    }
}
