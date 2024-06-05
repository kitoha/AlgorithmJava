import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        List<List<Integer>> list = new ArrayList<>();
        int lo, hi;
        lo = intervals[0][0];
        hi = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int value1 = intervals[i][0];
            int value2 = intervals[i][1];

            if (value1 <= hi) {
                hi = Math.max(hi, value2);
            } else {
                list.add(new ArrayList<>(Arrays.asList(lo, hi)));
                lo = value1;
                hi = value2;
            }
        }

        list.add(new ArrayList<>(Arrays.asList(lo, hi)));

        return list.stream()
                .map(p -> p.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}