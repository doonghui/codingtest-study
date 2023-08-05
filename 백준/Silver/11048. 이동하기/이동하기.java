import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] dp;
    static int[] dx = { 1, 0, 1};
    static int[] dy = { 0, 1, 1};
    static int max = Integer.MIN_VALUE;




    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }


        dp[0][0] = map[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sol(i,j,map[i][j]);


            }
        }


        bw.write(dp[n-1][m-1] + "");
        br.close();
        bw.flush();
        bw.close();

    }




    static void sol(int x, int y, int sum) {
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx <n && ny >=0 && ny <m) {
                dp[nx][ny]  = Math.max(dp[nx][ny],map[nx][ny]+dp[x][y]);
            }



        }
    }




}