import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int N;
    static int[][] map;
    static long[][] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];                // int로 하면 틀리는 듯

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int zero = map[0][0];
        dp[zero][0] = 1;
        dp[0][zero] = 1;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int n = map[x][y];
                if (x == N - 1 && y == N - 1) continue;
                if (dp[x][y] < 1) continue;

                if (x + n < N) dp[x + n][y] += dp[x][y];
                if (y + n < N) dp[x][y + n] += dp[x][y];


            }

        }

        bw.write(dp[N - 1][N - 1] + "");
        bw.flush();
        bw.close();
    }


}


