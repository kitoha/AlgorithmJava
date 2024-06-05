class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] answer = new int[n];
        leftSum[0] = nums[0];
        rightSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            leftSum[i] = nums[i] * leftSum[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = nums[i] * rightSum[i + 1];
        }

        for (int i = 0; i < n; i++) {
            int value1 = i - 1 >= 0 ? leftSum[i - 1] : 1;
            int value2 = i + 1 < n ? rightSum[i + 1] : 1;
            answer[i] = value1 * value2;
        }

        return answer;
    }
}