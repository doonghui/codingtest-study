	import java.util.*;
 
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int W = sc.nextInt();
        int treeArr[] = new int[1001];
        int dp[][][] = new int[T+1][W+1][3];
        treeArr[0] = 1; 
        for(int i = 1; i<=T; i++){
            treeArr[i] = sc.nextInt();
        }
 
        if(treeArr[1] == 1){    
            dp[1][0][1] = 1;  
            dp[1][1][2] = 0;  
        }
        else{                
            dp[1][0][1] = 0;  
            dp[1][1][2] = 1;   
 
        }
 
 
        for(int t = 2; t<=T; t++){
 
            if(treeArr[t] == 1){ 
                dp[t][0][1] = dp[t-1][0][1] + 1;  
                dp[t][0][2] = dp[t-1][0][2];       
 
                for(int w = 1; w<=W; w++){
                    dp[t][w][1] = Math.max(dp[t-1][w][1], dp[t-1][w-1][2])+ 1;
                    dp[t][w][2] = Math.max(dp[t-1][w-1][1], dp[t-1][w][2]);
                }
            }
 
            else{              
                dp[t][0][1] = dp[t-1][0][1];       
                dp[t][0][2] = dp[t-1][0][2] + 1;  
 
 
 
                for(int w = 1; w<=W; w++){
                    dp[t][w][1] = Math.max(dp[t-1][w][1], dp[t-1][w-1][2]);
                    dp[t][w][2] = Math.max(dp[t-1][w-1][1], dp[t-1][w][2]) + 1;
                }
            }
 
 
        }
 
        int ans = 0;  
        for(int w = 0; w<=W; w++){
            ans = Math.max(ans, Math.max(dp[T][w][1], dp[T][w][2]));
        }
        System.out.println(ans);
    }
}