class Solution {

    private static int n;
    private static int[][] dp;

    public static int minSpaceWastedKResizing(int[] nums, int k) {
        n = nums.length;
        dp = new int[k + 1][n];

        if (n == 1) {
            return 0;
        }

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, nums, k);

    }

    public static int solve(int index, int[] nums, int k) {
        if (index == n) {
            return 0;
        }

        if (k == -1) {
            return (int) 1e8;
        }

        if (dp[k][index] != -1) {
            return dp[k][index];
        }

        dp[k][index] = (int) 1e8;
        int maxValue = 0;
        int sum = 0;

        for (int i = index; i < n; i++) {
            maxValue = Math.max(maxValue, nums[i]);

            sum += nums[i];

            int wasteSum = maxValue * (i - index + 1) - sum;

            dp[k][index] = Math.min(dp[k][index], wasteSum + solve(i + 1, nums, k - 1));

        }

        return dp[k][index];
    }
}