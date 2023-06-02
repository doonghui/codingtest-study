import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int cnt = 0;
    static boolean flag = false;

    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    static void dfs(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (arr[nx][ny] > arr[x][y])
                    flag = true;
                if (arr[nx][ny] == arr[x][y] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }

            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (!visited[x][y]) {
                    dfs(x, y);
                    if (flag) {
                        flag = false;
                    } else
                        cnt++;

                }
            }
        }


        br.close();
        bw.write(cnt + " ");
        bw.flush();
        bw.close();


    }
}

