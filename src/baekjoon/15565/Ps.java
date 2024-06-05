import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ps {
    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (val == 1) {
                queue.add(i);
                sum++;
                if (sum > k) {
                    queue.poll();
                    sum--;
                }
                if (sum == k) {
                    int start = queue.peek();
                    distance = Math.min(distance, i - start + 1);
                }
            }
        }

        System.out.println(distance == Integer.MAX_VALUE ? -1 : distance);
    }
}
