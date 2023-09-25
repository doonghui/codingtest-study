import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point {
    int x;
    int y;
    int time;

    public Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {

    static int n, m;
    static int[][] map;
    static ArrayList<Point> virus;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int min = Integer.MAX_VALUE;
    static int emptyPlace = 0;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        virus = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) emptyPlace++;
                if (map[i][j] == 2) {
                    virus.add(new Point(i, j, 0));
                    map[i][j] = -1;
                }
            }
        }

        int[] arr = new int[m];             // n 개의 바이러스중 m개를 넣기 위해
        if (emptyPlace == 0) min = 0;            // 이미 모든 곳이 바이러스일 때
        else {
            dfs(0, 0, arr);
            if (min == Integer.MAX_VALUE) min = -1;
        }

        bw.write(min + "");
        bw.flush();     // 출력
        br.close();
        bw.close();


    }

    static void dfs(int dept, int cnt, int[] arr) {
        if (dept == m) {                // m개 고르면
            int[][] tmpMap = new int[n][n];       // 임시의 map 을 만들고 바이러스들로 채운다.
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    tmpMap[x][y] = map[x][y];
                }
            }

            bfs(arr, tmpMap, emptyPlace);
            return;
        }


        for (int i = cnt; i < virus.size(); i++) {         // 조합으로 바이러스중 m개를 고른다.
            arr[dept] = i;
            dfs(dept + 1, i + 1, arr);
        }


    }

    static void bfs(int[] arr, int[][] tmpMap, int empty) {
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int a = arr[i];
            tmpMap[virus.get(a).x][virus.get(a).y] = 2;
            q.add(new Point(virus.get(a).x, virus.get(a).y, 0));
        }


        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int j = 0; j < 4; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];
                int nTime = p.time + 1;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;           // 맵을 벗어나면 continue
                if (tmpMap[nx][ny] == 0 || tmpMap[nx][ny] == -1 )  {
                    if(tmpMap[nx][ny] == 0) empty--;                                                        // 빈공간 채우기

                    if (empty == 0) {
                        min = Math.min(min, nTime);
                        return;
                    }
                    tmpMap[nx][ny] = nTime;
                    q.add(new Point(nx, ny, nTime));
                }


            }
        }

    }


}
