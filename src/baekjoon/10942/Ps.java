import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps {
    private static int[][] dp;
    private static int[] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        dp = new int[n + 1][n + 1];

        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        st = new StringTokenizer(bufferedReader.readLine());

        int m = Integer.parseInt(st.nextToken());
        StringBuffer sBuffer = new StringBuffer();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int lo = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());

            if (dp[lo][hi] == -1) {
                sBuffer.append(getPalindrome(lo, hi) + "\n");
            } else {
                sBuffer.append(dp[lo][hi] + "\n");
            }
        }

        System.out.println(sBuffer.toString());

    }

    public static int getPalindrome(int lo, int hi) {
        if (lo >= hi) {
            return dp[lo][hi] = 1;
        }

        if (dp[lo][hi] != -1)
            return dp[lo][hi];

        if (arr[lo] != arr[hi])
            return dp[lo][hi] = 0;
        else
            return dp[lo][hi] = getPalindrome(lo + 1, hi - 1);
    }
}
