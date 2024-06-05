import java.util.Arrays;
import java.util.Collections;

class Ps {
    private static int[] pos;
    private static Integer[] sum;

    public static int solution(int[] cards) {
        int answer = 0;
        pos = new int[101];
        sum = new Integer[101];

        for (int i = 0; i <= 100; i++) {
            pos[i] = i;
            sum[i] = 0;
        }

        for (int i = 0; i < cards.length; i++) {
            int idx = i + 1;
            int card = cards[i];

            merge(idx, card);
        }

        for (int i = 0; i < cards.length; i++) {
            int u = find(cards[i]);
            sum[u]++;
        }

        Arrays.sort(sum, Collections.reverseOrder());

        answer = sum[0] * sum[1];
        return answer;
    }

    public static int find(int idx) {
        if (pos[idx] == idx)
            return idx;
        return pos[idx] = find(pos[idx]);
    }

    public static int merge(int u, int v) {
        int y = find(u);
        int x = find(v);

        if (y != x) {
            pos[y] = x;
            return 1;
        }
        return 0;
    }
}