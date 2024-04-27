import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ps {
    private static int[] dist;
    private static List<Point>[] adj;
    private static int n, e;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[a].add(new Point(b, cost));
            adj[b].add(new Point(a, cost));
        }

        st = new StringTokenizer(bufferedReader.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ansA = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int ansB = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        int ans = Math.min(ansA, ansB);

        if (ans < 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    public static int dijkstra(int start, int end) {

        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Point(start, dist[start]));

        while (!priorityQueue.isEmpty()) {
            Point point = priorityQueue.poll();
            int currentNode = point.b;

            for (Point next : adj[currentNode]) {
                int nextNode = next.b;
                int nextCost = next.cost;

                if (dist[nextNode] > dist[currentNode] + nextCost) {
                    dist[nextNode] = dist[currentNode] + nextCost;
                    priorityQueue.add(new Point(nextNode, dist[nextNode]));
                }
            }
        }

        return dist[end] == Integer.MAX_VALUE ? -1 * dist[end] : dist[end];
    }

    public static class Point implements Comparable<Point> {
        int b, cost;

        public Point(int b, int cost) {
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point p) {
            return this.cost - p.cost;
        }

    }
}
