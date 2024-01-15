import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 1;
        
        
        int lt = 0;
        int rt = a.length-1;
        int ltMin = a[lt];
        int rtMin = a[rt];

        // 작 큰 작 (x)
        while(lt < rt) {
            if(ltMin > rtMin) {
                lt++;
                if(a[lt] < ltMin) answer++;
                
              ltMin = Math.min(a[lt],ltMin);
            } else {
                rt--;
                if(a[rt] < rtMin) answer++;
                
            rtMin = Math.min(a[rt],rtMin);
                
                
            }
            
            
    
            
        }
        
        
        return answer;
    }
}