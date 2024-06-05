import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int part = partition(arr, left, right);
        quickSort(arr, left, part - 1);
        quickSort(arr, part + 1, right);
        return 0;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = (left + right) / 2;
        while (left < right) {
            while (right >= left && arr[left] <= arr[pivot]) {
                left++;
            }
            while (right >= left && arr[right] >= arr[pivot]) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
            }
        }

        swap(arr, pivot, right);

        return right;
    }

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\kitoha\\Desktop\\알고리즘\\pslove\\pslove\\pslove\\src\\input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int[] arr = { 5, 3, 8, 9, 2, 4, 7 };

        quickSort(arr, 0, 6);

        for (int i = 0; i < 6; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
