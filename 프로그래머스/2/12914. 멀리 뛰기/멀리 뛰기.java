class Solution {
    static long INF = 1234567;
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;
        
        
        if(n <= 2) answer = dp[n];
        else {
            for(int i = 3;i<=n;i++) dp[i] = (dp[i-1] + dp[i-2])%INF;
            
            
            answer = dp[n];
        }
        
        
        return answer;
    }
}


