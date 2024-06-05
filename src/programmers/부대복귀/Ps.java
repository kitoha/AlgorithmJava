import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

class Ps {
    private static List<Integer>[] adj;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        adj = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }

        int[] dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        bfs(destination, n, dist);
        for (int i = 0; i < sources.length; i++) {
            int node = sources[i];
            answer[i] = dist[node] == Integer.MAX_VALUE ? -1 : dist[node];
        }

        return answer;
    }

    public static int bfs(int start, int n, int[] dist) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        dist[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < adj[node].size(); i++) {
                int nextNode = adj[node].get(i);

                if (dist[nextNode] > dist[node] + 1) {
                    dist[nextNode] = dist[node] + 1;
                    queue.add(nextNode);
                }
            }
        }

        return 0;
    }
}