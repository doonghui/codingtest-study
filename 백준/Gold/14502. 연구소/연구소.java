import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = Integer.MIN_VALUE;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }


        wallMaking(map, 0);


        bw.write(max + "");
        br.close();
        bw.flush();
        bw.close();

    }


    static void wallMaking(int[][] map, int wallCnt) {
        if (wallCnt == 3) {
            int[][] newMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) newMap[i][j] = map[i][j];
            }
            sol(newMap);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    wallMaking(map, wallCnt + 1);
                    map[i][j] = 0;

                }


            }
        }


    }

    static void sol(int[][] newMap) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMap[i][j] == 2) {
                    newMap[i][j] = 1;
                    bfs(i, j, newMap);
                }
            }
        }
        maxArea(newMap);

    }

    static void bfs(int x, int y, int[][] newMap) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (newMap[nx][ny] == 0) {
                        newMap[nx][ny] = 1;
                        q.add(new Point(nx, ny));
                    }

                }


            }
        }

    }


    static void maxArea(int[][] newMap) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMap[i][j] == 0) cnt++;
            }
        }
        if (max < cnt) max = cnt;

    }


}