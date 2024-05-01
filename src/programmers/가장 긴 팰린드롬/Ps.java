class Ps {
    private static int[][] dp;

    public static int solution(String s) {
        int answer = 0;
        int n = s.length();

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cnt = 0;
                if (dp[i][j] != -1) {
                    cnt = dp[i][j];
                } else {
                    cnt = solve(i, j, s);
                }

                if (cnt == 1) {
                    int length = j - i + 1;
                    answer = Math.max(answer, length);
                }
            }
        }

        return answer;
    }

    public static int solve(int lo, int hi, String s) {
        if (lo >= hi) {
            return dp[lo][hi] = 1;
        }

        if (dp[lo][hi] != -1)
            return dp[lo][hi];

        if (s.charAt(lo) == s.charAt(hi)) {
            return dp[lo][hi] = solve(lo + 1, hi - 1, s);
        }

        return dp[lo][hi] = 0;
    }
}