import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps {

    public static void main(String args[]) throws Exception {
        System.setIn(
                new FileInputStream("C:\\Users\\kitoha\\Desktop\\알고리즘\\pslove\\pslove\\pslove\\src\\input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] pizza1 = new int[m];
        int[] pizza2 = new int[n];
        int sum = 0;

        int[] sumA = new int[1000001];
        int[] sumB = new int[1000001];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            pizza1[i] = Integer.parseInt(st.nextToken());
            sum += pizza1[i];
        }

        sumA[sum]++;
        sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            pizza2[i] = Integer.parseInt(st.nextToken());
            sum += pizza2[i];
        }

        sumB[sum]++;

        int ans = 0;

        for (int i = 0; i < m; i++) {
            sum = 0;
            for (int j = 0; j < m - 1; j++) {
                sum += pizza1[(i + j) % m];
                sumA[sum]++;
            }
        }

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n - 1; j++) {
                sum += pizza2[(i + j) % n];
                sumB[sum]++;
            }
        }

        for (int i = 0; i <= target; i++) {
            int remain = target - i;
            if (i == 0) {
                ans += sumB[remain];
            } else if (i == target) {
                ans += sumA[i];
            } else {
                ans += (sumA[i] * sumB[remain]);
            }
        }

        System.out.println(ans);

    }
}
