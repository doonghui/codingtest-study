import java.io.*;
import java.util.*;

public class Main {

    static int[][] gragh;
    static int max = 0;
    static int n, m, v;
    static int tmp = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void DFS(int x, int y) {
        tmp +=1;
        gragh[x][y] = 0;
        for (int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if (nx > 0 && nx <= n && ny > 0 && ny <= m && gragh[nx][ny] == 1) {

                DFS(nx, ny);
            }
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        gragh = new int[n + 1][m + 1];

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gragh[a][b] = 1;
        }


        for (int x = 1; x < n + 1; x++) {
            for (int y = 1; y < m + 1; y++) {

                if (gragh[x][y] == 1) {
                    DFS(x, y);
                    max = Math.max(max,tmp);
                    tmp = 0;
                }

            }
        }

        br.close();
        bw.write(max+"");
        bw.flush();
        bw.close();


    }
}

