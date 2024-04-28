import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps {
    private static int[] fail;
    private static int j = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        String p = st.nextToken();

        st = new StringTokenizer(bufferedReader.readLine());

        String s = st.nextToken();

        fail = new int[1000001];

        for (int i = 1; i < s.length(); i++) {
            while (j != 0 && s.charAt(i) != s.charAt(j)) {
                j = fail[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                fail[i] = ++j;
            }
        }

        j = 0;

        for (int i = 0; i < p.length(); i++) {
            while (j != 0 && p.charAt(i) != s.charAt(j)) {
                j = fail[j - 1];
            }

            if (p.charAt(i) == s.charAt(j)) {
                if (j == s.length() - 1) {
                    System.out.println(1);
                    return;
                } else {
                    j++;
                }
            }
        }

        System.out.println(0);

    }
}
