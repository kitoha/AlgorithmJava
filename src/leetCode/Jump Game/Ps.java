class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxValue = 0;

        if (nums.length == 1) {
            return true;
        }

        for (int i = 0; i < n - 1; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            maxValue--;
            if (maxValue < 0) {
                return false;
            }
        }
        return true;
    }
}