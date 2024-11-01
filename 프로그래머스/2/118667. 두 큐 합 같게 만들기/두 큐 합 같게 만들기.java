import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i : queue1) {
            sum1 += i;
            q1.add(i);

        }
          
        for(int i : queue2) {
            sum2 += i;
            q2.add(i);
     
        }

        
        
        int count = 0;
        int pop = 0;
        while(true) {
            if(count > (q1.size() + q2.size())*2) {
                return -1;
            }
            if(sum1 == sum2) break;             // 종료 조건
            
            // sum1 과 sum2 를 비교해서 더 큰곳에 있는 q 를 pop 한다
            
            if(sum1 > sum2) {
                pop = q1.poll();
                sum1 -= pop;
                sum2 += pop;
                q2.add(pop);
            } else {
                      pop = q2.poll();
                sum2 -= pop;
                sum1 += pop;
                q1.add(pop);
            }
            
            
            // 일단 이걸 계속 반복해보쟈
            count++;
        }
        
        answer = count;
        
        
        return answer;
    }
}