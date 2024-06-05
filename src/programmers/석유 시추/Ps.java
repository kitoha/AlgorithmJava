import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Ps {
    private static int[] dy = { -1, 1, 0, 0 };
    private static int[] dx = { 0, 0, -1, 1 };
    private static boolean[][] visited;
    private static int[] sum;
    private static int n, m;

    public static int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;

        sum = new int[m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || land[i][j] == 0) {
                    continue;
                }

                bfs(i, j, land);
            }
        }

        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, sum[i]);
        }

        return answer;
    }

    public static void bfs(int a, int b, int[][] land) {

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(a, b));

        Set<Integer> uniqueRow = new HashSet<>();

        visited[a][b] = true;

        int distance = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int y = point.y;
            int x = point.x;

            distance++;

            uniqueRow.add(x);

            for (int i = 0; i <= 3; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }

                if (visited[ny][nx] || land[ny][nx] == 0) {
                    continue;
                }

                visited[ny][nx] = true;

                queue.add(new Point(ny, nx));
            }
        }

        for (Integer num : uniqueRow) {
            sum[num] += distance;
        }
    }

    public static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}