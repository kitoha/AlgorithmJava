import java.util.Arrays;
import java.util.PriorityQueue;

public class Ps {
    public static long[] solution(int[][] program) {
        long[] answer = new long[11];
        PriorityQueue<WatingPoint> watingPointsQueue = new PriorityQueue<>();

        Arrays.sort(program, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        long totalTime = 0;

        for (int i = 0; i < program.length; i++) {
            int a = program[i][0];
            int b = program[i][1];
            int c = program[i][2];

            if (totalTime >= b) {
                watingPointsQueue.add(new WatingPoint(a, b, c));
                continue;
            } else {
                i--;
            }

            if (!watingPointsQueue.isEmpty()) {
                WatingPoint watingPoint = watingPointsQueue.poll();
                a = watingPoint.a;
                b = watingPoint.b;
                c = watingPoint.c;
                answer[a] += (totalTime - b);
                totalTime += c;
                continue;
            }

            totalTime = b;
        }

        while (!watingPointsQueue.isEmpty()) {
            WatingPoint watingPoint = watingPointsQueue.poll();
            int a = watingPoint.a;
            int b = watingPoint.b;
            int c = watingPoint.c;
            answer[a] += (totalTime - b);
            totalTime += c;
        }

        answer[0] = totalTime;

        return answer;
    }

    public static class WatingPoint implements Comparable<WatingPoint> {
        int a, b, c;

        public WatingPoint(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(WatingPoint target) {
            if (this.a == target.a) {
                return this.b - target.b;
            }
            return this.a - target.a;
        }
    }
}
