import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Cctv {
    int x;
    int y;
    int type;

    public Cctv(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}


class Main {

    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {0, -1, 0, 1};       // 동북서남
    static int[] dy = {-1, 0, 1, 0};
    static int[][][] dir = {{{}}, {{0}, {1}, {2}, {3}}, {{0, 2}, {1, 3}}, {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, {{0, 1, 2, 3}}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        ArrayList<Cctv> cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv.add(new Cctv(i, j, map[i][j]));
                }
            }
        }

        sol(cctv, cctv.size(), 0, map);


        bw.write(min + "");
        bw.flush();
        br.close();
        bw.close();
    }

    //   0 ,1,2,34.... 끝까지 dx[0].... 하면서 하나하나씩 돌리고
    //   맨 끝에 있는값 dx[1].. 이렇게 또 다 돌리고

    static void sol(ArrayList<Cctv> cctv, int end, int cnt, int[][] map) {
        if (cnt == end) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) sum++;
                }
            }
            min = Math.min(min, sum);
            return;
        }
        int[][] newMap = clone(map);
        for (int i = 0; i < dir[cctv.get(cnt).type].length; i++) {
            for (int j = 0; j < dir[cctv.get(cnt).type][i].length; j++) {
                move(cctv.get(cnt).x, cctv.get(cnt).y, dir[cctv.get(cnt).type][i][j], newMap);

            }
            sol(cctv, end, cnt + 1, newMap);
            newMap = clone(map);        // 다른 방향도 확인해보기 위해 전단계로 되돌린다.
        }


    }


    static void move(int x, int y, int idx, int[][] newMap) {
        int nx = x + dx[idx];
        int ny = y + dy[idx];
        while (true) {
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;
            if (newMap[nx][ny] == 6) break;
            if (newMap[nx][ny] == 0) newMap[nx][ny] = -1;

            nx += dx[idx];
            ny += dy[idx];


        }
    }

    static int[][] clone(int[][] map) {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }


}

