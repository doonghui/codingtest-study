import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int test;
    static int l;
    static int[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int BFS( int sx, int sy, int ex, int ey) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sx, sy));
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx == ex && ny == ey) {
                    return visited[tmp.x][tmp.y]+1;
                }
                if (nx >= 0 && ny >= 0 && nx < l && ny < l && visited[nx][ny] == 0) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = visited[tmp.x][tmp.y]+1;
                }
            }
        }


        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        test = Integer.parseInt(br.readLine());

        while (test-- > 0) {
            l = Integer.parseInt(br.readLine());
            visited = new int[l][l];

            st = new StringTokenizer(br.readLine(), " ");
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            if (sx == ex && sy == ey)
                bw.write(0 + "\n");
            else
                bw.write(BFS(sx, sy, ex, ey) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();


    }

}