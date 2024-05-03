import java.util.*;

class Ps {
    private static int[][] maps;
    private static int[] dy = { -1, 1, 0, 0 };
    private static int[] dx = { 0, 0, -1, 1 };

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int k = 0; k < places.length; k++) {
            List<Point> list = new ArrayList<>();
            maps = new int[5][5];
            int n = places[k].length;
            int m = 0;
            for (int i = 0; i < places[k].length; i++) {
                String str = places[k][i];
                m = str.length();
                for (int j = 0; j < str.length(); j++) {
                    char input = str.charAt(j);

                    if (input == 'P') {
                        maps[i][j] = 1;
                        list.add(new Point(i, j, 0));
                    } else if (input == 'X') {
                        maps[i][j] = 2;
                    }
                }
            }

            int ans = solve(n, m, list);
            answer[k] = ans;
        }
        return answer;
    }

    public static int solve(int n, int m, List<Point> list) {
        System.out.println();
        for (Point student : list) {
            boolean[][] visited = new boolean[n][m];
            Queue<Point> queue = new LinkedList<>();
            queue.add(student);
            visited[student.y][student.x] = true;

            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int y = point.y;
                int x = point.x;
                int dist = point.dist;

                for (int i = 0; i <= 3; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    }

                    if (visited[ny][nx] || maps[ny][nx] == 2) {
                        continue;
                    }

                    if (dist + 1 <= 2) {
                        if (maps[ny][nx] == 1) {
                            return 0;
                        }

                        queue.add(new Point(ny, nx, dist + 1));
                    }

                }

            }

        }

        return 1;
    }

    public static class Point {
        int y, x, dist;

        public Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

    }
}