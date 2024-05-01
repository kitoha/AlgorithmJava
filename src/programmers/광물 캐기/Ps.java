import java.util.HashMap;
import java.util.Map;

class Solution {

    private int n;
    private int[][] energy = { { 1, 1, 1 }, { 5, 1, 1 }, { 25, 5, 1 } };
    private Map<String, Integer> maps;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        n = minerals.length;

        maps = new HashMap<>();

        maps.put("diamond", 0);
        maps.put("iron", 1);
        maps.put("stone", 2);

        answer = dfs(0, picks, minerals);
        return answer;
    }

    public int dfs(int idx, int[] picks, String[] minerals) {
        if (idx >= n) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] <= 0) {
                continue;
            }

            picks[i]--;
            int cnt = 0;
            int cost = 0;
            int j = idx;
            while (j < minerals.length) {
                int mineralIdx = maps.get(minerals[j]);
                cost += energy[i][mineralIdx];
                cnt++;
                j++;
                if (cnt == 5) {
                    break;
                }
            }

            minCost = Math.min(minCost, dfs(j, picks, minerals) + cost);
            picks[i]++;

        }

        if (minCost == Integer.MAX_VALUE) {
            return 0;
        }
        return minCost;
    }

}