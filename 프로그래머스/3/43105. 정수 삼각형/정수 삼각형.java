import java.util.*;

class Solution {
    public  int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][500];
        dp[0][0] = triangle[0][0];

        for(int i =1;i<triangle.length;i++) {
            for(int j =0;j<triangle[i].length;j++) {
                if(j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                } else if(j == triangle[i].length-1) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                } else
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);

            }
        }

//        for(int a : dp[triangle.length-1]) {
//            System.out.print(a+" ");
//        }
        Arrays.sort(dp[triangle.length-1]);
        answer = dp[triangle.length-1][499];

        // 0 -> 0, 1
        // 1 -> 1,2
        // 2 -> 2,3
        // 3 -> 3,4
        // 4 -> 4,5



        return answer;
    }
}