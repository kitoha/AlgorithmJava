class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] zeroSum = new int[n];
        int[] oneSum = new int[n];

        for (int i = 0; i < n; i++) {
            char subString = s.charAt(i);
            int one = subString == '1' ? 1 : 0;
            int zero = subString == '0' ? 1 : 0;

            if (i == 0) {
                zeroSum[i] = zero;
                oneSum[i] = one;
            } else {
                zeroSum[i] = zeroSum[i - 1] + zero;
                oneSum[i] = oneSum[i - 1] + one;
            }
        }

        int answer = Math.min(zeroSum[n - 1], oneSum[n - 1]);

        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, oneSum[i] + (zeroSum[n - 1] - zeroSum[i]));
        }

        return answer;
    }
}