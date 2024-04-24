import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ps {
    private static int h, w;
    private static char[][] gridMap;
    private static int[] alpabet;
    private static boolean[][] visited;
    private static int[] dy = { -1, 1, 0, 0 };
    private static int[] dx = { 0, 0, -1, 1 };
    private static int answer;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int test = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= test; tc++) {
            st = new StringTokenizer(bufferedReader.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            answer = 0;

            gridMap = new char[h + 3][w + 3];
            visited = new boolean[h + 3][w + 3];
            alpabet = new int[27];

            for (int i = 0; i <= h + 1; i++) {
                for (int j = 0; j <= w + 1; j++) {
                    gridMap[i][j] = '.';
                    visited[i][j] = false;
                }
            }

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                String line = st.nextToken();
                for (int j = 1; j <= w; j++) {
                    gridMap[i][j] = line.charAt(j - 1);
                }
            }

            st = new StringTokenizer(bufferedReader.readLine());
            String keys = st.nextToken();
            keySetting(keys);

            bfs(0, 0);

            System.out.println(answer);

        }
    }

    public static void bfs(int y, int x) {

        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(y, x));

        Queue<Point>[] warpPoint = new LinkedList[27];

        for (int i = 0; i < 27; i++) {
            warpPoint[i] = new LinkedList<>();
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int currentY = point.y;
            int currentX = point.x;

            for (int i = 0; i <= 3; i++) {
                int ny = currentY + dy[i];
                int nx = currentX + dx[i];

                if (ny < 0 || nx < 0 || ny >= h + 2 || nx >= w + 2 || visited[ny][nx]) {
                    continue;
                }

                boolean isNext = true;

                if (gridMap[ny][nx] >= 'A' && gridMap[ny][nx] <= 'Z') {
                    int num = gridMap[ny][nx] - 'A';
                    if (alpabet[num] <= 0) {
                        isNext = false;
                        warpPoint[num].add(new Point(ny, nx));
                    }
                } else if (gridMap[ny][nx] >= 'a' && gridMap[ny][nx] <= 'z') {
                    int num = gridMap[ny][nx] - 'a';
                    while (!warpPoint[num].isEmpty()) {
                        queue.add(warpPoint[num].poll());
                    }
                    alpabet[num] = 1;
                } else if (gridMap[ny][nx] == '$') {
                    answer++;
                    isNext = true;
                } else if (gridMap[ny][nx] == '*') {
                    isNext = false;
                }

                if (isNext) {
                    queue.add(new Point(ny, nx));
                    visited[ny][nx] = true;
                }

            }
        }
    }

    public static void keySetting(String keys) {
        if ("0".equals(keys)) {
            return;
        }
        for (int i = 0; i < keys.length(); i++) {
            int num = keys.charAt(i) - 'a';
            alpabet[num]++;
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
