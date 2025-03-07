import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<Long>(new Comparator<Long>() {
    @Override
    public int compare(Long o1, Long o2) {
        return (int)(o1 - o2);
    }
});
        
        for(Integer i : scoville) pq.add((long)i);

    while(!pq.isEmpty()) {
      long sco = pq.poll();
            
      if(sco >= K) break;
            
      if(pq.isEmpty()) {
          answer = -1;
          break;}
       
            
      long mix = sco + (2* pq.poll());

        pq.add(mix);
            
        answer++;
        }
        
        
        
        return answer;
    }
}

