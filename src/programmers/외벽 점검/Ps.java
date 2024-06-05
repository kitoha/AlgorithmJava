class Solution {
    private static int[] weeks;
    private static int[] arr;
    private static boolean[] visited;

    public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        int m = weak.length;
        int k = dist.length;
        arr = new int[k];
        visited = new boolean[k];
        weeks = new int[m + m];

        for (int i = 0; i < m + m; i++) {
            if (m <= i) {
                weeks[i] = weak[i - m] + n;
            } else {
                weeks[i] = weak[i];
            }
        }

        answer = permutation(0, dist.length, m, dist);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static int permutation(int idx, int n, int m, int[] dist) {
        if (idx == n) {
            return check(m);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            arr[idx] = dist[i];
            visited[i] = true;
            ans = Math.min(ans, permutation(idx + 1, n, m, dist));
            visited[i] = false;
        }
        return ans;
    }

    private static int check(int n) {
        int ans = Integer.MAX_VALUE;
        int m = arr.length;

        for (int i = 0; i < n; i++) {
            int start = weeks[i];
            int end = weeks[i + n - 1];

            for (int j = 0; j < m; j++) {
                start += arr[j];

                if (end <= start) {
                    ans = Math.min(ans, j + 1);
                    break;
                }

                for (int k = 0; k < n; k++) {
                    if (start < weeks[k]) {
                        start = weeks[k];
                        break;
                    }
                }

            }
        }

        return ans;
    }
}