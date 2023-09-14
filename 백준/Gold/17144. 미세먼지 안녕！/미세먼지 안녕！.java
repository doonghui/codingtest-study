import java.awt.*;
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

    static int r, c, t;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Point> cleaner;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        cleaner = new ArrayList<>();
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) cleaner.add(new Point(i, j));
            }
        }
        while (t-- > 0) {
            spread();

            clean();
        }

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] != -1 && map[i][j] !=0) {
                    ans+= map[i][j];
                }

            }
        }


        br.close();
        bw.write(ans+ "\n");


        bw.flush();
        bw.close();

    }

    static void spread() {
        int[][] tmpMap = new int[r][c];
        Queue<Point> q = new LinkedList<>();
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if(map[x][y] == -1 || map[x][y] ==0) continue;

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != -1) {
                        q.add(new Point(nx, ny));
                    }
                }
                int dustSize = q.size();
                int dust = map[x][y] / 5;

                while (!q.isEmpty()) {
                    Point po = q.poll();
                    tmpMap[po.x][po.y] += dust;
                }

                map[x][y] = map[x][y] - (dust * dustSize);
            }
        }


        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                map[x][y] += tmpMap[x][y];
            }
        }
    }

    static void clean() {
        for (int a = 0; a < 2; a++) {
            int cX = cleaner.get(a).x;
            int value = 0;
            if (a == 0) {
                value = rightClean(cX);
                value = upClean(new Point(cX, c - 1), new Point(0, c - 1), value);
                value = leftClean(0, value);
                downClean(new Point(0, 0), new Point(cX, 0), value);
            } else {
                value = rightClean(cX);
                value = downClean(new Point(cX, c-1), new Point(r-1, c-1), value);
                value = leftClean(r-1, value);
                upClean(new Point(r-1, 0), new Point(cX, 0), value);
            }
        }
    }

    static int upClean(Point startP, Point endP, int value) {
        int tmp = map[endP.x][endP.y];
        for (int x = endP.x; x < startP.x -1; x++) {
            if(map[x][endP.y] != -1)
                map[x][endP.y] = map[x + 1][endP.y];
        }

        map[startP.x-1][startP.y] = value;


        return tmp;
    }

    static int downClean(Point startP, Point endP,int value) {
        int tmp = map[endP.x][endP.y];
        for (int x = endP.x; x > startP.x+1; x--) {
            if(map[x][endP.y] != -1)
                map[x][endP.y] = map[x - 1][endP.y];
        }

        map[startP.x+1][startP.y] = value;

        return tmp;
    }

    static int leftClean(int cX, int value) {
        int tmp = map[cX][0];
        for (int y = 0; y < c - 1; y++) {
            map[cX][y] = map[cX][y + 1];
        }

        map[cX][c -2] = value;

        return tmp;
    }

    static int rightClean(int cX) {
        int tmp = map[cX][c-1];
        for (int y = c - 1; y >= 2; y--) {
            map[cX][y] = map[cX][y - 1];
        }

        map[cX][1] = 0;         // 공기청정기 바로 오른쪽

        return tmp;
    }


}





