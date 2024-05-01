]import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ps {
    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Point[] pointList = new Point[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pointList[i] = new Point(num, a, b, c);
        }

        Arrays.sort(pointList);
        int answer = 0;
        int[] medalInfo = new int[3];
        for (int i = 0; i < n; i++) {
            Point point = pointList[i];
            if (point.num == k) {
                medalInfo[0] = point.a;
                medalInfo[1] = point.b;
                medalInfo[2] = point.c;
                answer = i + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            Point point = pointList[i];
            if (point.num == k) {
                break;
            }

            if (point.a == medalInfo[0] && point.b == medalInfo[1] && point.c == medalInfo[2]) {
                answer--;
            }
        }

        System.out.println(answer);
    }

    public static class Point implements Comparable<Point> {
        int num, a, b, c;

        public Point(int num, int a, int b, int c) {
            this.num = num;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Point target) {
            if (this.a == target.a) {
                if (this.b == target.b) {
                    return target.c - this.c;
                }
                return target.b - this.b;
            }

            return target.a - this.a;
        }

    }
}
