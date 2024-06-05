import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        int index = (nums.length - (k % nums.length)) % nums.length;
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[index];
            index = (index + 1) % nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = answer[i];
        }
    }
}