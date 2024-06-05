class Solution {
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] visited = new boolean[n];
        int[] arr = new int[n];
        long fact = 1;
        long num = n;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        k--;
        while (num > 0) {
            fact = fact / num;
            long div = k / fact;

            k = k % fact;
            num--;

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (count == div) {
                    visited[i] = true;
                    answer[index++] = arr[i];
                    break;
                }
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            answer[index++] = arr[i];
            visited[i] = true;
        }
        return answer;
    }
}