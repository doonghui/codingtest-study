import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static String s1, s2;
    static char[] c1,c2;
    static int[][] dp;

    static int Solution(int s1Len, int s2Len) {
        for(int i =1; i<s1Len+1;i++) {
            for(int j=1;j<s2Len+1;j++) {
                if(c1[i-1] == c2[j-1]) dp[i][j] = dp[i-1][j-1] +1;
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }



            }
        }

        return dp[s1Len][s2Len];
    }


    public static void main(String[] args ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s1 = br.readLine();
        s2 = br.readLine();

        c1 = s1.toCharArray();
        c2 = s2.toCharArray();

        int s1Len = s1.length();
        int s2Len = s2.length();

        dp = new int[s1Len+1][s2Len+1];




        bw.write(Solution(s1Len,s2Len)+"");
        bw.flush();
        br.close();
        bw.close();












    }




}