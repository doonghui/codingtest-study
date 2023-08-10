import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];


        st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        map[x][y] = 2;
        bw.write(sol(x, y, dir, 1) + "");
        br.close();
        bw.flush();
        bw.close();

    }


    static int sol(int x, int y, int dir, int count) {
        boolean flag = false;

        while (!flag) {
            int cnt = 0;

            while (cnt < 4) {
                dir--;
                if (dir < 0) dir = 3;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0) {
                        count++;
                        map[nx][ny] = 2;
                        x = nx;
                        y = ny;
                        break;
                    }
                }
                cnt++;
            }

            if (cnt == 4) {
                int tmp = dir - 2;
                if (tmp == -1) tmp = 3;
                else if (tmp == -2) tmp = 2;
                x = x + dx[tmp];
                y = y + dy[tmp];
                if (x < 0 || x >= n || y < 0 || y >= m) flag = true;
                if(map[x][y] == 1) flag = true;
            }


        }


        return count;
    }


}

