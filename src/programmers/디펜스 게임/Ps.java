import java.util.Arrays;

class Ps {
    public static int solution(int n, int k, int[] enemy) {
        int length = enemy.length;
        Pair[] enPair = new Pair[length];

        for (int i = 0; i < length; i++) {
            enPair[i] = new Pair(enemy[i], i);
        }

        int lo = 0;
        int hi = length - 1;
        int answer = 0;

        Arrays.sort(enPair);

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int remainK = k;
            long remainN = n;

            for (int i = length - 1; i >= 0; i--) {
                Pair pair = enPair[i];

                if (pair.index <= mid) {
                    if (remainK > 0) {
                        remainK--;
                    } else {
                        remainN -= pair.enemy;
                    }
                }
            }

            if (remainN >= 0) {
                lo = mid + 1;
                answer = Math.max(answer, mid + 1);
            } else {
                hi = mid - 1;
            }
        }

        return answer;
    }

    public static class Pair implements Comparable<Pair> {
        int enemy, index;

        public Pair(int enemy, int index) {
            this.enemy = enemy;
            this.index = index;
        }

        @Override
        public int compareTo(Pair target) {
            return this.enemy - target.enemy;
        }
    }
}