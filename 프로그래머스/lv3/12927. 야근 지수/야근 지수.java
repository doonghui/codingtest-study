import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : works) pQ.add(i);
        
        while(n != 0) { 
            Integer work = pQ.poll();
            if(work == 0) break;                // work 가 0이나온다는 말은 더이상 작업할게 없다는 말이니 break;
            work -= 1; 
            n--;
            pQ.add(work);
        }
        
        while(!pQ.isEmpty()) {
            answer += Math.pow(pQ.poll(),2);
        }
        
        
        
        
        return answer;
    }
}