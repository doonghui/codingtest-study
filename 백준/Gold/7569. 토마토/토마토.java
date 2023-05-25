import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}

public class Main {

    static int[][][] gragh;
    static int n, m, h;
    static int day = 1;
    static Queue<Point> q = new LinkedList<>();

    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static void bfs() {

        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 6; i++) {
                int nz = tmp.z + dz[i];
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nz >= 1 && nz <= h && nx >= 0 && nx < n && ny >= 0 && ny < m && gragh[nz][nx][ny] == 0) {
                    q.add(new Point(nx, ny,nz));
                    gragh[nz][nx][ny] = gragh[tmp.z][tmp.x][tmp.y] + 1;
                }


            }
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        gragh = new int[h + 1][n][m];

        for (int k = 1; k <= h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    gragh[k][i][j] = Integer.parseInt(st.nextToken());
                    if (gragh[k][i][j] == 1)
                        q.add(new Point(i, j, k));

                }
            }

        }


        bfs();


        LOOP:
        for (int k = 1; k <= h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (gragh[k][i][j] == 0) {
                        day = -1;
                        break LOOP;
                    }
                    day = Math.max(day, gragh[k][i][j]);
                }
            }
        }
        if (day == 1)
            day = 0;
        else if(day > 1)
            day = day -1;

        br.close();
        bw.write(day + "");
        bw.flush();
        bw.close();


    }
}

