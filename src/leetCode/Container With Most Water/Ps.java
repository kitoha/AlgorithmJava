class Solution {

    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int sum = 0;

        while (left <= right) {
            int leftValue = height[left];
            int rightValue = height[right];
            int length = right - left;
            int minValue = Math.min(leftValue, rightValue);

            sum = Math.max(sum, minValue * length);

            if (leftValue < rightValue) {
                left++;
            } else {
                right--;
            }
        }

        return sum;
    }

}