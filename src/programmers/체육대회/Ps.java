
public class Ps {
    private int[][] dp;
    private int n, m;

    public int solution(int[][] ability) {
        n = ability.length;
        m = ability[0].length;

        dp = new int[1 << m][n];

        for (int i = 0; i < (1 << m); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int answer = dfs(0, 0, ability);
        return answer;
    }

    public int dfs(int bit, int student, int[][] ability) {
        if (bit == (1 << n) - 1 || student >= n) {
            return 0;
        }
        if (dp[bit][student] != -1)
            return dp[bit][student];

        for (int i = 0; i < m; i++) {
            if ((bit & (1 << i)) != 0) {
                continue;
            }
            int num = bit | (1 << i);
            dp[bit][student] = Math.max(dp[bit][student], dfs(num, student + 1, ability) + ability[student][i]);
        }

        dp[bit][student] = Math.max(dp[bit][student], dfs(bit, student + 1, ability));

        return dp[bit][student];
    }

}
