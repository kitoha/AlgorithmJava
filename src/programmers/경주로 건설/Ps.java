import java.util.PriorityQueue;

class Solution {

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int m = board[0].length;
        int[][][] dist = new int[4][n][m];
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };

        for (int k = 0; k <= 3; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dist[k][i][j] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i <= 3; i++) {
            dist[i][0][0] = 0;
        }
        priorityQueue.add(new Point(0, 0, -1, 0));

        while (!priorityQueue.isEmpty()) {
            Point point = priorityQueue.poll();
            int y = point.y;
            int x = point.x;
            int direction = point.direction;

            for (int i = 0; i <= 3; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nextDirection = 0;

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }

                if (board[ny][nx] == 1) {
                    continue;
                }

                int cost = 0;
                if (direction == -1) {
                    cost = 100;
                    nextDirection = i;
                } else {
                    cost = i == direction ? 100 : 600;
                    nextDirection = direction;
                }

                if (dist[i][ny][nx] > dist[nextDirection][y][x] + cost) {
                    dist[i][ny][nx] = dist[nextDirection][y][x] + cost;
                    priorityQueue.add(new Point(ny, nx, i, dist[i][ny][nx]));
                }
            }
        }

        for (int i = 0; i <= 3; i++) {
            answer = Math.min(answer, dist[i][n - 1][m - 1]);
        }

        return answer;
    }

    public static class Point implements Comparable<Point> {
        int y, x, direction, cost;

        public Point(int y, int x, int direction, int cost) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point target) {
            return this.cost - target.cost;
        }
    }
}