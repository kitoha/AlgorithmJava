import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ps {
    private static long[] arr;
    private static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        long[] answer = new long[3];
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        arr = new long[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            visited[i] = false;
        }

        Arrays.sort(arr);
        long minVaule = Long.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                long diff = Math.abs(sum);

                if (minVaule > diff) {
                    minVaule = diff;
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        Arrays.sort(answer);

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
