import java.util.LinkedList;
import java.util.Queue;

class Ps {
    private static boolean[][] visited;
    private static int[] dy = { -1, 1, 0, 0 };
    private static int[] dx = { 0, 0, -1, 1 };
    private static int n, m;

    public static int solution(String[] maps) {
        Point startPoint = null;
        Point leverPoint = null;
        n = maps.length;
        m = maps[0].length();

        for (int i = 0; i < n; i++) {
            String map = maps[i];
            for (int j = 0; j < m; j++) {
                char val = map.charAt(j);

                if (val == 'S') {
                    startPoint = new Point(i, j, 0);
                } else if (val == 'L') {
                    leverPoint = new Point(i, j, 0);
                }
            }
        }

        int startToLever = bfs(startPoint.y, startPoint.x, 'L', maps);
        int leverToEnd = bfs(leverPoint.y, leverPoint.x, 'E', maps);

        if (startToLever == -1 || leverToEnd == -1) {
            return -1;
        }

        return startToLever + leverToEnd;
    }

    public static int bfs(int y, int x, char end, String[] maps) {

        visited = new boolean[n][m];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(y, x, 0));

        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cy = point.y;
            int cx = point.x;
            int cost = point.cost;

            if (maps[cy].charAt(cx) == end) {
                return cost;
            }

            for (int i = 0; i <= 3; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;

                if (visited[ny][nx] || maps[ny].charAt(nx) == 'X')
                    continue;

                visited[ny][nx] = true;
                queue.add(new Point(ny, nx, cost + 1));
            }
        }

        return -1;

    }

    public static class Point {
        int y, x, cost;

        public Point(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}