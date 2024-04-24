import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps {
    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int test = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= test; tc++) {
            int n;
            st = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];
            int ans = 0;

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    int val = i - 1 < 0 ? 0 : dp[(j + 1) % 2][i - 1];
                    int val2 = i - 2 < 0 ? 0 : dp[(j + 1) % 2][i - 2];
                    dp[j][i] = Math.max(val, val2) + arr[j][i];
                    ans = Math.max(ans, dp[j][i]);
                }
            }

            System.out.println(ans);

        }
    }
}
