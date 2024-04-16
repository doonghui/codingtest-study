import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int N, K;
    static int[][] dp;
    static int INF = 1_000_000_000;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];


        for (int i = 1; i <= K; i++) {
            dp[1][i] = i;
        }
        for (int j = 1; j <= N; j++) {
            dp[j][1] = 1;
        }


        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                if (n == 1 || k == 1) continue;
                dp[n][k] = (dp[n - 1][k] + dp[n][k - 1]) % INF;
            }
        }


        bw.write(dp[N][K] + "");
        bw.flush();
        bw.close();
    }


}


