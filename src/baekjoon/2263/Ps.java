import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ps {

    private static int[] inorder;
    private static int[] postorder;

    public static List<Integer> solve(int left, int right, int postOrderLeft, int postOrderRight,
            List<Integer> result) {

        if (left > right) {
            return result;
        }
        int root = postorder[postOrderRight];
        result.add(root);

        int index = 0;

        for (int i = left; i <= right; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }

        int leftSize = index - left;

        solve(left, index - 1, postOrderLeft, postOrderLeft + leftSize - 1, result);
        solve(index + 1, right, postOrderLeft + leftSize, postOrderRight - 1, result);

        return result;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        inorder = new int[n];
        postorder = new int[n];

        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = solve(0, n - 1, 0, n - 1, new ArrayList<>());

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
