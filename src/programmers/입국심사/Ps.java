class Ps {
    public static long solution(int n, int[] times) {
        long answer = binarySearch(0, 1000000000000000000L, n, times);
        return answer;
    }

    public static long binarySearch(long lo, long hi, int n, int[] times) {
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long sum = 0;

            for (int i = 0; i < times.length; i++) {
                int time = times[i];
                sum += (mid / time);
            }

            if (sum >= n) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

}