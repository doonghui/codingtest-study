import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] cityMap) {
        
       long[][][] dp = new long[m][n][2];
        int MOD = 20170805;

        sol(m,n,cityMap,dp,MOD);
        
        int answer = (int)((dp[m - 1][n - 1][0] + dp[m-1][n-1][1])%MOD);
        
        
        
        return answer;
    }
    
    
        static void sol(int m, int n, int[][] cityMap,long[][][] dp,int MOD) {
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for(int i= 0; i<m;i++){
            if(cityMap[i][0] == 1) break;
            dp[i][0][0] = 1;
        }
        for(int j= 0; j<n;j++){
            if(cityMap[0][j] == 1) break;
            dp[0][j][1] = 1;
        }

        // 1. 전 위치가 모든 0 일때
        // 2. 전위치중 하나라도 2일때
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                if(cityMap[x][y-1] != 1) {
                    if(cityMap[x][y-1] == 0)  dp[x][y][1] = (dp[x][y-1][0] + dp[x][y-1][1]) % MOD;
                    else
                        dp[x][y][1] = dp[x][y-1][1] % MOD;
                }
                if(cityMap[x-1][y] != 1) {
                    if(cityMap[x-1][y] == 0)  dp[x][y][0] = (dp[x-1][y][0] + dp[x-1][y][1]) % MOD;
                    else dp[x][y][0] = dp[x-1][y][0] % MOD;
                }


            }
        }


    }
}