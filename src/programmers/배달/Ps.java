import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Ps {
    private static int[] dist;
    private static List<Pair>[] pointList;

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        pointList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            pointList[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int[] element = road[i];
            int a = element[0];
            int b = element[1];
            int cost = element[2];
            pointList[a].add(new Pair(b, cost));
            pointList[b].add(new Pair(a, cost));
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Pair(1, 0));
        dist[1] = 0;

        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            int b = pair.b;

            for (Pair next : pointList[b]) {
                int nextNode = next.b;
                int nextCost = next.cost;

                if (dist[nextNode] > dist[b] + nextCost) {
                    dist[nextNode] = dist[b] + nextCost;
                    priorityQueue.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (K >= dist[i]) {
                answer++;
            }
        }

        return answer;
    }

    public static class Pair implements Comparable<Pair> {
        int b, cost;

        public Pair(int b, int cost) {
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair target) {
            return this.cost = target.cost;
        }
    }

}