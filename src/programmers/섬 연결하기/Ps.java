import java.util.*;

class Ps {
    private static int[] pos;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }

        });

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];

            int u = find(a);
            int v = find(b);

            if (merge(u, v) == 1) {
                answer += costs[i][2];
            }

        }
        return answer;
    }

    public static int find(int idx) {
        if (pos[idx] == idx)
            return idx;
        return pos[idx] = find(pos[idx]);
    }

    public static int merge(int u, int v) {
        int x = find(u);
        int y = find(v);

        if (x != y) {
            pos[y] = x;
            return 1;
        }
        return 0;
    }

}