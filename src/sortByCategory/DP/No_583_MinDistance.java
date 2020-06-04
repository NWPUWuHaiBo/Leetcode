package sortByCategory.DP;


/**
 * @author haiboWu
 * @create 2020-06-04 20:18
 */
public class No_583_MinDistance {
    public static void main(String[] args) {
        String s1 = "aabcd", s2 = "acbbd";
        int res = minDistance(s1, s2);
        System.out.println(res);
    }

    private static int minDistance(String word1, String word2) {
        int same = getLCS(word1, word2);

        return word1.length() + word2.length() - 2 * same;
    }

    private static int getLCS(String s1, String s2) {

        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
