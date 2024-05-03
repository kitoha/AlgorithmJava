import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static int[][] maps;
    private static int[][][] dist;
    private static int[] dy = { -1, 1, 0, 0 };
    private static int[] dx = { 0, 0, -1, 1 };

    public static int solution(int n, int m, int[][] hole) {
        int answer = 0;

        maps = new int[m][n];

        for (int i = 0; i < hole.length; i++) {
            int[] pos = hole[i];
            int x = pos[0] - 1;
            int y = pos[1] - 1;
            maps[y][x] = 1;
        }

        Queue<Point> queue = new LinkedList<>();

        dist = new int[2][m][n];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dist[k][i][j] = Integer.MAX_VALUE;
                }
            }
        }
        queue.add(new Point(0, 0, 0, 1));
        dist[1][0][0] = 0;
        dist[0][0][0] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int y = point.y;
            int x = point.x;
            int ticket = point.ticket;

            for (int i = 0; i <= 3; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= m | nx < 0 || nx >= n)
                    continue;

                if (maps[ny][nx] == 1) {
                    ny += dy[i];
                    nx += dx[i];
                    if (ny < 0 || ny >= m | nx < 0 || nx >= n || (maps[ny][nx] == 1))
                        continue;
                    if (ticket > 0 && dist[0][ny][nx] > dist[1][y][x] + 1) {
                        dist[0][ny][nx] = dist[1][y][x] + 1;
                        queue.add(new Point(ny, nx, dist[0][ny][nx], 0));
                    }
                } else {
                    if (dist[ticket][ny][nx] > dist[ticket][y][x] + 1) {
                        dist[ticket][ny][nx] = dist[ticket][y][x] + 1;
                        queue.add(new Point(ny, nx, dist[ticket][ny][nx], ticket));
                    }
                }

            }
        }

        answer = Math.min(dist[0][m - 1][n - 1], dist[1][m - 1][n - 1]);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static class Point {
        int y, x, cost, ticket;

        public Point(int y, int x, int cost, int ticket) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.ticket = ticket;
        }
    }
}