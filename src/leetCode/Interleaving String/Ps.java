class Solution {
    private static int[][] dp;
    private static int n, m, k;

    public static boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        k = s3.length();

        dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        if (n + m != k) {
            return false;
        }

        int ans = solve(s1, s2, s3, 0, 0, 0);

        if (ans == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int solve(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index) {
        if (s1Index == n && s2Index == m) {
            return 1;
        }

        if (dp[s1Index][s2Index] != -1) {
            return dp[s1Index][s2Index];
        }

        dp[s1Index][s2Index] = 0;
        char curStr = s3.charAt(s3Index);

        if (s1Index < n && curStr == s1.charAt(s1Index)) {
            dp[s1Index][s2Index] = Math.max(dp[s1Index][s2Index], solve(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1));
        }

        if (s2Index < m && curStr == s2.charAt(s2Index)) {
            dp[s1Index][s2Index] = Math.max(dp[s1Index][s2Index], solve(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1));
        }

        return dp[s1Index][s2Index];
    }

}