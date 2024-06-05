class Solution {
    public static int[] solution(long begin, long end) {
        int n = (int) (end - begin + 1);
        int[] answer = new int[n];
        int idx = 0;

        for (long i = begin; i <= end; i++) {
            answer[idx++] = (int) getDivisorCount(i);
        }
        return answer;
    }

    public static long getDivisorCount(long value) {
        long result = 0;
        for (long i = 1; i * i <= value; i++) {
            long divisor = value % i;
            long div = value / i;

            if (divisor == 0) {

                if (value / div != 1 && div <= 10000000) {
                    result = Math.max(result, div);
                }
                if (value / i != 1 && i <= 10000000) {
                    result = Math.max(result, i);
                }
            }
        }

        return result;
    }

}