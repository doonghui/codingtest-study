import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {

    static int[][] gragh;
    static int[][] visited;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = 1;


        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx == n - 1 && ny == m - 1) {
                    return visited[tmp.x][tmp.y] + 1;
                }
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && gragh[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[tmp.x][tmp.y] + 1;
                    q.add(new Point(nx, ny));
                }


            }
        }

        return 0;

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        gragh = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                gragh[i][j] = str.charAt(j)-'0';
            }
        }

        visited = new int[n][m];


        int count = BFS(0, 0);


        br.close();
        bw.write(count+ " " );
        bw.flush();
        bw.close();


    }
}

