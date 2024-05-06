class Ps {
    public static int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        int[] sumA = new int[n];
        int[] sumB = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumA[i] = a[i];
            } else {
                sumA[i] = Math.min(sumA[i - 1], a[i]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                sumB[i] = a[i];
            } else {
                sumB[i] = Math.min(sumB[i + 1], a[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            int leftMinValue = i - 1 < 0 ? Integer.MAX_VALUE : sumA[i - 1];
            int rightMinValue = i + 1 >= n ? Integer.MAX_VALUE : sumB[i + 1];
            int currentValue = a[i];

            if (currentValue > leftMinValue && currentValue > rightMinValue) {
                continue;
            }

            answer++;
        }
        return answer;
    }
}