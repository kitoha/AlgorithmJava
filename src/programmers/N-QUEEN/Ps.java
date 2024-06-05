class Solution {
    private static int[] cols;

    public int solution(int n) {
        int answer = 0;
        cols = new int[n];
        answer = solve(0, n);

        return answer;
    }

    public int solve(int row, int n) {
        if (row == n) {
            return 1;
        }
        int answer = 0;

        for (int i = 0; i < n; i++) {
            cols[row] = i;

            if (check(row, n)) {
                answer += solve(row + 1, n);
            }
        }
        return answer;
    }

    public boolean check(int row, int n) {

        for (int i = 0; i < row; i++) {
            if (i == row || cols[row] == cols[i] || Math.abs(i - row) == Math.abs(cols[row] - cols[i])) {
                return false;
            }
        }

        return true;
    }
}