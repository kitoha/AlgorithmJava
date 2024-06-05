import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> maps = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            maps.put(nums[i], 1);
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            Integer cnt = maps.get(num - 1);

            if (cnt == null) {
                int k = num;
                while (true) {
                    k++;
                    Integer count = maps.get(k);
                    if (count == null) {
                        break;
                    }
                }
                answer = Math.max(answer, k - num);
            }

        }

        return answer;
    }
}