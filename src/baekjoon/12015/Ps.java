import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps {

    private static int[] arr;
    private static int[] lisArr;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        lisArr = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        lisArr[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (lisArr[ans] < arr[i]) {
                ans++;
                lisArr[ans] = arr[i];
            } else {
                int idx = binarySearch(0, ans, arr[i]);
                lisArr[idx] = arr[i];
            }
        }

        System.out.println(ans + 1);
    }

    public static int binarySearch(int first, int end, int val) {

        while (first <= end) {
            int mid = (first + end) / 2;

            if (lisArr[mid] < val) {
                first = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return first;

    }
}
