
public class Ps {
    public String[] solution(int[][] queries) {
        String[] answer = {};
        int queryLength = queries.length;
        answer = new String[queryLength];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i] = solve(query[0], query[1] - 1);
        }
        return answer;
    }

    public String solve(int n, int p) {
        if (n == 1) {
            return "Rr";
        }

        String parentNode = solve(n - 1, p / 4);

        if (parentNode == "RR") {
            return "RR";
        } else if (parentNode == "rr") {
            return "rr";
        } else {
            int idx = p % 4;
            if (idx == 0)
                return "RR";
            else if (idx == 1 || idx == 2)
                return "Rr";
            else
                return "rr";
        }
    }
}
