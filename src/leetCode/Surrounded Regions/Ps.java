class Solution {
    private static boolean[][] visited;
    private static int n, m;

    public static void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || board[i][j] == 'X') {
                    continue;
                }
                bfs(i, j, board);
            }
        }
    }

    public static void bfs(int y, int x, char[][] board) {
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };

        Queue<Point> queue = new LinkedList<>();
        Queue<Point> region = new LinkedList<>();

        queue.add(new Point(y, x));

        int cnt = 0;
        boolean isBorder = false;
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int cy = point.y;
            int cx = point.x;

            region.add(new Point(cy, cx));
            if (cy == n - 1 || cy == 0 || cx == m - 1 || cx == 0) {
                isBorder = true;
            }

            for (int i = 0; i <= 3; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if (board[ny][nx] == 'X') {
                    cnt++;
                    continue;
                }

                visited[ny][nx] = true;

                queue.add(new Point(ny, nx));

            }
        }

        if (!isBorder && cnt > 0) {
            while (!region.isEmpty()) {
                Point point = region.poll();
                int cy = point.y;
                int cx = point.x;

                board[cy][cx] = 'X';
            }
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