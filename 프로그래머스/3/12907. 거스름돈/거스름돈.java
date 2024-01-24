import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        long[] dp = new long[n+1];   
        for(int m : money) {
            dp[m] += 1;
            
            for(int i = m+1; i<=n;i++) {
                dp[i] = (dp[i] + dp[i-m]) % 1000000007;
            }
            
        }
    
        
        answer = (int)dp[n];
        
        return answer;
    }
}