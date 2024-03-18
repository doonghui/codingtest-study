import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        if (N == 1) {
            bw.write("0");
        } else if (N <= 3) {
            bw.write("1");
        } else {
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= N; i++) {
                if (i % 2 == 0 && i % 3 == 0) {
                    dp[i] = Math.min(dp[i / 3], (Math.min(dp[i / 2], dp[i - 1]))) + 1;
                } else if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
                } else if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
                } else if (i % 2 != 0 && i % 3 != 0) {
                    dp[i] = dp[i - 1] + 1;

                }

            }
            bw.write(dp[N] + "");

        }


        br.close();
        bw.flush();
        bw.close();
    }


}
