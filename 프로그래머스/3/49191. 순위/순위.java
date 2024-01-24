import java.util.*;

class Solution {
    // 2,7,8,9 실패 : 
    public int solution(int n, int[][] results) {
        int answer = 0;
         
    int[][] table = new int[n+1][n+1];
        
    // 이기면 1 지면 -1    
    for(int j =0; j<results.length;j++) {
            int a = results[j][0];        
            int b = results[j][1];
        
        table[a][b] = 1;
        table[b][a] = -1;
    }
        
for(int l =1; l<=n;l++) {
    for(int p = 1; p<=n;p++) {
        // winner   12,23
        for(int m = 1;m<=n;m++) {
            if(table[l][p] == 1 && table[p][m] == 1) { 
                table[l][m] = 1;
                table[m][l] = -1;
            }
            if(table[l][p] == -1 && table[m][p] == 1) {
                table[m][l] = 1;
                table[l][m] = -1;
            }
        }
        }
        
        // loser  
        //     for(int c= 1;c<=n;c++) {
        //     if(table[b][c] == 1) {
        //         table[l][c] = 1;
        //         table[c][l] = -1;
        //     }
        // }
        
    }
        
        for(int x = 1;  x<=n;x++) {
            for(int y = 1;y<=n;y++) {
                System.out.print(table[x][y] +" ");
            }
            System.out.println();
        }
        
        
    for(int num = 1; num<=n;num++) {
        boolean flag = true;
        for(int t = 1; t<=n;t++) {
            if(num == t) continue;
            
            if(table[num][t] == 0) {flag = false; break;}            
        }
        
        if(flag) answer++;
        
        
    }
        
        
        return answer;
    }
    
    
}