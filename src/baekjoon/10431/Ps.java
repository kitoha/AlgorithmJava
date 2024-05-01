import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps {
    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int test = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= test; tc++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int t = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int total = 0;

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) {
                        total++;
                    }
                }
            }

            System.out.println(t + " " + total);

        }

    }
}
