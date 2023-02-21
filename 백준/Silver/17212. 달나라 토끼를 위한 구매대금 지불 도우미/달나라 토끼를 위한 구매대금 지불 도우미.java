import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    static BigInteger sol;


    static int n;
    static int[] dp;
    static int[] coin = {1, 2, 5, 7};

    static int Sol(int n) {

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < 4; i++) {
                if (j - coin[i] < 0)
                    continue;
                dp[j] = Math.min(dp[j], dp[j - coin[i]]+1);
            }

        }
        return dp[n];

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        bw.write(Sol(n) + "");
        br.close();
        bw.flush();
        bw.close();
    }
}



