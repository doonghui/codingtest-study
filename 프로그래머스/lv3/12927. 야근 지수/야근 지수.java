import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
            long answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            PQ.offer(works[i]);
        }

        for (int i = 0; i < n; i++) {
            PQ.offer(PQ.poll()-1);
        }

        while(!PQ.isEmpty()) {
            long p = PQ.poll();
            answer += p > 0 ? Math.pow(p, 2) : 0;
        }

        return answer;

    }
}