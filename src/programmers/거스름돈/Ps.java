class Ps {
    public static int solution(int n, int[] money) {
        int answer = 0;
        int length = money.length;
        int[] dp = new int[n + 1];
        int MOD = 1000000007;

        dp[0] = 1;
        for (int i = 0; i < length; i++) {
            int num = money[i];
            for (int j = 1; j <= n; j++) {
                if (j - num < 0) {
                    continue;
                }

                dp[j] = dp[j] + dp[j - num];
                dp[j] = dp[j] % MOD;

            }
        }

        answer = dp[n];
        return answer;
    }
}