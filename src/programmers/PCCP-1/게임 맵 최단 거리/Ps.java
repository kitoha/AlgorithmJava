import java.util.LinkedList;
import java.util.Queue;

class Ps {
    private boolean[][] visited;
    private int[][] dist;
    private int[] dy = { -1, 1, 0, 0 };
    private int[] dx = { 0, 0, -1, 1 };

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        visited = new boolean[n][m];
        dist = new int[n][m];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0));
        dist[0][0] = 1;
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int y = point.y;
            int x = point.x;

            if (y == n - 1 && x == m - 1) {
                return dist[y][x];
            }

            for (int i = 0; i <= 3; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                if (visited[ny][nx] || maps[ny][nx] == 0)
                    continue;
                visited[ny][nx] = true;

                dist[ny][nx] = dist[y][x] + 1;
                queue.add(new Point(ny, nx));
            }
        }

        return -1;
    }

    public class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }
}