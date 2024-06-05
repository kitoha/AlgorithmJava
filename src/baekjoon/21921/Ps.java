import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps {
    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        int ans = 0;
        int count = 0;

        for (int i = x; i <= n; i++) {
            int val = sum[i] - sum[i - x];
            if (ans < val) {
                ans = val;
                count = 1;
            } else if (ans == val) {
                count++;
            }
        }

        if (ans > 0) {
            System.out.println(ans);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }
    }
}
