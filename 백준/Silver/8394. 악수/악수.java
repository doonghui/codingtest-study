import java.io.*;
import java.math.BigInteger;

public class Main {
    static BigInteger sol;


    static int[]  dp;
    static int Sol(int n) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%10;
        }

        return dp[n];

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];


        bw.write(Sol(n)+"");
        br.close();
        bw.flush();
        bw.close();
    }
}


