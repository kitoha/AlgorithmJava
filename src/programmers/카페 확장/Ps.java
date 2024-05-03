import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static int solution(int[] menu, int[] order, int k) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        int inTime = 0;
        int lastOrderTime = 0;
        for (int i = 0; i < order.length; i++) {
            int cost = menu[order[i]];
            inTime = i * k;
            while (!queue.isEmpty()) {
                if (queue.peek() > inTime) {
                    break;
                }
                queue.poll();
            }

            if (!queue.isEmpty()) {
                lastOrderTime += cost;
            } else {
                lastOrderTime = inTime + cost;
            }
            queue.add(lastOrderTime);
            answer = Math.max(answer, queue.size());
        }
        return answer;
    }

}