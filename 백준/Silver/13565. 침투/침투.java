import java.io.*;
import java.util.*;

class Po {
    int x;
    int y;

    Po(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] ch;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static String ans = "NO";

    static void Sol(int y) {
        Queue<Po> Q = new LinkedList<>();
        Q.offer(new Po(0, y));
        ch[0][y] = 1;
        while (!Q.isEmpty()) {
            Po now = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if (arr[nx][ny] == 0 && ch[nx][ny] == 0) {
                    if(nx == m-1){
                        ans = "YES";
                        return;
                    }
                    ch[nx][ny] = 1;
                    Q.offer(new Po(nx, ny));
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        ch = new int[m][n];
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        for (int k = 0; k < n; k++)
            if (arr[0][k] == 0 && ch[0][k] == 0) {
                Sol(k);
            }

        br.close();
        bw.write(ans);
        bw.flush();
        bw.close();


    }
}
