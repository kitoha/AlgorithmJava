import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ps {
    private static int[] pos;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        pos = new int[n + 1];
        Point[] edge = new Point[m];

        for (int i = 1; i <= n; i++) {
            pos[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edge[i] = new Point(a, b, c);
        }

        Arrays.sort(edge);
        int cnt = 0;
        long ans = 0;
        for (int i = 0; i < m; i++) {
            if (cnt == n - 2) {
                break;
            }
            if (merge(edge[i].y, edge[i].x) == 1) {
                cnt++;
                ans += edge[i].cost;
            }
        }

        System.out.println(ans);

    }

    public static int find(int idx) {
        if (idx == pos[idx])
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

    public static class Point implements Comparable<Point> {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point target) {
            return this.cost - target.cost;
        }

    }
}
