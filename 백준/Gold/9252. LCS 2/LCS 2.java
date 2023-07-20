import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static String s1, s2;
    static char[] c1,c2;
    static int[][] dp;
    static int max;
    static char[] ans;

    static int Solution(int s1Len, int s2Len) {
        for(int i =1; i<s1Len+1;i++) {
            for(int j=1;j<s2Len+1;j++) {
                if(c1[i] == c2[j]) dp[i][j] = dp[i-1][j-1] +1;
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }



            }
        }


        return dp[s1Len][s2Len];
    }

    static void LCS(int i,int j,int k) {
        if(i ==0 || j == 0) {
            return;
        } else if(c1[i] == c2[j]) {
            ans[k] = c1[i];
            LCS(i-1,j-1,++k);
        }
        else {
            if(dp[i][j] == dp[i-1][j])  LCS(i-1,j,k);
            else
                LCS(i,j-1,k);
        }


    }


    public static void main(String[] args ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s1 = br.readLine();
        s2 = br.readLine();


        int s1Len = s1.length();
        int s2Len = s2.length();

        // String -> 문자배열로 바꿔서 넣어줌.
        c1 = new char[s1Len+1];
        c2 = new char[s2Len+1];

        for(int i=1;i<s1Len+1;i++) c1[i] = s1.charAt(i-1);
        for(int j=1;j<s2Len+1;j++) c2[j] = s2.charAt(j-1);

        dp = new int[s1Len+1][s2Len+1];

        max = Solution(s1Len,s2Len);
        bw.write(max+"\n");

        if(max == 0) bw.write("");
        else {
            ans = new char[max];
            LCS(s1Len,s2Len,0);
            for(int x = max-1;x>=0;x--)
                bw.write(ans[x]);

        }





        bw.flush();
        br.close();
        bw.close();












    }




}