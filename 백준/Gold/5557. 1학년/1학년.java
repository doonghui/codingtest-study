import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int N, K;
    static int[] arr;
    static long[][] dp;
    static int INF = 1_000_000_000;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N - 1];
        int tmp = 0;
        int answer = 0;

        dp = new long[N][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i == N - 1) answer = Integer.parseInt(st.nextToken());
            else
                arr[i] = Integer.parseInt(st.nextToken());
        }


        dp[0][arr[0]] = 1;      // 맨 처음 수 초기화

        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] == 0) continue;
                // 중간에 나오는 수가 0~20 사이여야만 함.
                if (j + arr[i] <= 20) {
                    if (dp[i][j + arr[i]] == 0) dp[i][j + arr[i]] = dp[i - 1][j];
                    else
                        dp[i][j + arr[i]] += dp[i - 1][j];
                }

                if (j - arr[i] >= 0) {
                    if (dp[i][j - arr[i]] == 0) dp[i][j - arr[i]] = dp[i - 1][j];
                    else
                        dp[i][j - arr[i]] += dp[i - 1][j];
                }
            }

        }


        bw.write(dp[N - 2][answer] + "");
        bw.flush();
        bw.close();
    }
}