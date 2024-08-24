import java.util.*;



class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 내림차순
        
        for(int i =0;i<priorities.length;i++) {
            pq.add(priorities[i]);
        } 
        
        
        boolean flag = false;
        
        // 뒤에꺼랑 비교해보고 더 큰게 없으면 완전히 꺼낸다 
        // 있으면 다시 뒤에 넣는다
        // 만약 꺼낸 순서가 location 과 같다면 바로 return
        
        while(!flag) {
            for(int j = 0;j<priorities.length;j++) {
                int pri = pq.poll();                            // 맨 앞에 꺼냄
                if(priorities[j] == pri) {
                    answer++;
                    
                    if(j == location) {flag = true;;
                                      break;
                                      }
                } else {
                    pq.add(pri);                                // 제일 큰게 아
                }
            }
  
        }

        return answer;
    }
}
