import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int[] arr;
    private static int answer = Integer.MAX_VALUE;
    private static int elementA = 0;
    private static int elementB = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int tc = 0; tc < n; tc++) {
            arr[tc] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i >= 1; i--) {
            binarySearch(0, i - 1, arr[i]);
        }

        System.out.println(elementA + " " + elementB);
    }

    public static int binarySearch(int first, int end, int val) {
        if (first > end) {
            return 0;
        }

        int mid = (first + end) / 2;
        int element = arr[mid];
        int sum = val + element;
        int diff = Math.abs(sum);

        if (answer > diff) {
            elementA = element;
            elementB = val;
            answer = diff;
        }

        if (sum > 0) {
            binarySearch(first, mid - 1, val);
        } else {
            binarySearch(mid + 1, end, val);
        }

        return 0;
    }
}
