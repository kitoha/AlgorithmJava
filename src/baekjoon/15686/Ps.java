import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Ps {
    private static List<Point> house = new ArrayList<>();
    private static List<Point> chicken = new ArrayList<>();
    private static int n;
    private static int m;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                int element = Integer.parseInt(st.nextToken());
                if (element == 1) {
                    house.add(new Point(i, j));
                } else if (element == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        int answer = dfs(0, new ArrayList<>());
        System.out.println(answer);

    }

    public static int dfs(int index, List<Point> chickenList) {
        if (chickenList.size() == m) {
            int answer = 0;
            for (int i = 0; i < house.size(); i++) {
                int cost = Integer.MAX_VALUE;
                Point point = house.get(i);
                for (int j = 0; j < chickenList.size(); j++) {
                    Point chickenPoint = chickenList.get(j);
                    int distance = Math.abs(point.r - chickenPoint.r) + Math.abs(point.c - chickenPoint.c);
                    cost = Math.min(cost, distance);
                }
                answer += cost;
            }
            return answer;
        }

        if (index >= chicken.size()) {
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, dfs(index + 1, new ArrayList<>(chickenList)));
        List<Point> newList = new ArrayList<>(chickenList);
        newList.add(chicken.get(index));
        ans = Math.min(ans, dfs(index + 1, newList));

        return ans;
    }

    static class Point {
        int r, c;

        public Point(int _r, int _c) {
            this.r = _r;
            this.c = _c;
        }
    }
}
