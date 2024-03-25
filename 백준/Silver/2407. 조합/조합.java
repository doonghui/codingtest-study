import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static int N, M;
    static BigInteger ans;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[N];


//        long[][] dp = new long[N + 1][N + 1];
        BigInteger[][] dp = new BigInteger[N + 1][N + 1];
        // nCm = n-1Cm-1 + n-1Cm;
        // m == 1 이거나 n == m 인 경우 고려
        dp[1][1] = BigInteger.valueOf(1);
        dp[2][1] = dp[1][1].add(BigInteger.valueOf(1));
        dp[2][2] = BigInteger.valueOf(1);
        for (int n = 3; n <= N; n++) {
            for (int m = 1; m <= n; m++) {
                if (m == 1) dp[n][m] = dp[n - 1][m].add(BigInteger.valueOf(1));
                else if (n == m) dp[n][m] = dp[n - 1][m - 1];
                else {
                    dp[n][m] = dp[n - 1][m - 1].add(dp[n - 1][m]);

                }
            }
        }

//        ans = new BigInteger("0");
//        solution(check, 0, 0);      // 시간초과
//        bw.write(ans + "");

        bw.write(dp[N][M] + "");
        br.close();
        bw.flush();
        bw.close();
    }

//    static void solution(boolean[] check, int count, int idx) {
//        if (count == M) {
//            ans = ans.add(BigInteger.valueOf(1));
//            return;
//        }
//
//        for (int i = idx; i < N; i++) {
//            if (!check[i]) {
//                check[i] = true;
//                solution(check, count + 1, i + 1);
//                check[i] = false;
//
//            }
//
//        }
//    }


}

