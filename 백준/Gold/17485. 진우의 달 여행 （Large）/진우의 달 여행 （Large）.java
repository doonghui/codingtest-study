import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int N, M;
    static int[][] arr;
    static int[][][] dp;
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        dp = new int[N][M][3];
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
                dp[i][j][2] = Integer.MAX_VALUE;
            }
        }

        for (int m = 0; m < M; m++) {
            dp[0][m][0] = arr[0][m];
            dp[0][m][1] = arr[0][m];
            dp[0][m][2] = arr[0][m];
        }


        for (int x = 0; x < N - 1; x++) {
            for (int y = 0; y < M; y++) {
                if (x == 0) {
                    for (int k = 0; k < 3; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (ny < 0 || ny >= M) continue;

                        dp[nx][ny][k] = Math.min(dp[nx][ny][k], arr[nx][ny] + dp[x][y][k]);

                    }
                } else {
                    for (int dir = 0; dir < 3; dir++) {
                        if (dp[x][y][dir] == Integer.MAX_VALUE) continue;
                        for (int k = 0; k < 3; k++) {
                            if (dir == k) continue;              // 두번 연속으로 움직일 수 없으니!
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (ny < 0 || ny >= M) continue;

                            dp[nx][ny][k] = Math.min(dp[nx][ny][k], arr[nx][ny] + dp[x][y][dir]);


                        }
                    }
                }


            }
        }


        int min = Integer.MAX_VALUE;

        for (int l = 0; l < M; l++) {
            for (int b = 0; b < 3; b++) min = Math.min(min, dp[N - 1][l][b]);
        }


        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}