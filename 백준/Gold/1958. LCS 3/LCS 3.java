import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static String s1,s2,s3;
    static char[] c1,c2,c3;
    static int[][][] dp;


    static int Solution(int s1Len,int s2Len,int s3Len) {
        for(int i=1;i<=s1Len;i++) {
            for(int j =1;j<=s2Len;j++){
                for(int k =1;k<=s3Len;k++) {
                    if(c1[i] == c2[j] && c2[j] == c3[k]) {
                        dp[i][j][k] =dp[i-1][j-1][k-1] +1;
                    }  else {
                        int tmp = Math.max(dp[i][j-1][k],dp[i][j][k-1]);
                        int tmp2 = Math.max(dp[i-1][j][k],dp[i][j][k-1]);
                        int tmp3 = Math.max(dp[i-1][j][k],dp[i][j-1][k]);
                        int max = Math.max(tmp3,Math.max(tmp,tmp2));
                        dp[i][j][k] = max;
                    }

                }
            }
        }


        return dp[s1Len][s2Len][s3Len];
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s1 = br.readLine();
        s2 = br.readLine();
        s3 = br.readLine();

        int s1Len = s1.length();
        int s2Len = s2.length();
        int s3Len = s3.length();

        c1 = new char[s1Len+1];
        c2 = new char[s2Len+1];
        c3 = new char[s3Len+1];

        for(int i=1;i<=s1Len;i++) c1[i] = s1.charAt(i-1);
        for(int j=1;j<=s2Len;j++) c2[j] = s2.charAt(j-1);
        for(int k=1;k<=s3Len;k++) c3[k] = s3.charAt(k-1);

        dp = new int[s1Len+1][s2Len+1][s3Len+1];




        bw.write(Solution(s1Len,s2Len,s3Len)+"");
        bw.flush();
        br.close();
        bw.close();


    }


}