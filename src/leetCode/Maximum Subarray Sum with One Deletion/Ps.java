class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int answer = Integer.MIN_VALUE;
        int[][] dp = new int[2][n];
        dp[0][0] = 0;
        dp[1][0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + arr[i]);
            dp[1][i] = Math.max(arr[i], dp[1][i - 1] + arr[i]);
            answer = Math.max(answer, Math.max(dp[0][i], dp[1][i]));
        }
        return answer;
    }
}