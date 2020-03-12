package sortByCategory.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-03-12 23:27
 */
public class No_95_RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        doRestoreIPAddresses(0, sb, addresses, s);
        return addresses;
    }

    private void doRestoreIPAddresses(int i, StringBuilder sb, List<String> addresses, String s) {
        if (i == 4 || s.length() <= 0) {
            if (i == 4 && s.length() == 0) {
                addresses.add(sb.toString());
            }
            return;
        }
        for (int j = 0; j <= 2 && j < s.length(); j++) {
            if (j != 0 && s.charAt(0) == '0') {
                break;
            }
            String cur = s.substring(0, j + 1);
            if (Integer.valueOf(cur) <= 255) {
                if (sb.length() != 0) {
                    cur = '.' + cur;
                }
                sb.append(cur);
                doRestoreIPAddresses(i + 1, sb, addresses, s.substring(j + 1));
                sb.delete(sb.length() - cur.length(), sb.length());
            }
        }
    }
}
