import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Main {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            visited = new boolean[n][n];
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i,j);
                    }

                }
            }
            if(!flag) break;
            count++;
        }


        br.close();
        bw.write(count + "");
        bw.flush();
        bw.close();

    }


    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        Queue<Point> updateQ = new LinkedList<>();          // 인구이동을 위해
        int sum = map[x][y];
        int num = 1;
        q.add(new Point(x, y));
        updateQ.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = tmp.x + dx[k];
                int ny = tmp.y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;
                int sub = Math.abs(map[tmp.x][tmp.y] - map[nx][ny]);
                if (sub >= l && sub <= r){
                    sum += map[nx][ny];
                    num += 1;
                    visited[nx][ny]=true;
                    flag=true;
                    q.add(new Point(nx, ny));
                    updateQ.add(new Point(nx, ny));
                }

            }
        }


        while (!updateQ.isEmpty()) {
            Point updateTmp = updateQ.poll();
            map[updateTmp.x][updateTmp.y] = sum / num;
        }
    }

}

