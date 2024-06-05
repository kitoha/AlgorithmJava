class Solution {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && nums[mid] >= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target <= nums[hi] && nums[mid] <= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}