import java.util.*;


class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        int[] dp = new int[prices.length];    
        
    
        for(int i = prices.length-1;i>=0;i--) {
            int price = prices[i];
            int num =0;               

            for(int j = i+1;j<prices.length;j++) {
                // System.out.print(i+" "+j+"");
                num++;
                if(price >prices[j]) {
                    break;
                }
                    
            }
            
            dp[i] = num;
        }
        
       //                System.out.println();

        
//         for(int i : dp) {
//             System.out.print(i+" ");
//         }
        
        return dp;
    }
}