import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ps {

    private static int[] pos;
    private static List<Integer>[] partyList;

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());

        int k = Integer.parseInt(st.nextToken());
        List<Integer> truePeople = new ArrayList<>();
        pos = new int[n + 1];
        partyList = new List[m];

        for (int i = 0; i <= n; i++) {
            pos[i] = i;
        }

        for (int i = 0; i < k; i++) {
            int people = Integer.parseInt(st.nextToken());
            truePeople.add(people);
        }

        for (int i = 0; i < m; i++) {
            partySetting(i, bufferedReader);
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean result = true;
            for (int p : partyList[i]) {
                int y = find(p);
                for (int trueP : truePeople) {
                    int x = find(trueP);
                    if (x == y) {
                        result = false;
                        break;
                    }
                }
            }

            if (result) {
                ans++;
            }

        }

        System.out.println(ans);

    }

    public static int find(int idx) {
        if (idx == pos[idx])
            return idx;
        return pos[idx] = find(pos[idx]);
    }

    public static int merge(int u, int v) {
        int y = find(u);
        int x = find(v);

        if (x != y) {
            pos[y] = x;
            return 1;
        }

        return 0;
    }

    public static void partySetting(int idx, BufferedReader bufferedReader) throws IOException {
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int before = 0;
        partyList[idx] = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            int current = Integer.parseInt(st.nextToken());
            partyList[idx].add(current);
            if (before == 0) {
                before = current;
                continue;
            }
            merge(before, current);
        }
    }
}
