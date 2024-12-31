import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        
        // 홀수
            while(n != 0) {
                if(n %2 == 1) {
                    ans +=1;
                    n -=1;
                } else {
                n /=2;                    
                }
            }
  
        
        
        

        return ans;
    }
}