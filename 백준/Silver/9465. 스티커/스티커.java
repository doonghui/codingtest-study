import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int T, N;
    static int[][] map;
    static int[][] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            map = new int[2][N];
            dp = new int[2][N];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < N; k++) map[j][k] = Integer.parseInt(st.nextToken());
            }
            bw.write(solution() + "\n");
        }


        bw.flush();
        bw.close();
    }

    // 98퍼에서 틀림 ArrayIndexOutOfBounds
    static int solution() {
        int max = 0;
        if (N == 1) {
            max = Math.max(map[0][0], map[1][0]);
        } else if (N == 2) {
            max = Math.max(map[0][0] + map[1][1], map[0][1] + map[1][0]);
        } else {
            dp[0][0] = map[0][0];
            dp[1][0] = map[1][0];
            dp[0][1] = map[0][1] + map[1][0];
            dp[1][1] = map[0][0] + map[1][1];

            for (int i = 2; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + map[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + map[1][i];

            }

            max = Math.max(dp[0][N - 1], dp[1][N - 1]);
        }


        return max;
    }
}


//2
//4
//50 40 19 18
//40 20 40 20
//4
//40 40 39 40
//40 40 40 40