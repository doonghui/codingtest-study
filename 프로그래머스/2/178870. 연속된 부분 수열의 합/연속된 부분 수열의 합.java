import java.util.*;

// 50, 61 .. 4~15, 23 오답    
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        
        int sum = 0;
        int lt = 0;
        int minLen = 1000001;
        
        
        // lt,rt 로 합이 k 개 이하인거 차
           for(int rt = 0;rt<sequence.length;rt++) {
            sum += sequence[rt];
            if(sum >= k) {
                while(sum >= k && lt <= rt) {
                    if(sum == k && rt-lt < minLen) {
                    minLen = rt-lt;
                    answer[0] = lt;
                    answer[1] = rt;
                    } 
                    sum -= sequence[lt];
                    lt++;
                }
                
                
            } 
                    // System.out.print(sum+" ");

       
        }
        
        

        
        return answer;
    }
}




