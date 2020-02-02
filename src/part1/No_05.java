package part1;
/**
 * @author haiboWu
 * @create 2020-01-30 19:20
 */
public class No_05 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(longestPalindrome("babad"));
    }

    public static  String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                } else {
                    dp[j][i] = false;
                }
                if (dp[j][i]) {
                    int len = i - j + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
