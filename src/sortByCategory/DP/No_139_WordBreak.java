package sortByCategory.DP;

import java.util.List;

/**
 * @author haiboWu
 * @create 2020-06-01 10:17
 */
public class No_139_WordBreak {
    public static void main(String[] args) {

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[0]=true;
        for (int i = 1; i < n + 1; i++) {
            for (String word : wordDict) {
                if (i >= word.length() && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[n];
    }
}
